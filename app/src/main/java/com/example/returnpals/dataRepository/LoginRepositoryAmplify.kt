package com.example.returnpals.dataRepository

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthProvider
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.kotlin.core.Amplify

/**
 * Encapsulates log in, log out, and registration capabilities using AWS Cognito and Auth API.
 */
object LoginRepositoryAmplify: LoginRepository {
    // https://developer.android.com/develop/ui/compose/kotlin#coroutines

    /** Is the same value as the username.
     * Gets updated on calls to [logIn], [logOut], [logInAsGuest], [register], and [update]. */
    var email by mutableStateOf<String?>(null)
        private set
    /** Gets updated on calls to [logIn], [logOut], [logInAsGuest], [register], and [update]. */
    var isGuest by mutableStateOf(false)
        private set
    /** Gets updated on calls to [logIn], [logOut], [logInAsGuest], [register], and [update]. */
    var isLoggedIn by mutableStateOf<Boolean?>(null)
        private set

    override suspend fun logInAsGuest(email: String,result: (Boolean,String,String)->Unit) {
        var success = false
        Log.d("LoginRepository", "logInAsGuest")
        if (isLoggedIn ==true) {
            val error = AuthException("Already logged in as $email!", "Log out first.")
            Log.i("LoginRepository", "Failed guest log in as $email", error)
            throw error
        }
        LoginRepositoryAmplify.email = email
        isGuest = true
        isLoggedIn = true
        success = true
        result(success,"","") //TODO messages
    }

    override suspend fun logIn(email: String, password: String,result:(Boolean,String,String)->Unit) {
        var message = ""
        var recoverySuggestion = ""
        Log.d("LoginRepository", "logIn")
        try {
            val result = Amplify.Auth.signIn(email, password)
            if (result.isSignedIn) {
                LoginRepositoryAmplify.email = email
                isGuest = false
                isLoggedIn = true
                result(true,"","")
                Log.i("LoginRepository", "Logged in as $email")
            } else {
                // Flagged as a warning in logcat because we don't expect the program to go here but its not game over if it does
                Log.w("LoginRepository", "Incomplete log in as $email")
                result(false,message,recoverySuggestion)
                throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (error: AuthException) {
            if (error.message != null) {
                message = error.message!!
            }
            if (error.recoverySuggestion != null) {
                recoverySuggestion = error.recoverySuggestion!!
            }
            // Not flagged as an error in logcat because its the callers job to decide if it is an error or not  
            Log.i("LoginRepository", "Failed to log in as $email", error)
            result(false,message,recoverySuggestion)
            throw error
        }
    }

    /**
     * Log in with third-party authentication (Google, Apple, Facebook, etc).
     */
    override suspend fun logInWith(provider: AuthProvider, callingActivity: Activity) {
        Log.d("LoginRepository", "logInWith")
        try {
            val result = Amplify.Auth.signInWithSocialWebUI(provider, callingActivity)
            if (result.isSignedIn) {
                email = null // provider doesn't return the email of the user logged in?
                isGuest = false
                isLoggedIn = true
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

    override suspend fun logOut(result: (Boolean)->Unit) {
        var success = false
        Log.d("LoginRepository", "logOut")
        when (val result = Amplify.Auth.signOut()) {
            is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                email = null
                isGuest = false
                isLoggedIn = false
                success = true
                Log.i("LoginRepository", "Logged out.")
            }
            is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                email = null
                isGuest = false
                isLoggedIn = false
                success = true
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
        result(success)
    }

    override suspend fun register(
        email: String,
        password: String,
        phoneNumber: String?,
        result: (Boolean,String,String)->Unit
    ) {
        var success = false
        Log.d("LoginRepository", "register")
        val options: AuthSignUpOptions =
            AuthSignUpOptions.builder().also { builder ->
                phoneNumber?.let { builder.userAttribute(AuthUserAttributeKey.phoneNumber(), it) }
            }.build()

        try {
            val result = Amplify.Auth.signUp(email, password, options)
            if (result.isSignUpComplete) {
                LoginRepositoryAmplify.email = email
                isGuest = false
                isLoggedIn = true
                Log.i("LoginRepository", "Registered with $email")
            } else {
                Log.w("LoginRepository", "Incomplete register with username: $email")
                throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to register with $email", error)
            throw error
        }
        result(success,"","") //TODO messages
    }

    /**
     * @param code the confirmation code sent to the user's email
     */
    override suspend fun confirmEmail(
        code: String,
        result: (Boolean, String, String) -> Unit,
        email: String
    ) { //TODO move to new Repo for confirm view model

        Log.d("LoginRepository", "confirmEmail")
        try {
            email?.let { email ->
                val result = Amplify.Auth.confirmSignUp(email, code)
                if (result.isSignUpComplete) {
                    result(true,"","")
                    Log.i("LoginRepository", "Confirmed email: $email.")
                } else {
                    Log.w("LoginRepository", "Incomplete email confirmation: $email")
                    result(false,"","")
                    throw AuthException("Additional steps needed: ${result.nextStep}", "Complete the next step.")
                }
            } ?: Log.w("LoginRepository", "Failed to confirm email: $email")
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to confirm email: $email", error)
            result(false,error.message!!,error.recoverySuggestion!!)
            throw error
        }
    }

    /** Updates this repository with the remote database. */
    override suspend fun update(result: (Boolean)->Unit) {
        var success = false
        Log.d("LoginRepository", "update")
        try {
            // if is guest with valid and confirmed email then is marked as logged in
            isLoggedIn = (isGuest && email != null) || Amplify.Auth.fetchAuthSession().isSignedIn
            email = if (!isGuest && isLoggedIn == true) Amplify.Auth.getCurrentUser().username else if (isGuest) email else null
        } catch (error: AuthException) {
            isLoggedIn = null
            email = null
            Log.w("LoginRepository", "Could not determine if the user is logged in.", error)
            throw  error
        }
    }

}