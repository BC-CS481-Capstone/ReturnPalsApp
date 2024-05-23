package com.example.returnpals.services
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.amplifyframework.auth.AuthException
import com.example.returnpals.dataRepository.LoginRepository
import com.example.returnpals.navigation.goto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// this view model is complex because repo operations are asynchronous and view model operations
// can be called by anyone who has a reference to it
// meaning we have to orchestrate io operations that complete on their own time
// to somehow work with jetpack compose

//Login View model provides the information and function needed to login, logout, and signup.
class LoginViewModel(
    email: String = "",
    password: String = "",
    navController: NavController
//    private val repository: LoginRepository       login repo is a global object for now
): ViewModel() {
    /** Gets updated on calls to [logIn], [logOut], [register], and [logInAsGuest]. **/
    val isLoggedIn get() = LoginRepository.isLoggedIn
    val isGuest get() = LoginRepository.isGuest
    var email by mutableStateOf(email)
    var password by mutableStateOf(password)
    val navController = navController
    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */
    fun register(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    LoginRepository.register(email, password)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                }
            }
        }
    }

    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */
    fun logIn(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    if (isLoggedIn == true) LoginRepository.logOut()
                    LoginRepository.logIn(email, password)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                }
            }
        }
    }

    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */
    fun logOut(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    /* Removed this logic as it would not work when the app closed and opened again if (isLoggedIn == true)*/
                    LoginRepository.logOut()
                    onSuccess()
                } catch (error: AuthException) {
                    Log.e("LoginViewModel", "Failed to log out!")
                    onFailure(error)
                }
            }
        }
       viewModelScope.launch { withContext(Dispatchers.Main) {
           navController.goto("MainMenu")
       } }


    }

    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */
    fun logInAsGuest(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                try {
                    if (isLoggedIn == true) LoginRepository.logOut()
                    LoginRepository.logInAsGuest(email)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                }
            }
        }
    }

}