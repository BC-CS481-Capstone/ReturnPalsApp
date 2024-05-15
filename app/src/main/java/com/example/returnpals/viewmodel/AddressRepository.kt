package com.example.returnpals.viewmodel

import com.amplifyframework.datastore.generated.model.Address

object AddressRepository : Repository<Address>(Address::class.java) {

    fun create(
        userId: String,
        address: String,
        nickname: String? = null,
        email: String? = null,
    ): Address? {
        return this.create(
            Address.builder()
                .address(address)
                .userId(userId)
                .nickName(nickname)
                .userEmail(email)
                .build()
        )
    }

    fun delete(id: String): Address? {
        return this.delete(Address.justId(id))
    }

    fun update(
        id: String,
        userId: String,
        address: String,
        nickname: String,
        email: String,
    ): Address? {
        return this.create(
            Address.builder()
                .address(address)
                .userId(userId)
                .id(id)
                .nickName(nickname)
                .userEmail(email)
                .build()
        )
    }

}