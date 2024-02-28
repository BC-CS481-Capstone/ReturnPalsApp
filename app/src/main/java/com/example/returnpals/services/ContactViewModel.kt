package com.example.returnpals.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amplifyframework.datastore.generated.model.MailingList

class ContactViewModel : ViewModel() {
    // You can expose LiveData or StateFlow for observing the operation's result in the UI
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful

    fun submitData(fullName: String, postalCode: String, email: String, message: String) {
        val model = MailingList.builder()
            .fullName(fullName)
            .postalCode(postalCode)
            .email(email)
            .message(message)
            .build()

        AmplifyOperations.sendMailingListData(model,
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
