package com.example.returnpals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.dataRepository.ContactRepository

class ContactViewModel(
    private val contactRepository: ContactRepository
) : ViewModel() {
    // You can expose LiveData or StateFlow for observing the operation's result in the UI
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful
    //TODO MOVE state to View Model

    fun submitData(fullName: String, postalCode: String, email: String, message: String) {
        contactRepository.submitData(fullName,postalCode,email,message){it,id->
            _submissionSuccessful.postValue(it)
            if (it) resetSubmissionSuccess()
        }
    }

    fun resetSubmissionSuccess() {
        _submissionSuccessful.value = null // Reset the LiveData to its initial state
    }
}
