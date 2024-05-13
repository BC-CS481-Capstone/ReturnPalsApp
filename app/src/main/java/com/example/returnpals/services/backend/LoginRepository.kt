package com.example.returnpals.services.backend

import android.app.Activity
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthProvider
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.kotlin.core.Amplify

/**
 * Encapsulates log in, log out, and registration capabilities using AWS Cognito and Auth API.
 */
object LoginRepository {
    // https://developer.android.com/develop/ui/compose/kotlin#coroutines

    /** Is the same value as the username. */
    var email: String? = null
        private set
    var isGuest: Boolean = false
        private set

    suspend fun logInAsGuest(email: String) {
        if (isLoggedIn()) {
            val error = AuthException("Already logged in as $email!", "Log out first.")
            Log.i("LoginRepository", "Failed guest log in as $email", error)
            throw error
        }
        this.email = email
        isGuest = true
    }

    suspend fun logIn(email: String, password: String) {
        try {
            val result = Amplify.Auth.signIn(email, password)
            if (result.isSignedIn) {
                this.email = email
                isGuest = false
                Log.i("LoginRepository", "Logged in as $email")
            } else {
                // Flagged as a warning in logcat because we don't expect the program to go here but its not game over if it does
                Log.w("LoginRepository", "Incomplete log in as $email")
                throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (error: AuthException) {
            // Not flagged as an error in logcat because its the callers job to decide if it is an error or not  
            Log.i("LoginRepository", "Failed to log in as $email", error)
            throw error
        }
    }

    /**
     * Log in with third-party authentication (Google, Apple, Facebook, etc).
     */
    suspend fun logInWith(provider: AuthProvider, callingActivity: Activity) {
        try {
            val result = Amplify.Auth.signInWithSocialWebUI(provider, callingActivity)
            if (result.isSignedIn) {
                this.email = null // provider doesn't return the email of the user logged in?
                isGuest = false
                Log.i("LoginRepository", "Logged in with third-party authentication [${provider.providerKey}].")
            } else {
                Log.w("LoginRepository", "Incomplete log in with third-party authentication [${provider.providerKey}].")
                throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to log in with third-party authentication [${provider.providerKey}].", error)
            throw error
        }
    }

    suspend fun logOut() {
        when (val result = Amplify.Auth.signOut()) {
            is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                email = null
                Log.i("LoginRepository", "Logged out.")
            }
            is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                email = null
                isGuest = false
                result.hostedUIError?.let {
                    Log.w("LoginRepository", "Logged out with hosted UI errors.", it.exception)
                }
                result.globalSignOutError?.let {
                    Log.w("LoginRepository", "Logged out with global log out error.", it.exception)
                }
                result.revokeTokenError?.let {
                    Log.w("LoginRepository", "Logged out with revoke token error.", it.exception)
                }
            }
            is AWSCognitoAuthSignOutResult.FailedSignOut -> {
                Log.i("LoginRepository", "Failed to log out.", result.exception)
                throw result.exception
            }
        }
    }

    suspend fun register(
        email: String,
        password: String,
        phoneNumber: String? = null,
    ) {
        val options: AuthSignUpOptions =
            AuthSignUpOptions.builder().also { builder ->
                phoneNumber?.let { builder.userAttribute(AuthUserAttributeKey.phoneNumber(), it) }
            }.build()

        try {
            val result = Amplify.Auth.signUp(email, password, options)
            if (result.isSignUpComplete) {
                this.email = email
                isGuest = false
                Log.i("LoginRepository", "Registered with $email")
            } else {
                Log.w("LoginRepository", "Incomplete register with username: $email")
                throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to register with $email", error)
            throw error
        }
    }

    /**
     * @param code the confirmation code sent to the user's email
     */
    suspend fun confirmEmail(code: String) {
        try {
            email?.let { email ->
                val result = Amplify.Auth.confirmSignUp(email, code)
                if (result.isSignUpComplete) {
                    Log.i("LoginRepository", "Confirmed email: $email.")
                } else {
                    Log.w("LoginRepository", "Incomplete email confirmation: $email")
                    throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
                }
            } ?: Log.w("LoginRepository", "Failed to confirm email: $email") 
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to confirm email: $email", error)
            throw error
        }
    }

    suspend fun isLoggedIn(): Boolean {
        if (isGuest) return true
        var status = false
        try {
            status = Amplify.Auth.fetchAuthSession().isSignedIn
        } catch (error: AuthException) {
            Log.w("LoginRepository", "Could not determine if the user is logged in.", error)
            throw  error
        }
        return status
    }

}