package com.example.returnpals.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.returnpals.services.backend.LoginRepository
import com.example.returnpals.services.backend.RepoResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class ConfirmEmailViewModel(
    val email: String = LoginRepository.email ?: ""
) : ViewModel() {
    //View model for confirm number. Sends data to amplify (confirm number)

    // Condition variable
    private val _confirmSuccessful = MutableLiveData(false)
    val confirmSuccessful: LiveData<Boolean> = _confirmSuccessful

    var code by  mutableStateOf("")
    var message by mutableStateOf("")

    fun confirm(context: CoroutineContext = viewModelScope.coroutineContext) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.confirmEmail(code)
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> _confirmSuccessful.postValue(true)
                        RepoResult.INCOMPLETE -> message = result.message
                        RepoResult.PARTIAL -> message = result.message
                        RepoResult.FAILURE -> message = result.message
                    }
                }
            }
        }
    }

}