package com.example.returnpals.dataRepository

import android.app.Activity
import com.amplifyframework.auth.AuthProvider

interface LoginRepository {
    // https://developer.android.com/develop/ui/compose/kotlin#coroutines



    suspend fun logInAsGuest(email: String,result: (Boolean)->Unit)
    suspend fun logIn(email:String,password: String,result: (Boolean)->Unit)

    /**
     * Log in with third-party authentication (Google, Apple, Facebook, etc).
     */
    suspend fun logInWith(provider: AuthProvider, callingActivity: Activity)

    suspend fun logOut(result: (Boolean)->Unit)

    suspend fun register(
        email: String,
        password: String,
        phoneNumber: String? = null,
        result: (Boolean)->Unit
    )

    suspend fun confirmEmail(code: String,result: (Boolean)->Unit)


    /** Updates this repository with the remote database. */
    suspend fun update(result: (Boolean)->Unit)

}