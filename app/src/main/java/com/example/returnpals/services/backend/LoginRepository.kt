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

    suspend fun logInAsGuest(email: String): AuthException? {
        if (isLoggedIn()) {
            val error = AuthException("Already logged in as $email!", "Log out first.")
            Log.e("LoginRepository", "Failed guest log in as $email", error)
            return error
        }
        this.email = email
        isGuest = true
        return null
    }

    suspend fun logIn(email: String, password: String): AuthException? {
        var error: AuthException? = null
        try {
            val result = Amplify.Auth.signIn(email, password)
            if (result.isSignedIn) {
                this.email = email
                isGuest = false
                Log.i("LoginRepository", "Logged in as $email")
            } else {
                Log.e("LoginRepository", "Incomplete log in as $email")
                error = AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (exception: AuthException) {
            error = exception
            Log.e("LoginRepository", "Failed to log in as $email", exception)
        }
        return error
    }

    /**
     * Log in with third-party authentication (Google, Apple, Facebook, etc).
     */
    suspend fun logInWith(provider: AuthProvider, callingActivity: Activity): AuthException? {
        var error: AuthException? = null
        try {
            val result = Amplify.Auth.signInWithSocialWebUI(provider, callingActivity)
            if (result.isSignedIn) {
                this.email = null // provider doesn't return the email of the user logged in?
                isGuest = false
                Log.i("LoginRepository", "Logged in with third-party authentication [${provider.providerKey}].")
            } else {
                error = AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
                Log.e("LoginRepository", "Incomplete log in with third-party authentication [${provider.providerKey}].")
            }
        } catch (exception: AuthException) {
            error = exception
            Log.e("LoginRepository", "Failed to log in with third-party authentication [${provider.providerKey}].", exception)
        }
        return error
    }

    suspend fun logOut(): Boolean {
        var status = false
        when (val result = Amplify.Auth.signOut()) {
            is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                status = true
                email = null
                Log.i("LoginRepository", "Logged out.")
            }
            is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                status = true
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
                Log.e("LoginRepository", "Failed to log out.", result.exception)
            }
        }
        return status
    }

    suspend fun register(
        email: String,
        password: String,
        phoneNumber: String? = null,
    ): AuthException? {
        var error: AuthException? = null
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
                error = AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
                Log.e("LoginRepository", "Incomplete register with username: $email")
            }
        } catch (exception: AuthException) {
            error = exception
            Log.e("LoginRepository", "Failed to register with $email", exception)
        }
        return error
    }

    /**
     * @param code the confirmation code sent to the user's email
     */
    suspend fun confirmEmail(code: String): Boolean {
        var status = false
        try {
            email?.let { email ->
                val result = Amplify.Auth.confirmSignUp(email, code)
                if (result.isSignUpComplete) {
                    status = true
                    Log.i("LoginRepository", "Confirmed email: $email.")
                } else {
                    Log.i("LoginRepository", "Incomplete email confirmation: $email")
                }
            } ?: Log.e("LoginRepository", "Failed to confirm email: $email") 
        } catch (error: AuthException) {
            Log.e("LoginRepository", "Failed to confirm email: $email", error)
        }
        return status
    }

    suspend fun isLoggedIn(): Boolean {
        if (isGuest) return true
        var status = false
        try {
            status = Amplify.Auth.fetchAuthSession().isSignedIn
        } catch (error: AuthException) {
            Log.e("LoginRepository", "Could not determine if the user is logged in.", error)
        }
        return status
    }

}