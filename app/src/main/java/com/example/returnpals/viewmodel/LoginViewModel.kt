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
import com.example.returnpals.dataRepository.CognitoLoginRepository
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
//    private val repository: LoginRepository  login repo is a global object for now
): ViewModel() {
    /** Gets updated on calls to [logIn], [logOut], [register], and [logInAsGuest]. **/
    //val isLoggedIn get() = CognitoLoginRepository.isLoggedIn
    private val _isLoggedIn = MutableLiveData<Boolean?>()
    val isLoggedIn: LiveData<Boolean?> = _isLoggedIn
    //val isGuest get() = CognitoLoginRepository.isGuest
    private val _isGuest = MutableLiveData<Boolean?>()
    val isGuest: LiveData<Boolean?> = _isGuest
    private val _message = MutableLiveData<String>("")
    val message: LiveData<String> = _message

    var email by mutableStateOf(email)
    var password by mutableStateOf(password)
    /** Note: making a jetpack compose navigation call within onSuccess or onFailure will result in a [java.lang.IllegalStateException]. */


    fun setFailMessage(message:String,recoverSuggestion:String) {
        _message.postValue(message+'\n'+recoverSuggestion)
    }

    fun register(
        context: CoroutineContext = viewModelScope.coroutineContext,
        onFailure: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        val lambda:(Boolean,String,String)->Unit = { it, message, recoverSuggestion ->
        }
        viewModelScope.launch(context) {
            withContext(Dispatchers.Main) {
                try {
                    CognitoLoginRepository.register(email, password,phoneNumber = null,lambda)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                    //Set fail message as part of exception logic.This Requires Amplify Cognito Auth to work TODO Decouple tightly coupled to Amplifly logic
                    setFailMessage(error.message!!,error.recoverySuggestion)
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
        //Reset Fail message
        _message.postValue("")
        val lambda:(Boolean,String,String)->Unit =  {it,message,recoverSuggestion ->
            if (it) {
            _isLoggedIn.postValue(true)
                _isGuest.postValue(false)
            }
            //Set fail message if this was part of call back logic.
            setFailMessage(message,recoverSuggestion)
        }
        viewModelScope.launch(context) {
            withContext(Dispatchers.Main) {
                try {
                    if (isLoggedIn.value == true) CognitoLoginRepository.logOut({ })
                    CognitoLoginRepository.logIn(email, password,lambda)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                    //Set fail message as part of exception logic.This Requires Amplify Cognito Auth to work TODO Decouple tightly coupled to Amplifly logic
                    setFailMessage(error.message!!,error.recoverySuggestion)
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
        val lambda:(Boolean)->Unit =  {if (it) {
            _isLoggedIn.postValue(false)
            _isGuest.postValue(false)
        }}
        viewModelScope.launch(context) {
            withContext(Dispatchers.Main) {
                try {
                    /* Removed this logic as it would not work when the app closed and opened again if (isLoggedIn == true)*/
                    CognitoLoginRepository.logOut(lambda)
                    onSuccess()
                } catch (error: AuthException) {
                    Log.e("LoginViewModel", "Failed to log out!")
                    onFailure(error)
                    //Set fail message as part of exception logic.This Requires Amplify Cognito Auth to work TODO Decouple tightly coupled to Amplifly logic
                    setFailMessage(error.message!!,error.recoverySuggestion)
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
        val lambda:(Boolean,String,String)->Unit =  {it,message,recoverSuggestion ->
            //_isGuest.postValue(true)
            //_isLoggedIn.postValue(true)
        }
        ///Always set to true as login will fail and create exception stopping the lambda call above from executing
        _isGuest.postValue(true)
        _isLoggedIn.postValue(true)

        viewModelScope.launch(context) {
            withContext(Dispatchers.Main) {
                try {
                    if (isLoggedIn.value == true) CognitoLoginRepository.logOut({})
                    CognitoLoginRepository.logInAsGuest(email,lambda)
                    onSuccess()
                } catch (error: AuthException) {
                    onFailure(error)
                    //Set fail message as part of exception logic.This Requires Amplify Cognito Auth to work TODO Decouple tightly coupled to Amplifly logic
                    setFailMessage(error.message!!,error.recoverySuggestion)
                }
            }
        }
    }
}