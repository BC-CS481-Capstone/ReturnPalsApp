package com.example.returnpals.services

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


    fun submitRegistration(firstName: String, lastName: String, email: String, address: String, phoneNumber: String) {
        val model = User.builder()
            .email(email)
            .subscription(PricingPlan.BRONZE)
            .firstName(firstName)
            .lastName(lastName)
            .phone(phoneNumber)
            .build()

        var userId = ""
        Amplify.API.mutate(ModelMutation.create(model),{
            if (it.hasErrors()) {
                _submissionSuccessful.postValue(false)
                failMessage = it.errors.first().message
            } else {
                userId = it.data.id

                val addressDefault = Address.builder().address(address).userId(userId).nickName("Default").userEmail(email).build()
                Amplify.API.mutate(ModelMutation.create(addressDefault),
                    { if (it.hasErrors()){
                        failMessage = it.errors.first().message
                    } else {
                        _submissionSuccessful.postValue(true)
                    } },
                    { failMessage = it.message!! }
                )
            } },
            {
                failMessage = it.message!!
                _submissionSuccessful.postValue(false)
            })
    }

    fun resetSubmissionSuccess() {
        _submissionSuccessful.value = null // Reset the LiveData to its initial state
    }
}




