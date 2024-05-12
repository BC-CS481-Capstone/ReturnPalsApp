package com.example.returnpals.services.backend

import android.app.Activity
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthProvider
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify

/**
 * something
 */
object SessionRepository {
    // may need to change to a class to support multi-threading and coroutines

    /** Is the same value as the username.
     * Is null if user is not signed in. */
    var email: String? = null
        private set
    /** Is null if user is not signed in. */
    var firstname: String? = null
        private set
    /** Is null if user is not signed in. */
    var lastname: String? = null
        private set
    /** Is null if user is not signed in. */
    var phoneNumber: String? = null
        private set
    /** The most recent exception thrown by aws amplify API, or null if none was encountered. */
    var exception: AuthException? = null
        private set

    /**
     * @return null on failure to fetch information from database
     */
    fun isSignedIn(): Boolean? {
        var status: Boolean? = null
        Amplify.Auth.fetchAuthSession(
            { status = it.isSignedIn },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to fetch session.", exception)
            }
        )
        return status
    }

    /**
     * Automatically calls [fetch] on success.
     * @return true on success, false on failure
     */
    fun signIn(email: String, password: String): Boolean {
        var status = false
        Amplify.Auth.signIn(email, password,
            { result ->
                if (result.isSignedIn) {
                    status = true
                    Log.i("SessionRepository", "Signed in as $email")
                } else {
                    Log.e("SessionRepository", "Failed to sign in as $email")
                }
            },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to sign in as $email", exception)
            }
        )
        if (status) this.fetch()
        return status
    }

    /**
     * Automatically calls [fetch] on success.
     * @return true on success, false on failure
     */
    fun signInWith(provider: AuthProvider, callingActivity: Activity): Boolean {
        var status = false
        Amplify.Auth.signInWithSocialWebUI(
            provider,
            callingActivity,
            { result ->
                if (result.isSignedIn) {
                    status = true
                    Log.i("SessionRepository", "Signed in with third-party authentication [${provider.providerKey}].")
                } else {
                    Log.e("SessionRepository", "Failed to sign in with third-party authentication [${provider.providerKey}].")
                }
            },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to sign in with third-party authentication [${provider.providerKey}].", exception)
            }
        )
        if (status) this.fetch()
        return status
    }

    /**
     * Automatically calls [fetch] on success.
     * @return true on success, false on failure
     */
    fun signOut(): Boolean {
        var status = false
        Amplify.Auth.signOut { result ->
            when(result) {
                is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                    status = true
                    Log.i("SessionRepository", "Signed out.")
                }
                is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                    status = true
                    result.hostedUIError?.let {
                        Log.w("SessionRepository", "Signed out with hosted UI errors.", it.exception)
                    }
                    result.globalSignOutError?.let {
                        Log.w("SessionRepository", "Signed out with global sign out error.", it.exception)
                    }
                    result.revokeTokenError?.let {
                        Log.w("SessionRepository", "Signed out with revoke token error.", it.exception)
                    }
                }
                is AWSCognitoAuthSignOutResult.FailedSignOut -> {
                    this.exception = result.exception
                    Log.e("SessionRepository", "Failed to sign out.", result.exception)
                }
            }
        }
        if (status) this.fetch()
        return status
    }

    /**
     * Automatically calls [fetch] on success.
     * @return true on success, false on failure
     */
    fun signUp(email: String, password: String, phoneNumber: String?): Boolean {
        var status = false
        val options: AuthSignUpOptions =
            AuthSignUpOptions.builder().also { builder ->
                phoneNumber?.let { builder.userAttribute(AuthUserAttributeKey.phoneNumber(), it) }
            }.build()

        Amplify.Auth.signUp(email, password, options,
            { result ->
                if (result.isSignUpComplete) {
                    Log.i("SessionRepository", "Signed up with $email")
                    status = true
                } else {
                    Log.e("SessionRepository", "Incomplete sign up with username: $email")
                }
            },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to sign up with $email", exception)
            }
        )
        if (status) this.fetch()
        return status
    }

    /**
     * Automatically calls [fetch] on success.
     * @return true on success, false on failure
     */
    fun setAttribute(key: AuthUserAttributeKey, value: String): Boolean {
        var status = false
        Amplify.Auth.updateUserAttribute(
            AuthUserAttribute(key, value),
            { result ->
                if (result.isUpdated) {
                    Log.i("SessionRepository", "Updated attribute: {key: $key, value: $value}")
                    status = true
                } else Log.e("SessionRepository", "Failed to update attribute with key: $key")
            },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to update attribute with key: $key", exception)
            }
        )
        if (status) this.fetch()
        return status
    }

    /**
     * Calls [setAttribute].
     * @return true on success, false on failure
     */
    fun setPhoneNumber(value: String): Boolean {
        return setAttribute(AuthUserAttributeKey.phoneNumber(), value)
    }

    /**
     * Calls [setAttribute].
     * @return true on success, false on failure
     */
    fun setFirstName(value: String): Boolean {
        return setAttribute(AuthUserAttributeKey.givenName(), value)
    }

    /**
     * Calls [setAttribute].
     * @return true on success, false on failure
     */
    fun setLastName(value: String): Boolean {
        return setAttribute(AuthUserAttributeKey.familyName(), value)
    }

    /**
     * Updates properties to match the respective values stored in the remote database.
     * Only needs to be called publicly if amplify auth API was used outside of [SessionRepository].
     * @return false on failure to fetch information from database
     */
    fun fetch(): Boolean {
        var status = false
        this.isSignedIn()?.let { isSignedIn ->
            if (isSignedIn) {
                this.getUsername()?.let { username ->
                    this.email = username
                    // fetch name & phone number
                    Amplify.Auth.fetchUserAttributes(
                        { list ->
                            val attributes = list.associate { it.key to it.value }
                            this.firstname = attributes[AuthUserAttributeKey.givenName()]
                            this.lastname = attributes[AuthUserAttributeKey.familyName()]
                            this.phoneNumber = attributes[AuthUserAttributeKey.phoneNumber()]
                            status = true // good ending #1
                        },
                        { exception ->
                            this.exception = exception
                            Log.e("SessionRepository", "Failed to fetch user attributes.", exception)
                        }
                    )
                }
            } else {
                this.email = null
                this.firstname = null
                this.lastname = null
                this.phoneNumber = null
                status = true // good ending #2
            }
        }
        return status
    }

    /**
     * @return null on failure to fetch information from database
     */
    private fun getUsername(): String? {
        var username: String? = null
        Amplify.Auth.getCurrentUser(
            { username = it.username },
            { exception ->
                this.exception = exception
                Log.e("SessionRepository", "Failed to get the current user.", exception)
            }
        )
        return username
    }

}