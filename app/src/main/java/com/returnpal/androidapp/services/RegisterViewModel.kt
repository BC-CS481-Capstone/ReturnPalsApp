package com.returnpal.androidapp.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Address
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

class RegisterViewModel : ViewModel(){
    // You can expose LiveData or StateFlow for observing the operation's result in the UI
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful
    var failMessage = ""

    companion object {
        private const val TAG = "ReturnPalsApp"
    }


    fun submitRegistration(firstName: String, lastName: String, email: String, address: String, phoneNumber: String) {
        Log.i(TAG, "Submitting registration for user: $email")

        val user = User.builder()
            .email(email)
            .subscription(PricingPlan.BRONZE)
            .firstName(firstName)
            .lastName(lastName)
            .phone(phoneNumber)
            .build()

        Log.i(TAG, "User model built, starting mutation.")

        Amplify.API.mutate(
            ModelMutation.create(user),
            { response ->
                if (response.hasErrors()) {
                    Log.e(TAG, "Error during user registration: ${response.errors.first().message}")
                    _submissionSuccessful.postValue(false)
                    failMessage = response.errors.first().message
                } else {
                    Log.i(TAG, "User registered successfully with ID: ${response.data.id}")
                    val userId = response.data.id

                    val addressModel = Address.builder()
                        .address(address)
                        .userId(userId)
                        .nickName("Default")
                        .userEmail(email)
                        .build()

                    Log.i(TAG, "Address model built, starting mutation for address.")

                    Amplify.API.mutate(
                        ModelMutation.create(addressModel),
                        {
                            if (it.hasErrors()) {
                                Log.e(TAG, "Error creating address for $email: ${it.errors.first().message}")
                                failMessage = it.errors.first().message
                            } else {
                                Log.i(TAG, "Address created successfully for $email")
                                _submissionSuccessful.postValue(true)
                            }
                        },
                        {
                            Log.e(TAG, "Failed to create address due to network error: ${it.message}", it)
                            _submissionSuccessful.postValue(false)
                        }
                    )
                }
            },
            {
                Log.e(TAG, "Failed to register user due to network error: ${it.message}", it)
                _submissionSuccessful.postValue(false)
            }
        )
    }

    fun resetSubmissionSuccess() {
        _submissionSuccessful.value = null // Reset the LiveData to its initial state
    }
}




