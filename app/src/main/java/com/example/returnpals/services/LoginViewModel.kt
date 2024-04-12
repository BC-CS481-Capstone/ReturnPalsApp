package com.example.returnpals.services
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignOutResult
import com.amplifyframework.core.Amplify
import com.example.returnpals.services.Backend.accessEmail

//Login View model provides the information and function needed to login, logout, and signup.
class LoginViewModel(): ViewModel() {

    // Condition variables
    private val _logInSuccessful = MutableLiveData<Boolean?>()
    val logInSuccessful: LiveData<Boolean?> = _logInSuccessful

    private val _signUpSuccessful = MutableLiveData<Boolean?>()
    val signUpSuccessful: LiveData<Boolean?> = _signUpSuccessful

    val repository = UserRepository
    var password =  mutableStateOf<String>("Password123$")
        private set

    var isGuest = mutableStateOf(false)
        private set

    var failLogInMessage = mutableStateOf("")
        private set

    fun getEmail():String {
        return repository.getEmail()
    }
    fun changeEmail(emailNew:String) {
        repository.setEmail(emailNew)
    }

    fun changePass(passNew:String) {
        password.value = passNew
    }
    fun switchGuestUser() {
        isGuest.value = !isGuest.value
    }
    fun setFailLogInMessage(value:String) {
        failLogInMessage.value = value
    }
    //**
// This file create the functions to signUp, login, and logout of the cognito.
// */

    fun signUp() {
        //Allows user to sign up with cognito user pools
        Amplify.Auth.signUp(
            getEmail(),
            password.value,
            AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), getEmail())
                .build(),
            { _signUpSuccessful.postValue(true) }
        ) {
            _signUpSuccessful.postValue(false)
            setFailLogInMessage(it.message!!)
        }
    }

    fun signOut() {
        //Allows users to signout of cognito
        Amplify.Auth.signOut { onComplete: AuthSignOutResult? ->
            Log.i(
                "Amplify Auth",
                "Signed out successfully completed"
            )
            Backend.resetEmail()
        }
    }

    fun logIn(){
        // Allows users to signIn with cognito
        Amplify.Auth.signIn(
            getEmail(),
            password.value,
            { _logInSuccessful.postValue(true) },{
                setFailLogInMessage(it.message!!)
                _logInSuccessful.postValue(false)
                if (it.message!!.contains("User not confirmed in the system.")) {
                    _signUpSuccessful.postValue(true)
                    accessEmail()
                }
            }
        )
    }

    fun checkUser() {
        Amplify.Auth.getCurrentUser({_logInSuccessful.postValue(true)},{_logInSuccessful.postValue(false)})
    }

    fun reset() {
        //Reset the boolean values to false and error messages to empty
        _signUpSuccessful.postValue(false)
        _logInSuccessful.postValue(false)
        setFailLogInMessage("")
    }
}

object UserRepository {
    private var emailLiveData = mutableStateOf("test@bellevue.college")

    fun getEmail(): String {
        return emailLiveData.value
    }

    fun setEmail(email:String) {
        emailLiveData.value = email
    }
}