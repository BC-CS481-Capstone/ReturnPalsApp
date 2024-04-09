package com.example.returnpals.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

class RegisterViewModel : ViewModel(){
    // You can expose LiveData or StateFlow for observing the operation's result in the UI
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful

    fun submitRegistration(firstName: String, lastName: String, email: String, address: List<String>, phoneNumber: String) {
        val model = User.builder()
            .email(email)
            .subscription(PricingPlan.BRONZE)
            .firstName(firstName)
            .lastName(lastName)
            .phone(phoneNumber)
            .build()

        AmplifyOperations.sendRegistrationData(model,
            onSuccess = { id ->
                _submissionSuccessful.postValue(true)

            },
            onError = { error ->
                _submissionSuccessful.postValue(false)
            }
        )
    }

    fun resetSubmissionSuccess() {
        _submissionSuccessful.value = null // Reset the LiveData to its initial state
    }
}




