
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthSession
import com.amplifyframework.auth.result.AuthResetPasswordResult
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Address
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.amplifyframework.api.graphql.GraphQLResponse
import com.amplifyframework.core.Consumer
import com.amplifyframework.api.ApiException
import com.amplifyframework.api.graphql.PaginatedResult
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.model.Model
import kotlin.random.Random
import androidx.compose.runtime.livedata.observeAsState



class SettingsViewModel : ViewModel() {

    private val _operationStatus = MutableStateFlow<String?>(null)
    val operationStatus: StateFlow<String?> = _operationStatus

    private val _userEmail = MutableStateFlow<String?>(null)
    val userEmail: StateFlow<String?> = _userEmail

    private val _userAddresses = MutableStateFlow<List<SimpleAddress>>(emptyList())
    val userAddresses: StateFlow<List<SimpleAddress>> = _userAddresses

    private val _addresses = MutableStateFlow<Map<Int, String>>(mapOf())
    val addresses: StateFlow<Map<Int, String>> = _addresses

    private val _selectedAddressId = MutableStateFlow<Int?>(null)
    val selectedAddressId: StateFlow<Int?> = _selectedAddressId

    fun selectAddress(id: Int) {
        _selectedAddressId.value = id
    }

    fun addAddress(id: Int, address: String) {
        _addresses.value = _addresses.value.toMutableMap().apply {
            put(id, address)
        }
    }

    init {
        fetchUserEmail()
        fetchAddresses()
    }

    private fun fetchUserEmail() {
        viewModelScope.launch {
            try {
                Amplify.Auth.fetchAuthSession(
                    { authSession: AuthSession ->
                        if (authSession.isSignedIn) {
                            // Now fetch user attributes since the user is signed in
                            Amplify.Auth.fetchUserAttributes(
                                { attributes ->
                                    val emailAttribute =
                                        attributes.firstOrNull { it.key.keyString == "email" }
                                    _userEmail.value = emailAttribute?.value
                                },
                                { error: AuthException ->
                                    _operationStatus.value =
                                        "Error fetching user email: ${error.localizedMessage}"
                                }
                            )
                        } else {
                            _operationStatus.value = "User is not signed in"
                        }
                    },
                    { error: AuthException ->
                        _operationStatus.value =
                            "Error fetching auth session: ${error.localizedMessage}"
                    }
                )
            } catch (e: AuthException) {
                _operationStatus.value = "Error fetching user info: ${e.localizedMessage}"
            }
        }
    }

    fun resetPassword(newPassword: String) {
        val email = _userEmail.value
        if (email.isNullOrEmpty()) {
            _operationStatus.value = "Error: No email found for the user."
            return
        }

        viewModelScope.launch {
            try {
                Amplify.Auth.resetPassword(
                    email,
                    { result: AuthResetPasswordResult ->
                        if (result.isPasswordReset) {
                            _operationStatus.value = "Password reset email sent successfully."
                        } else {
                            _operationStatus.value =
                                "Password reset initiated. Please check your email for the confirmation code."
                        }
                    },
                    { error: AuthException ->
                        _operationStatus.value =
                            "Error resetting password: ${error.localizedMessage}"
                    }
                )
            } catch (e: AuthException) {
                _operationStatus.value = "Error resetting password: ${e.localizedMessage}"
            }
        }
    }

    fun confirmResetPassword(newPassword: String, confirmationCode: String) {
        viewModelScope.launch {
            try {
                val userEmail =
                    _userEmail.value ?: return@launch // Get the user email or exit if null

                Amplify.Auth.confirmResetPassword(
                    userEmail, // or username
                    newPassword,
                    confirmationCode,
                    {
                        // This is the success callback
                        _operationStatus.value = "Password has been reset successfully."
                    },
                    { error ->
                        // This is the error handling callback
                        _operationStatus.value =
                            "Error confirming password reset: ${error.localizedMessage}"
                    }
                )
            } catch (e: AuthException) {
                _operationStatus.value = "Error confirming password reset: ${e.localizedMessage}"
            }
        }
    }

    fun fetchAddresses() {
        viewModelScope.launch {
            Amplify.API.query(
                ModelQuery.list(Address::class.java),  // Correct Model class reference
                { response: GraphQLResponse<PaginatedResult<Address>> ->  // Correct lambda parameter type
                    if (response.hasData()) {
                        Log.d("MyAmplifyApp", "Addresses fetched: ${response.data.items} found")
                        val filteredAddresses = response.data.items.map { address ->
                            SimpleAddress(address.address)
                        }
                        _userAddresses.value = filteredAddresses
                    } else if (response.hasErrors()) {
                        Log.e("MyAmplifyApp", "Error fetching addresses: ${response.errors.first().message}")
                    }
                },
                { error: ApiException ->  // Correct error handling lambda parameter type
                    Log.e("MyAmplifyApp", "Query failed: ${error.localizedMessage}", error)
                }
            )
        }
    }

    data class SimpleAddress(val address: String,) : Model


    fun addNewAddress(address: String) {
        val userId = generateRandomUserId()
        viewModelScope.launch {
            val newAddress = Address.builder()
                .address(address)
                .userId(userId)
                .build()

            try {
                Amplify.API.mutate(
                    ModelMutation.create(newAddress),
                    { response ->
                        Log.i("MyAmplifyApp", "Address created: ${response.data.id}")
                        fetchAddresses()  // Optionally refresh addresses after adding
                        _operationStatus.value = "Address added successfully with ID: ${response.data.id}"
                    },
                    { error ->
                        Log.e("MyAmplifyApp", "Failed to add address", error)
                        _operationStatus.value = "Error adding address: ${error.localizedMessage}"
                    }
                )
            } catch (e: ApiException) {
                Log.e("MyAmplifyApp", "API Exception when trying to add address", e)
                _operationStatus.value = "Exception when adding address: ${e.localizedMessage}"
            }
        }
    }

    fun generateRandomUserId(): String {
        return Random.nextInt(100000, 999999).toString()  // Generate a random number between 100000 and 999999
    }

    fun deleteAddress(address: SimpleAddress) {
        viewModelScope.launch {
            try {
                Amplify.API.mutate(
                    ModelMutation.delete(address),
                    { response ->
                        Log.i("MyAmplifyApp", "Successfully deleted address with ID: ${response.data}")
                        fetchAddresses()  // Refresh the list of addresses if needed
                        _operationStatus.value = "Address deleted successfully."
                    },
                    { error ->
                        Log.e("MyAmplifyApp", "Deletion failed: ${error.localizedMessage}", error)
                        _operationStatus.value = "Error deleting address: ${error.localizedMessage}"
                    }
                )
            } catch (e: ApiException) {
                Log.e("MyAmplifyApp", "API Exception when trying to delete address", e)
                _operationStatus.value = "Exception when deleting address: ${e.localizedMessage}"
            }
        }
    }


}




