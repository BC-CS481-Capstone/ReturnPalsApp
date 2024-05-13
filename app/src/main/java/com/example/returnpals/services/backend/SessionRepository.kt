package com.example.returnpals.services.backend

import android.app.Activity
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthProvider
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSessionResult
import com.amplifyframework.core.Amplify

/**
 * Encapsulates create, read, update, and delete (CRUD) operations to AWS Cognito using Auth API.
 */
object SessionRepository {
    // may need to change to a class to support multi-threading and coroutines
    // https://developer.android.com/develop/ui/compose/kotlin#coroutines

    /** Note: guests aren't considered to be signed in. */
    var isSignedIn: Boolean = false
        private set
    var id: String = ""
        private set
    /** Is the same value as the username. */
    var email: String = ""
        private set
    /** Is null if value is not yet defined for this user */
    var firstname: String? = null
        private set
    /** Is null if value is not yet defined for this user */
    var lastname: String? = null
        private set
    /** Is null if value is not yet defined for this user */
    var phoneNumber: String? = null
        private set
    var isGuest: Boolean = false // This should always be false when the user is signed in.
        private set

    /**
     * Does not sign the user out, only resets properties.
     * Shouldn't be made public because of this.
     * To 'reset' with public API call [signOut].
     */
    private fun reset() {
        this.isSignedIn = false
        this.id = ""
        this.email = ""
        this.firstname = null
        this.lastname = null
        this.phoneNumber = null
        this.isGuest = false
    }

