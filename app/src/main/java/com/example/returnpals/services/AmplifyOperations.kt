package com.example.returnpals.services

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.auth.AuthSession
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.auth.result.AuthSignOutResult
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.MailingList
import com.amplifyframework.datastore.generated.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object AmplifyOperations {

    fun sendMailingListData(model: MailingList, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
        Amplify.API.mutate(
            ModelMutation.create(model),
            { response ->
                if(response.hasErrors()) {
                    onError(Exception("Error submitting MailingList data: ${response.errors.first().message}"))
                } else {
                    onSuccess(response.data.id)
                }
            },
            { error -> onError(error) }
        )
    }

    fun sendRegistrationData(model: User, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
        Amplify.API.mutate(
            ModelMutation.create(model),
            { response ->
                Log.d("AmplifyOperations", "Response: $response")
                if(response.hasErrors()) {
                    onError(Exception("Error submitting Registration data: ${response.errors.first().message}"))
                } else {
                    onSuccess(response.data.id)
                }
            },
            { error ->
                Log.e("AmplifyOperations", "Error submitting Registration data", error)
                onError(error)
            }
        )
    }

    fun isLoggedIn(authSession:(AuthSession)->Unit) {
            Amplify.Auth.fetchAuthSession(authSession) {}
    }

    fun signOut(results:(AuthSignOutResult)->Unit) {
        Amplify.Auth.signOut(results)
    }

    fun singUp(email:String,password:String):Boolean {
        var failed = true
        //Allows users to signup with cognito
        GlobalScope.launch {
            Amplify.Auth.signUp(
            email,
            password,
            AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email)
                .build(),
            { failed = false },{ failed = false }
        ) }
        return failed
    }

}
