
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


class SettingsViewModel : ViewModel() {

    private val _operationStatus = MutableStateFlow<String?>(null)
    val operationStatus: StateFlow<String?> = _operationStatus

    private val _userEmail = MutableStateFlow<String?>(null)
    val userEmail: StateFlow<String?> = _userEmail

    private val _userAddresses = MutableStateFlow<List<Address>>(emptyList())
    val userAddresses: StateFlow<List<Address>> = _userAddresses

    init {
        fetchUserEmail()
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
        Log.d("MyAmplifyApp", "Attempting to fetch addresses...")
        viewModelScope.launch {
            Amplify.API.query(
                ModelQuery.list(Address::class.java),
                { response ->
                    if (response.hasData()) {
                        Log.d("MyAmplifyApp", "Addresses fetched: ${response.data.items} found")
                        _userAddresses.value = response.data.items as List<Address>
                    } else if (response.hasErrors()) {
                        Log.e("MyAmplifyApp", "Error fetching addresses: ${response.errors.first().message}")
                    }
                },
                { error ->
                    Log.e("MyAmplifyApp", "Query failed: ${error.localizedMessage}", error)
                }
            )
        }
    }
}


