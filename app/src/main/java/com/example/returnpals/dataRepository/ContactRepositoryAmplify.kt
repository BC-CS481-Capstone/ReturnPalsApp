package com.example.returnpals.dataRepository

import android.util.Log
import com.amplifyframework.datastore.generated.model.MailingList

object ContactRepositoryAmplify : ContactRepository{
    override fun submitData(fullName: String, postalCode: String, email: String, message: String,result:(Boolean,String)->Unit) {
        val model = MailingList.builder()
            .fullName(fullName)
            .postalCode(postalCode)
            .email(email)
            .message(message)
            .build()
        Log.i("ContactRepositoryAmplify","Model Build:${model}")
        AmplifyOperations.sendMailingListData(model,
            onSuccess = { id ->
                Log.i("ContactRepositoryAmplify","Model Build:${model}")
                result(true,id)
            },
            onError = { error ->
                Log.e("ContactRepositoryAmplify","Failed: ",error)
                result(false,"")
            }
        )
    }
}