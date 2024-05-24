package com.example.returnpals.dataRepository

import com.amplifyframework.datastore.generated.model.MailingList

interface ContactRepository {
    fun submitData(fullName: String, postalCode: String, email: String, message: String,result:(Boolean)->Unit) {
        val model = MailingList.builder()
            .fullName(fullName)
            .postalCode(postalCode)
            .email(email)
            .message(message)
            .build()

        AmplifyOperations.sendMailingListData(model,
            onSuccess = { id ->
                result(true)
            },
            onError = { error ->
                result(false)
            }
        )
    }
}