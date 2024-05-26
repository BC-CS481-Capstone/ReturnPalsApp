package com.example.returnpals.services.backend

import com.amplifyframework.datastore.generated.model.Address

object AddressRepository : ModelRepository<Address>(Address::class.java) {

    fun create(
        userId: String,
        address: String,
        nickname: String? = null,
        email: String? = null,
        onSuccess: (Address) -> Unit = {}
    ) {
        create(
            Address.builder()
                .address(address)
                .userId(userId)
                .nickName(nickname)
                .userEmail(email)
                .build(),
            onSuccess
        )
    }

    fun delete(id: String): Address? {
        return delete(Address.justId(id))
    }

    fun update(
        id: String,
        userId: String,
        address: String,
        nickname: String,
        email: String
    ): Boolean {
        return this.update(
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