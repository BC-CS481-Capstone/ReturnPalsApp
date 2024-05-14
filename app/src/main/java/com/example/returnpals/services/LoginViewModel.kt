package com.example.returnpals.services
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    email: String = LoginRepository.email ?: "",
    password: String = ""
): ViewModel() {

    // Condition variables
    // .. LiveData was causing issues (reading as false when its supposed to be true), mutableStateOf seems to work
    // .. might be a jetpack compose thing
    var signUpSuccessful by mutableStateOf(false)
        private set
    var isLoggedIn by mutableStateOf(false)
        private set

    var email by mutableStateOf(email) // test@bellevue.college
    var password by  mutableStateOf(password) // Password123$
    var failMessage by mutableStateOf("")
    val isGuest get() = LoginRepository.isGuest

    init {
        Log.d("LoginViewModel", "init")
        viewModelScope.launch(Dispatchers.Main) { // Crashes here if we use Dispatchers.IO
            try {
                isLoggedIn = LoginRepository.isLoggedIn()
            } catch(error: AuthException) {
                Log.e("LoginViewModel", "Failed to determine if user is logged in!")
            }
        }
    }

    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                LoginRepository.register(email, password)
                signUpSuccessful = true
                failMessage = ""
            } catch (error: AuthException) {
                signUpSuccessful = false
                failMessage = error.message + error.recoverySuggestion
            }
        }
    }

    fun logIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isLoggedIn) LoginRepository.logOut()
                LoginRepository.logIn(email, password)
                isLoggedIn = LoginRepository.isLoggedIn()
                signUpSuccessful = !isLoggedIn
                failMessage = ""
            } catch(error: AuthException) {
                isLoggedIn = false
                failMessage = error.message + error.recoverySuggestion
                error.message?.let { message ->
                    if (message.contains("User not confirmed in the system.")) {
                        signUpSuccessful = true
                        accessEmail()
                    }
                }
            }
            if (!isLoggedIn) Log.e("LoginViewModel", "Failed to log in!")
        }
    }

    fun logOut() {
        Log.d("LoginViewModel", "logOut")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isLoggedIn) LoginRepository.logOut()
                isLoggedIn = LoginRepository.isLoggedIn()
            } catch(error: AuthException) {
                Log.e("LoginViewModel", "Failed to log out!")
            }
            if (isLoggedIn) Log.e("LoginViewModel", "Failed to log out!")
        }
    }

    fun logInAsGuest() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isLoggedIn) LoginRepository.logOut()
                LoginRepository.logInAsGuest(email)
                isLoggedIn = LoginRepository.isLoggedIn()
                signUpSuccessful = !isLoggedIn
                failMessage = ""
            } catch(error: AuthException) {
                isLoggedIn = false
                failMessage = error.message + error.recoverySuggestion
            }
            if (!isLoggedIn) Log.e("LoginViewModel", "Failed to log in as guest!")
        }
    }
}