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
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// this view model is complex because repo operations are asynchronous and view model operations
// can be called by anyone who has a reference to it
// meaning we have to orchestrate io operations that complete on their own time
// to somehow work with jetpack compose

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
    var isLoggedIn by mutableStateOf<Boolean?>(null)
        private set

    var email by mutableStateOf(email) // test@bellevue.college
    var password by  mutableStateOf(password) // Password123$
    var failMessage by mutableStateOf("")
    val isGuest get() = LoginRepository.isGuest

    init {
        Log.d("LoginViewModel", "initializing...")
        viewModelScope.launch(Dispatchers.Main) { // Crashes here if we use Dispatchers.IO
            try {
                withContext(Dispatchers.IO) {
                    runBlocking { isLoggedIn = LoginRepository.isLoggedIn() }
                }
            } catch(error: AuthException) {
                Log.e("LoginViewModel", "Failed to determine if user is logged in!")
            }
            // init may complete after one of the methods below which can result in wierd behavior...
            Log.d("LoginViewModel", "initialized")
        }
    }

    fun register(context: CoroutineContext = viewModelScope.coroutineContext) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    LoginRepository.register(email, password)
                    signUpSuccessful = true
                    failMessage = ""
                } catch (error: AuthException) {
                    signUpSuccessful = false
                    failMessage = error.message + '\n' + error.recoverySuggestion
                }
            }
        }
    }

    fun logIn(context: CoroutineContext = viewModelScope.coroutineContext) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    isLoggedIn = null
                    isLoggedIn = LoginRepository.isLoggedIn()
                    if (isLoggedIn == true) LoginRepository.logOut()
                    LoginRepository.logIn(email, password)
                    isLoggedIn = true
                    failMessage = ""
                } catch (error: AuthException) {
                    failMessage = error.message + '\n' + error.recoverySuggestion
                    error.message?.let { message ->
                        if (message.contains("User not confirmed in the system.")) {
                            signUpSuccessful = true
                            accessEmail()
                        }
                    }
                }
            }
        }
    }

    fun logOut(context: CoroutineContext = viewModelScope.coroutineContext) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    isLoggedIn = null
                    isLoggedIn = LoginRepository.isLoggedIn()
                    if (isLoggedIn == true) LoginRepository.logOut()
                    isLoggedIn = false
                } catch (error: AuthException) {
                    Log.e("LoginViewModel", "Failed to log out!")
                }
            }
        }
    }

    fun logInAsGuest(context: CoroutineContext = viewModelScope.coroutineContext) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    isLoggedIn = null
                    isLoggedIn = LoginRepository.isLoggedIn()
                    if (isLoggedIn == true) LoginRepository.logOut()
                    LoginRepository.logInAsGuest(email)
                    isLoggedIn = true
                    failMessage = ""
                } catch (error: AuthException) {
                    failMessage = error.message + '\n' + error.recoverySuggestion
                }
            }
        }
    }
}