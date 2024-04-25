package com.example.returnpals.services

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Payments
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

object PaymentRepository : Repository<Payments>(Payments::class.java) {

    fun create(
        userId: String,
        plan: PricingPlan,
        date: LocalDate,
    ): Payments? {
        return this.create(
            Payments.builder()
                .userId(userId)
                .paymentPlan(plan)
                .date(Temporal.Date(date.toString()))
                .build()
        )
    }

    fun delete(id: String): Payments? {
        return this.delete(Payments.justId(id))
    }

    fun update(
        id: String,
        userId: String,
        plan: PricingPlan,
        date: LocalDate,
    ): Boolean {
        return this.update(
            Payments.builder()
                .userId(userId)
                .paymentPlan(plan)
                .date(Temporal.Date(date.toString()))
                .id(id)
                .build()
        )
    }

}