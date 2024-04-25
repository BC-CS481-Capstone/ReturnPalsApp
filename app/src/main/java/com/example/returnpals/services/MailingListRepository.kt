package com.example.returnpals.services

import com.amplifyframework.datastore.generated.model.MailingList

object MailingListRepository : Repository<MailingList>(MailingList::class.java) {

    fun create(
        name: String,
        postalCode: String,
        email: String,
        message: String,
    ): MailingList? {
        return this.create(
            MailingList.builder()
                .email(email)
                .fullName(name)
                .message(message)
                .postalCode(postalCode)
                .build()
        )
    }

    fun delete(id: String): MailingList? {
        return this.delete(MailingList.justId(id))
    }

    fun update(
        id: String,
        name: String,
        postalCode: String,
        email: String,
        message: String,
    ): Boolean {
        return this.update(
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