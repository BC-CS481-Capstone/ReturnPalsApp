package com.example.returnpals.services

import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.auth.result.AuthSignOutResult
import com.amplifyframework.core.Amplify

//** @LoginService.kt
// This file create the functions to signUp, login, and logout of the cognito.
// */

    fun singUp(userName:String,passWord:String,email:String) {
        //Allows users to signup with cognito
        Amplify.Auth.signUp(
            userName,
            passWord,
            AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email)
                .build(),
            { result -> Log.i("Amplify Auth", "Result: " + result.toString()) }
        ) { error -> Log.e("Amplify Auth", "Sign up failed", error) }
    }


    fun signOut(email:String) {
        //Allows users to signout of cognito
        Amplify.Auth.signOut { onComplete: AuthSignOutResult? ->
            Log.i(
                "Amplify Auth",
                "Signed out successfully completed"
            )
        }
    }

    fun logIn(user:String,pass:String){
        // Allows users to signIn with cognito
        Amplify.Auth.signIn(
            user,
            pass,
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



