package com.example.returnpals.services

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.auth.result.AuthSignOutResult
import com.amplifyframework.core.Amplify

class LoginViewModel: ViewModel() {
    var email =  mutableStateOf<String>("dcthekiller@yahoo.com")
        private set
    var password =  mutableStateOf<String>("Password123$")
        private set

    var isGuest = mutableStateOf(false)
        private set

    fun changeEmail(emailNew:String) {
        email.value = emailNew
    }

    fun changePass(passNew:String) {
        password.value = passNew
    }
    fun switchGuestUser() {
        isGuest.value = !isGuest.value
    }

    //**
// This file create the functions to signUp, login, and logout of the cognito.
// */

    fun singUp() {
        //Allows users to signup with cognito
            Amplify.Auth.signUp(
            email.value,
            password.value,
            AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email.value)
                .build(),
            {  Log.i("Amplify Auth", "Result: " ) }
        ) {  Log.e("Amplify Auth", "Sign up failed", ) }

    }


    fun signOut() {
        //Allows users to signout of cognito
        Amplify.Auth.signOut { onComplete: AuthSignOutResult? ->
            Log.i(
                "Amplify Auth",
                "Signed out successfully completed"
            )
        }
    }

    fun logIn(){
        // Allows users to signIn with cognito
        Amplify.Auth.signIn(
            email.value,
            password.value,
            { result: AuthSignInResult ->
                Log.i(
                    "Amplify Auth",
                    if (result.isSignedIn) "Sign in succeeded" else "Sign in not complete"
                )
            }
        ) { error: AuthException ->
            Log.e(
                "Amplify Auth",
                error.toString()
            )
        }
    }

}