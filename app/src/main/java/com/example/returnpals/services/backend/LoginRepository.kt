package com.example.returnpals.services.backend

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

enum class RepoResult(val isSuccess: Boolean) {
    FAILURE(false),
    /** process was success, but additional steps are needed (i.e. confirm email) */
    INCOMPLETE(true),
    /** process was partially successful (not sure what this means but its a possibility) */
    PARTIAL(true),
    SUCCESS(true);
    fun message(msg: String): RepoResult {
        message = msg
        return this
    }
    var message: String = ""
        private set
}

/**
 * Encapsulates log in, log out, and registration capabilities using AWS Cognito and Auth API.
 */
object LoginRepository {
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

    fun logInAsGuest(email: String): RepoResult {
        Log.d("LoginRepository", "logInAsGuest")
        var status = RepoResult.FAILURE
        if (isLoggedIn==true) {
            val msg = "Already logged in as ${this.email}!"
            Log.i("LoginRepository", "Failed guest log in as $email: $msg")
            status = RepoResult.FAILURE.message(msg)
        } else {
            this.email = email
            isGuest = true
            isLoggedIn = true
            status = RepoResult.SUCCESS
        }
        return status
    }

    suspend fun logIn(email: String, password: String): RepoResult {
        Log.d("LoginRepository", "logIn")
        var status = RepoResult.FAILURE
        try {
            val result = Amplify.Auth.signIn(email, password)
            if (result.isSignedIn) {
                this.email = email
                isGuest = false
                isLoggedIn = true
                Log.i("LoginRepository", "Logged in as $email")
                status = RepoResult.SUCCESS
            } else {
                // Flagged as a warning in logcat because we don't expect the program to go here but its not game over if it does
                Log.w("LoginRepository", "Incomplete log in as $email")
                status = RepoResult.INCOMPLETE.message("Additional steps needed: ${result.nextStep}")
            }
        } catch (error: AuthException) {
            // Not flagged as an error in logcat because its the callers job to decide if it is an error or not  
            Log.i("LoginRepository", "Failed to log in as $email", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

    /**
     * Log in with third-party authentication (Google, Apple, Facebook, etc).
     */
    suspend fun logInWith(provider: AuthProvider, callingActivity: Activity): RepoResult {
        Log.d("LoginRepository", "logInWith")
        var status = RepoResult.FAILURE
        try {
            val result = Amplify.Auth.signInWithSocialWebUI(provider, callingActivity)
            if (result.isSignedIn) {
                email = null // provider doesn't return the email of the user logged in?
                isGuest = false
                isLoggedIn = true
                Log.i("LoginRepository", "Logged in with third-party authentication [${provider.providerKey}].")
                status = RepoResult.SUCCESS
            } else {
                Log.w("LoginRepository", "Incomplete log in with third-party authentication [${provider.providerKey}].")
                status = RepoResult.FAILURE.message("Additional steps needed: ${result.nextStep}")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to log in with third-party authentication [${provider.providerKey}].", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

    suspend fun logOut(): RepoResult {
        Log.d("LoginRepository", "logOut")
        var status = RepoResult.FAILURE
        when (val result = Amplify.Auth.signOut()) {
            is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                email = null
                isGuest = false
                isLoggedIn = false
                Log.i("LoginRepository", "Logged out.")
                status = RepoResult.SUCCESS
            }
            is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                email = null
                isGuest = false
                isLoggedIn = false
                result.hostedUIError?.let {
                    val msg = "Logged out with hosted UI errors."
                    Log.w("LoginRepository", msg, it.exception)
                    status = RepoResult.PARTIAL.message(msg)
                }
                result.globalSignOutError?.let {
                    val msg = "Logged out with global log out error."
                    Log.w("LoginRepository", msg, it.exception)
                    status = RepoResult.PARTIAL.message(msg)
                }
                result.revokeTokenError?.let {
                    val msg = "Logged out with revoke token error."
                    Log.w("LoginRepository", msg, it.exception)
                    status = RepoResult.PARTIAL.message(msg)
                }
            }
            is AWSCognitoAuthSignOutResult.FailedSignOut -> {
                Log.i("LoginRepository", "Failed to log out.", result.exception)
                status = RepoResult.FAILURE.message(result.exception.message ?: "")
            }
        }
        return status
    }

    suspend fun register(
        email: String,
        password: String,
        firstName: String? = null,
        lastName: String? = null,
        phoneNumber: String? = null,
    ): RepoResult {
        Log.d("LoginRepository", "register")

        var status = RepoResult.FAILURE
        val options: AuthSignUpOptions =
            AuthSignUpOptions.builder().also { builder ->
                firstName?.let { builder.userAttribute(AuthUserAttributeKey.givenName(), it) }
                lastName?.let { builder.userAttribute(AuthUserAttributeKey.familyName(), it) }
                phoneNumber?.let { builder.userAttribute(AuthUserAttributeKey.phoneNumber(), it) }
            }.build()

        try {
            val result = Amplify.Auth.signUp(email, password, options)
            this.email = email
            if (result.isSignUpComplete) {
                isGuest = false
                isLoggedIn = false
                Log.i("LoginRepository", "Registered with $email")
                status = RepoResult.SUCCESS
            } else {
                Log.w("LoginRepository", "Incomplete register with username: $email")
                status = RepoResult.INCOMPLETE.message("Additional steps needed: ${result.nextStep}")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to register with $email", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

    suspend fun deleteCurrentUser(): RepoResult {
        Log.d("LoginRepository", "deleteCurrentUser")
        var status = RepoResult.FAILURE
        try {
            Amplify.Auth.deleteUser()
            status = RepoResult.SUCCESS
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to delete the current user with email $email", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

    /**
     * @param code the confirmation code sent to the user's email
     */
    suspend fun confirmEmail(code: String): RepoResult {
        Log.d("LoginRepository", "confirmEmail")
        var status = RepoResult.FAILURE
        try {
            if (email != null) {
                val result = Amplify.Auth.confirmSignUp(email!!, code)
                if (result.isSignUpComplete) {
                    Log.i("LoginRepository", "Confirmed email: $email.")
                    status = RepoResult.SUCCESS
                    isLoggedIn = true
                } else {
                    Log.w("LoginRepository", "Incomplete email confirmation: $email")
                    status = RepoResult.INCOMPLETE.message("Additional steps needed: ${result.nextStep}")
                }
            } else {
                Log.w("LoginRepository", "Failed to confirm email: $email")
                status = RepoResult.FAILURE.message("Not signed in!")
            }
        } catch (error: AuthException) {
            Log.i("LoginRepository", "Failed to confirm email: $email", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

    /** Updates this repository with the remote database. */
    suspend fun update(): RepoResult {
        Log.d("LoginRepository", "update")
        var status = RepoResult.FAILURE
        try {
            // if is guest with valid and confirmed email then is marked as logged in
            isLoggedIn = (isGuest && email != null) || Amplify.Auth.fetchAuthSession().isSignedIn
            email = if (!isGuest && isLoggedIn == true) Amplify.Auth.getCurrentUser().username else if (isGuest) email else null
            status = RepoResult.SUCCESS
        } catch (error: AuthException) {
            isLoggedIn = null
            email = null
            Log.w("LoginRepository", "Could not determine if the user is logged in.", error)
            status = RepoResult.FAILURE.message(error.message ?: "")
        }
        return status
    }

}