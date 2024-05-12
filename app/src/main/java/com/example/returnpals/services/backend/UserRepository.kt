package com.example.returnpals.services.backend

import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

object UserRepository : ModelRepository<User>(User::class.java) {

    fun create(
        email: String,
        plan: PricingPlan = PricingPlan.BRONZE,
        nameFirst: String? = null,
        nameLast: String? = null,
        phone: String? = null
    ): User? {
        return create(
            User.builder()
                .email(email)
                .subscription(plan)
                .firstName(nameFirst)
                .lastName(nameLast)
                .phone(phone)
                .build()
        )
    }

    fun delete(id: String): User? {
        return delete(User.justId(id))
    }

    fun update(
        id: String,
        email: String,
        plan: PricingPlan = PricingPlan.BRONZE,
        nameFirst: String? = null,
        nameLast: String? = null,
        phone: String? = null
    ): Boolean {
        return update(
            User.builder()
                .email(email)
                .subscription(plan)
                .id(id)
                .firstName(nameFirst)
                .lastName(nameLast)
                .phone(phone)
                .build()
        )
    }

}