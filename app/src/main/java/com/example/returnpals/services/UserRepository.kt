package com.example.returnpals.services

import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

object UserRepository : Repository<User>(User::class.java) {

    fun create(
        email: String,
        plan: PricingPlan = PricingPlan.BRONZE,
        nameFirst: String? = null,
        nameLast: String? = null,
        phone: String? = null
    ): User? {
        return this.create(
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
        return this.delete(User.justId(id))
    }

    fun update(
        id: String,
        email: String,
        plan: PricingPlan = PricingPlan.BRONZE,
        nameFirst: String? = null,
        nameLast: String? = null,
        phone: String? = null
    ): Boolean {
        return this.update(
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