package com.example.returnpals.services.backend

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
import java.time.LocalDate

object PickupRepository : ModelRepository<Returns>(Returns::class.java) {

    fun create(
        userId: String,
        email: String,
        date: LocalDate,
        address: String,
        method: PickupMethod,
        confirmNum: String,
        status: PickupStatus = PickupStatus.ON_THE_WAY,
    ): Returns? {
        return create(
            Returns.builder()
                .userId(userId)
                .email(email)
                .date(Temporal.Date(date.toString()))
                .method(method)
                .address(address)
                .confrimationNumber(confirmNum)
                .status(status)
                .build()
        )
    }

    fun delete(id: String): Returns? {
        return delete(Returns.justId(id))
    }

    fun update(
        id: String,
        email: String,
        date: LocalDate,
        address: String,
        method: PickupMethod,
        confirmNum: String,
        status: PickupStatus,
    ): Boolean {
        return update(
            Returns.builder()
                .userId(id)
                .email(email)
                .date(Temporal.Date(date.toString()))
                .method(method)
                .address(address)
                .confrimationNumber(confirmNum)
                .status(status)
                .build()
        )
    }

}