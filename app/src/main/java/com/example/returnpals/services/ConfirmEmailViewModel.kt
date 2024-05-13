package com.example.returnpals.services

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.returnpals.services.backend.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfirmEmailViewModel: ViewModel() {
    //View model for confirm number. Sends data to amplify (confirm number)

    // Condition variable
    private val _confirmSuccessful = MutableLiveData(false)
    val confirmSuccessful: LiveData<Boolean> = _confirmSuccessful

    var code =  mutableStateOf("")
    var message = mutableStateOf("")
    val email = LoginRepository.email ?: ""

    fun confirm() {
        viewModelScope.launch(Dispatchers.IO) {
            if (LoginRepository.confirmEmail(code.value))
                _confirmSuccessful.value = true
            else message.value = "Nope"
        }
    }
}