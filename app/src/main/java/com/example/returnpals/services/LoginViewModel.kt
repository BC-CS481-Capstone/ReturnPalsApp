package com.example.returnpals.services
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.auth.AuthException
import com.example.returnpals.services.backend.LoginRepository
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
    password: String = ""
//    private val repository: LoginRepository       login repo is a global object for now
): ViewModel() {

    /** Gets updated on calls to [logIn], [logOut], [register], and [logInAsGuest]. **/
    val isLoggedIn get() = LoginRepository.isLoggedIn
    val isGuest get() = LoginRepository.isGuest
    var email by mutableStateOf(email)
    var password by mutableStateOf(password)

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
                    withContext(Dispatchers.Main) { onSuccess() }
                } catch (error: AuthException) {
                    withContext(Dispatchers.Main) { onFailure(error) }
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
                    withContext(Dispatchers.Main) { onSuccess() }
                } catch (error: AuthException) {
                    withContext(Dispatchers.Main) { onFailure(error) }
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
                    if (isLoggedIn == true) LoginRepository.logOut()
                    withContext(Dispatchers.Main) { onSuccess() }
                } catch (error: AuthException) {
                    withContext(Dispatchers.Main) { onFailure(error) }
                }
            }
        }
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
                    withContext(Dispatchers.Main) { onSuccess() }
                } catch (error: AuthException) {
                    withContext(Dispatchers.Main) { onFailure(error) }
                }
            }
        }
    }

}