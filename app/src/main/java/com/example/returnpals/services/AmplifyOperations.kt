package com.example.returnpals.services

import android.util.Log
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.MailingList
import com.amplifyframework.api.graphql.model.ModelMutation

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
}
