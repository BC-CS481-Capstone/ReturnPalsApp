package com.example.returnpals.services

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.services.backend.SessionRepository

class ConfirmEmailViewModel: ViewModel() {
    //View model for confirm number. Sends data to amplify (confirm number)

    // Condition variable
    private val _confirmSuccessful = MutableLiveData(false)
    val confirmSuccessful: LiveData<Boolean> = _confirmSuccessful

    var code =  mutableStateOf("")
    var message = mutableStateOf("")
    val email = SessionRepository.email ?: ""

    fun confirm() {
        SessionRepository.validateEmail(code.value,
            onError = { it?.let { message.value = it.message + it.recoverySuggestion } }
        ) {
            _confirmSuccessful.value = true
        }
    }
}