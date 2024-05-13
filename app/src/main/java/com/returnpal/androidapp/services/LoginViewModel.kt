package com.returnpal.androidapp.services
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.returnpal.androidapp.services.Backend.accessEmail
import com.returnpal.androidapp.services.backend.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Login View model provides the information and function needed to login, logout, and signup.
class LoginViewModel(
//    private val repository: LoginRepository
): ViewModel() {

    // Condition variables
    private val _logInSuccessful = MutableLiveData(false)
    val logInSuccessful: LiveData<Boolean> = _logInSuccessful
    private val _signUpSuccessful = MutableLiveData(false)
    val signUpSuccessful: LiveData<Boolean> = _signUpSuccessful

    var email by mutableStateOf(LoginRepository.email ?: "") // test@bellevue.college
    var password by  mutableStateOf("") // Password123$
    var failMessage by mutableStateOf("")
    val isGuest get() = LoginRepository.isGuest

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _logInSuccessful.postValue(LoginRepository.isLoggedIn())
        }
    }

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            LoginRepository.register(email, password)?.let { error ->
                _signUpSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
            } ?: _signUpSuccessful.postValue(true)
        }
    }

    fun logIn() {
        viewModelScope.launch(Dispatchers.IO) {
            LoginRepository.logIn(email, password)?.let { error ->
                _logInSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
                error.message?.let {  message ->
                    if (message.contains("User not confirmed in the system.")) {
                        _signUpSuccessful.postValue(true)
                        accessEmail()
                    }
                }
            } ?: _logInSuccessful.postValue(true)
        }
    }

    fun logInAsGuest() {
        viewModelScope.launch(Dispatchers.IO) {
            val error = LoginRepository.logInAsGuest(email)
            if (error != null) {
                _logInSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
            } else {
                _logInSuccessful.postValue(true)
            }
        }
    }

    fun checkUser() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _logInSuccessful.postValue(repository.isLoggedIn())
//        }
    }

    fun reset() {
        //Reset the boolean values to false and error messages to empty
        _signUpSuccessful.postValue(false)
        _logInSuccessful.postValue(false)
        failMessage = ""
    }
}