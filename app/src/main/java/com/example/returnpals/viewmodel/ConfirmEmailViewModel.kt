package com.example.returnpals.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.auth.AuthException
import com.example.returnpals.dataRepository.LoginRepositoryAmplify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class ConfirmEmailViewModel(
    val email: String = LoginRepositoryAmplify.email ?: ""
) : ViewModel() {
    //View model for confirm number. Sends data to amplify (confirm number)

    // Condition variable
    private val _confirmSuccessful = MutableLiveData(false)
    val confirmSuccessful: LiveData<Boolean> = _confirmSuccessful

    var code by  mutableStateOf("")
    var message by mutableStateOf("")

    fun confirm() {
        confirmEmail(code,
            onFailure={ message = it.message ?: "" }
        ) {
        }
    }

    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */
    private fun confirmEmail(
        code: String,
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        val lambda:(Boolean,String,String)->Unit =  {it,message,recoverSuggestion ->
            _confirmSuccessful.postValue(it)
            if (!it) {
                this.message = message+'\n'+ recoverSuggestion
            }
        }
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    LoginRepositoryAmplify.confirmEmail(code, lambda,email)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                }
            }
        }
    }

}