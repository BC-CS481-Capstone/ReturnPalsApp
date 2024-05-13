package com.example.returnpals.services
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.auth.AuthException
import com.example.returnpals.services.Backend.accessEmail
import com.example.returnpals.services.backend.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Login View model provides the information and function needed to login, logout, and signup.
class LoginViewModel(
//    private val repository: LoginRepository       login repo is a global object for now
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
            try {
                _logInSuccessful.postValue(LoginRepository.isLoggedIn())
            } catch(error: AuthException) {
                Log.e("LoginViewModel", "Failed to determine if user is logged in!")
            }
        }
    }

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                LoginRepository.register(email, password)
                _signUpSuccessful.postValue(true)
            } catch (error: AuthException) {
                _signUpSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
            }
        }
    }

    fun logIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                LoginRepository.logIn(email, password)
                _logInSuccessful.postValue(true)
            } catch(error: AuthException) {
                _logInSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
                error.message?.let { message ->
                    if (message.contains("User not confirmed in the system.")) {
                        _signUpSuccessful.postValue(true)
                        accessEmail()
                    }
                }
            }
        }
    }

    fun logOut() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                LoginRepository.logOut()
                _logInSuccessful.postValue(false)
            } catch(error: AuthException) {
                Log.e("LoginViewModel", "Failed to log out!")
            }
        }
    }

    fun logInAsGuest() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                LoginRepository.logInAsGuest(email)
                _logInSuccessful.postValue(true)
            } catch(error: AuthException) {
                _logInSuccessful.postValue(false)
                failMessage = error.message + error.recoverySuggestion
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