package com.returnpal.androidapp.services.backend

import com.amplifyframework.datastore.generated.model.MailingList

object MailingListRepository : ModelRepository<MailingList>(MailingList::class.java) {

    fun create(
        name: String,
        postalCode: String,
        email: String,
        message: String,
    ): MailingList? {
        return create(
            MailingList.builder()
                .email(email)
                .fullName(name)
                .message(message)
                .postalCode(postalCode)
                .build()
        )
    }

    fun delete(id: String): MailingList? {
        return delete(MailingList.justId(id))
    }

    fun update(
        id: String,
        name: String,
        postalCode: String,
        email: String,
        message: String,
    ): Boolean {
        return update(
            MailingList.builder()
                .id(id)
                .email(email)
                .fullName(name)
                .message(message)
                .postalCode(postalCode)
                .build()
        )
    }

}