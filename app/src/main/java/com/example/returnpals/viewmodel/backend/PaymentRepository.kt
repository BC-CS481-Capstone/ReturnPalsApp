package com.example.returnpals.viewmodel.backend

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Payments
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

object PaymentRepository : ModelRepository<Payments>(Payments::class.java) {

    fun create(
        userId: String,
        plan: PricingPlan,
        date: LocalDate,
    ): Payments? {
        return create(
            Payments.builder()
                .userId(userId)
                .paymentPlan(plan)
                .date(Temporal.Date(date.toString()))
                .build()
        )
    }

    fun delete(id: String): Payments? {
        return delete(Payments.justId(id))
    }

    fun update(
        id: String,
        userId: String,
        plan: PricingPlan,
        date: LocalDate,
    ): Boolean {
        return update(
            Payments.builder()
                .userId(userId)
                .paymentPlan(plan)
                .date(Temporal.Date(date.toString()))
                .id(id)
                .build()
        )
    }

}