package com.example.returnpals.viewmodel

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
import java.time.LocalDate

object PickupRepository : Repository<Returns>(Returns::class.java) {

    fun create(
        userId: String,
        email: String,
        date: LocalDate,
        address: String,
        method: PickupMethod,
        confirmNum: String,
        status: PickupStatus = PickupStatus.ON_THE_WAY,
    ): Returns? {
        return this.create(
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
        return this.delete(Returns.justId(id))
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
        return this.update(
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