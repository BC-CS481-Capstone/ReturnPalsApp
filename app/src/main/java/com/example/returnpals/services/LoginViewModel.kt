package com.example.returnpals.services
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.returnpals.composetools.goto
import com.example.returnpals.mainMenu.MenuRoutes
import com.example.returnpals.services.backend.LoginRepository
import com.example.returnpals.services.backend.RepoResult
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
    private val navController: NavController,
    email: String = "",
    password: String = "",
): ViewModel() {

    /** Gets updated on calls to [logIn], [logOut], [register], and [logInAsGuest]. **/
    val isLoggedIn get() = LoginRepository.isLoggedIn
    val isGuest get() = LoginRepository.isGuest
    var email by mutableStateOf(email)
    var password by mutableStateOf(password)

    fun register(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (String) -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.register(email, password)
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> navController.goto(MenuRoutes.HomeDash)
                        RepoResult.INCOMPLETE -> navController.goto(MenuRoutes.ConfirmNumber)
                        RepoResult.PARTIAL -> onFailure(result.message)
                        RepoResult.FAILURE -> onFailure(result.message)
                    }
                }
            }
        }
    }

    fun confirmEmail(
        code: String,
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (String) -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.confirmEmail(code)
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> navController.goto(MenuRoutes.SignIn)
                        RepoResult.INCOMPLETE -> onFailure(result.message)
                        RepoResult.PARTIAL -> onFailure(result.message)
                        RepoResult.FAILURE -> onFailure(result.message)
                    }
                }
            }
        }
    }

    fun logIn(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (String) -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.logIn(email, password)
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> navController.goto(MenuRoutes.HomeDash)
                        RepoResult.INCOMPLETE -> navController.goto(MenuRoutes.ConfirmNumber)
                        RepoResult.PARTIAL -> onFailure(result.message)
                        RepoResult.FAILURE -> onFailure(result.message)
                    }
                }
            }
        }
    }

    fun logOut(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (String) -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.logOut()
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> navController.goto(MenuRoutes.Home)
                        RepoResult.INCOMPLETE -> onFailure(result.message)
                        RepoResult.PARTIAL -> onFailure(result.message)
                        RepoResult.FAILURE -> onFailure(result.message)
                    }
                }
            }
        }
    }

    fun logInAsGuest(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (String) -> Unit = {}
    ) {
        viewModelScope.launch(context) {
            withContext(Dispatchers.IO) {
                val result = LoginRepository.logInAsGuest(email)
                withContext(Dispatchers.Main) {
                    when (result) {
                        RepoResult.SUCCESS -> navController.goto(MenuRoutes.Home)
                        RepoResult.INCOMPLETE -> navController.goto(MenuRoutes.ConfirmNumber)
                        RepoResult.PARTIAL -> onFailure(result.message)
                        RepoResult.FAILURE -> onFailure(result.message)
                    }
                }
            }
        }
    }

}