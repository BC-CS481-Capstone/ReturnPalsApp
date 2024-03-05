package com.example.returnpals.services

import android.util.Log
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.MailingList
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.datastore.generated.model.UsersMongoDb

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

    fun sendRegistrationData(model: UsersMongoDb, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
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

}
