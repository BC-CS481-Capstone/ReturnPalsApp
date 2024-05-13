package com.example.returnpals.services
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.services.Backend.accessEmail
import com.example.returnpals.services.backend.SessionRepository

//Login View model provides the information and function needed to login, logout, and signup.
class LoginViewModel(): ViewModel() {

    // Condition variables
    private val _logInSuccessful = MutableLiveData(false)
    val logInSuccessful: LiveData<Boolean> = _logInSuccessful
    private val _signUpSuccessful = MutableLiveData(false)
    val signUpSuccessful: LiveData<Boolean> = _signUpSuccessful

    var email = mutableStateOf("") // test@bellevue.college
    var password =  mutableStateOf("") // Password123$
    var isGuest = mutableStateOf(false)
    var failMessage = mutableStateOf("")

    init {
        SessionRepository.update {
            _logInSuccessful.postValue(SessionRepository.isSignedIn)
            email.value = SessionRepository.email
            isGuest.value = SessionRepository.isGuest
        }
    }

    fun signUp() {
        SessionRepository.signUp(email.value, password.value,
            onError = {
                _signUpSuccessful.postValue(false)
                it?.let { failMessage.value = it.message + it.recoverySuggestion }
            }
        ) {
            _signUpSuccessful.postValue(true)
        }
    }

    fun signIn() {
        SessionRepository.signIn(email.value, password.value,
            onError = {
                _logInSuccessful.postValue(false)
                it?.let { error ->
                    failMessage.value = error.message + error.recoverySuggestion
                    if (error.message!!.contains("User not confirmed in the system.")) {
                        _signUpSuccessful.postValue(true)
                        accessEmail()
                    }
                }
            }
        ) {
            _logInSuccessful.postValue(true)
        }
    }

    fun signInAsGuest() {
        SessionRepository.signInAsGuest(email.value,
            onError = {
                _logInSuccessful.postValue(false)
                it?.let { failMessage.value = it.message + it.recoverySuggestion }
            }
        ) {
            isGuest.value = true
            _logInSuccessful.postValue(true)
        }
    }

    fun checkUser() {
        SessionRepository.update {
            if (SessionRepository.isSignedIn || SessionRepository.isGuest) {
                _logInSuccessful.postValue(true)
            } else {
                _logInSuccessful.postValue(false)
            }
        }
    }

    fun reset() {
        //Reset the boolean values to false and error messages to empty
        _signUpSuccessful.postValue(false)
        _logInSuccessful.postValue(false)
        failMessage.value = ""
    }
}