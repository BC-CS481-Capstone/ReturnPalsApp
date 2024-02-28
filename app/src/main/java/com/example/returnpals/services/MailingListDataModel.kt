package com.example.returnpals.services

import com.amplifyframework.datastore.generated.model.MailingList

/**
 * Converts UI model to Amplify model.
 */
fun MailingListUIModel.toAmplifyModel(): MailingList {
    return MailingList.builder()
        .fullName(this.fullName)
        .postalCode(this.postalCode)
        .email(this.email)
        .message(this.message)
        .build()
}

/**
 * A UI model to represent mailing list data.
 */
data class MailingListUIModel(
    val fullName: String,
    val postalCode: String,
    val email: String,
    val message: String
)