    /**
     * Doesn't send any information to the database. The "user" that is created only exists locally.
     * Will only fail if the user is already signed in.
     */
    fun signInAsGuest(
        email: String,
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "signInAsGuest")
        this.signOut(onError) {
            this.email = email
            this.isGuest = true // the only place this should be set to true
            onSuccess()
        }
    }

    /**
     * Calls [update] on success.
     */
    fun signIn(
        email: String,
        password: String,
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "signIn")
        Amplify.Auth.signIn(email, password,
            { result ->
                if (result.isSignedIn) {
                    Log.i("SessionRepository", "Signed in as $email")
                    update(onError, onSuccess)
                } else {
                    Log.e("SessionRepository", "Failed to sign in as $email")
                    onError(null)
                }
            },
            { error ->
                Log.e("SessionRepository", "Failed to sign in as $email", error)
                onError(error)
            }
        )
    }

    /**
     * Calls [update] on success.
     */
    fun signInWith(
        provider: AuthProvider,
        callingActivity: Activity,
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "signInWith")
        Amplify.Auth.signInWithSocialWebUI(
            provider,
            callingActivity,
            { result ->
                if (result.isSignedIn) {
                    Log.i("SessionRepository", "Signed in with third-party authentication [${provider.providerKey}].")
                    update(onError, onSuccess)
                } else {
                    Log.e("SessionRepository", "Failed to sign in with third-party authentication [${provider.providerKey}].")
                    onError(null)
                }
            },
            { error ->
                Log.e("SessionRepository", "Failed to sign in with third-party authentication [${provider.providerKey}].", error)
                onError(error)
            }
        )
    }

    /**
     * Does nothing if the user isn't signed in.
     * Calls [update] on success.
     */
    fun signOut(
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "signOut")
        if (!this.isSignedIn) update(onError, onSuccess) // user is already signed out
        Amplify.Auth.signOut { result ->
            when(result) {
                is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                    Log.i("SessionRepository", "Signed out.")
                    update(onError, onSuccess)
                }
                is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                    result.hostedUIError?.let {
                        Log.w("SessionRepository", "Signed out with hosted UI errors.", it.exception)
                    }
                    result.globalSignOutError?.let {
                        Log.w("SessionRepository", "Signed out with global sign out error.", it.exception)
                    }
                    result.revokeTokenError?.let {
                        Log.w("SessionRepository", "Signed out with revoke token error.", it.exception)
                    }
                    update(onError, onSuccess)
                }
                is AWSCognitoAuthSignOutResult.FailedSignOut -> {
                    Log.e("SessionRepository", "Failed to sign out.", result.exception)
                    onError(result.exception)
                }
            }
        }
    }

    /**
     * Calls [update] on success.
     */
    fun signUp(
        email: String,
        password: String,
        phoneNumber: String? = null,
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "signUp")
        val options: AuthSignUpOptions =
            AuthSignUpOptions.builder().also { builder ->
                phoneNumber?.let { builder.userAttribute(AuthUserAttributeKey.phoneNumber(), it) }
            }.build()

        Amplify.Auth.signUp(email, password, options,
            { result ->
                if (result.isSignUpComplete) {
                    Log.i("SessionRepository", "Signed up with $email")
                    this.update(onError, onSuccess)
                } else {
                    Log.e("SessionRepository", "Incomplete sign up with username: $email")
                    onError(null)
                }
            },
            { error ->
                Log.e("SessionRepository", "Failed to sign up with $email", error)
                onError(error)
            }
        )
    }

    /**
     * @param code the confirmation code sent to the user's email
     */
    fun validateEmail(
        code: String,
        onError: (AuthException?) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "validateEmail")
        Amplify.Auth.confirmSignUp(
            this.email, code,
            { result ->
                if (result.isSignUpComplete) {
                    Log.i("SessionRepository", "Validated email: ${this.email}.")
                    onSuccess()
                } else {
                    Log.i("SessionRepository","Incomplete email validation.")
                    onError(null)
                }
            },
            { error ->
                Log.e("SessionRepository", "Failed to validate email.", error)
                onError(error)
            }
        )
    }

    /**
     * Calls [update] on success.
     * Shouldn't be called for a guest account.
     */
    private fun setAttribute(
        key: AuthUserAttributeKey,
        value: String,
        onError: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "setAttribute")
        Amplify.Auth.updateUserAttribute(
            AuthUserAttribute(key, value),
            { result ->
                if (result.isUpdated) {
                    Log.i("SessionRepository", "Updated attribute: {key: $key, value: $value}")
                    update(onError, onSuccess)
                } else Log.e("SessionRepository", "Failed to update attribute with key: $key")
            },
            { error ->
                Log.e("SessionRepository", "Failed to update attribute with key: $key", error)
                onError(error)
            }
        )
    }

    fun setPhoneNumber(
        value: String,
        onError: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        if (isGuest) this.phoneNumber = value
        else this.setAttribute(AuthUserAttributeKey.phoneNumber(), value, onError, onSuccess)
    }

    fun setFirstName(
        value: String,
        onError: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        if (isGuest) this.firstname = value
        else this.setAttribute(AuthUserAttributeKey.givenName(), value, onError, onSuccess)
    }

    fun setLastName(
        value: String,
        onError: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        if (isGuest) this.lastname = value
        else this.setAttribute(AuthUserAttributeKey.familyName(), value, onError, onSuccess)
    }

    /**
     * Updates properties to match the respective values stored in the remote database.
     * May need to be called publicly if remote user data was updated outside of [SessionRepository].
     */
    fun update(
        onError: (AuthException) -> Unit = {},
        onSuccess: () -> Unit = {}
    ) {
        Log.i("SessionRepository", "update")
        this.fetchIsSignedIn(onError) { isSignedIn ->
            if (isSignedIn) {
                this.isGuest = false
                this.fetchUser(onError) { id, username ->
                    this.id = id
                    this.email = username
                    this.fetchAttributes(onError) { attributes ->
                        this.firstname = attributes[AuthUserAttributeKey.givenName()]
                        this.lastname = attributes[AuthUserAttributeKey.familyName()]
                        this.phoneNumber = attributes[AuthUserAttributeKey.phoneNumber()]
                        onSuccess() // good ending #1 : user is signed in and user data is fetched
                    }
                }
            } else {
                if (!isGuest) this.reset()
                onSuccess() // good ending #2 : user is either signed out or signed in as guest
            }
        }
        // bad ending #1 : fetchIsSignedIn failed
        // bad ending #2 : fetchUsername failed
        // bad ending #3 : fetchAttributes failed
    }

    private fun fetchAttributes(
        onError: (AuthException) -> Unit = {},
        onSuccess: (Map<AuthUserAttributeKey, String>) -> Unit
    ) {
        Log.i("SessionRepository", "fetchAttributes")
        Amplify.Auth.fetchUserAttributes(
            { response ->
                onSuccess(response.associate { it.key to it.value })
            },
            { error ->
                Log.e("SessionRepository", "Failed to fetch user attributes.", error)
                onError(error)
            }
        )
    }

    /**
     * Shouldn't be called for a guest account.
     * Username and email are synonymous, the username is the email.
     * @param onSuccess takes id and username
     */
    private fun fetchUser(
        onError: (AuthException) -> Unit = {},
        onSuccess: (String, String) -> Unit
    ) {
        Log.i("SessionRepository", "fetchUser")
        Amplify.Auth.getCurrentUser(
            { onSuccess(it.userId, it.username) },
            { error ->
                Log.e("SessionRepository", "Failed to get the current user.", error)
                onError(error)
            }
        )
    }

    private fun fetchIsSignedIn(
        onError: (AuthException) -> Unit = {},
        onSuccess: (Boolean) -> Unit
    ) {
        Log.i("SessionRepository", "fetchIsSignedIn")
        Amplify.Auth.fetchAuthSession(
            { response ->
                val session = response as AWSCognitoAuthSession
                val id = session.identityIdResult
                if (id.type == AuthSessionResult.Type.SUCCESS) {
                    onSuccess(session.isSignedIn)
                } else if (id.type == AuthSessionResult.Type.FAILURE) {
                    Log.e("SessionRepository", "Could not determine if the user is signed in.", id.error)
                    id.error?.let { onError(it) }
                }
            },
            { error ->
                Log.e("SessionRepository", "Could not determine if the user is signed in.", error)
                onError(error)
            }
        )
    }

}