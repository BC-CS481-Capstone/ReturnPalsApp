package com.example.returnpals.services
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.auth.result.AuthSignOutResult
import com.amplifyframework.auth.result.AuthSignUpResult
import com.amplifyframework.core.Amplify

class LoginViewModel(): ViewModel() {

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

    fun signUp(onSignUpSuccess:(AuthSignUpResult)->Unit) {
        Amplify.Auth.signUp(
            getEmail(),
            password.value,
            AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), getEmail())
                .build(),
            onSignUpSuccess
        ) {setFailLogInMessage(it.message!!)}
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

    fun logIn(onSignInSuccess:(AuthSignInResult)->Unit,needConfirm:(AuthException)->Unit){
        // Allows users to signIn with cognito
        Amplify.Auth.signIn(
            getEmail(),
            password.value,
            onSignInSuccess,needConfirm
        )
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