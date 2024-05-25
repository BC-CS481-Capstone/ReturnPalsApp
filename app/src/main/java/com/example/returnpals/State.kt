package com.example.returnpals

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.LabelType
import com.amplifyframework.datastore.generated.model.Labels
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.Returns
import com.amplifyframework.datastore.generated.model.User
import java.time.LocalDate

data class UserInfo(
    val email: String? = null,
    val id: String? = null,
    val plan: PricingPlan = PricingPlan.BRONZE,
    val firstName: String? = null,
    val lastName: String? = null,
    val phone: String? = null
) {
    constructor(
        model: User
    ) : this(
        email=model.email,
        id=model.id,
        plan=model.subscription,
        firstName=model.firstName,
        lastName=model.lastName,
        phone=model.phone
    )
    val model: User get() =
        User.builder()
            .email(email)
            .subscription(plan)
            .firstName(firstName)
            .lastName(lastName)
            .phone(phone)
            .id(id)
            .build()
}

data class PackageInfo(
    val labelType: LabelType,
    val id: String? = null,
    val returnId: String? = null,
    val label: String ="", // label is an absolute file path
    val description: String? = null, // additional info provided by user
) {
    val model: Labels get() =
        Labels.builder()
            .type(labelType)
            .returnsId(returnId)
            .id(id)
            .image(label.toString())
            .build()
}

data class PickupInfo(
    val userId: String? = null,
    val date: LocalDate = LocalDate.now(),
    val packages: List<PackageInfo> = listOf(),
    val id: String? = null,
    val address: String? = null,
    val method: PickupMethod? = null,
    val plan: PricingPlan? = null,
    val status: PickupStatus? = null,
    val confirmationNumber: String? = null,
) {
    val tax get() = 0.00
    val cost get() =
        when (plan) {
            PricingPlan.BRONZE -> 3.99 * packages.size.toDouble()
            PricingPlan.SILVER -> 0.00
            PricingPlan.GOLD -> 0.00
            PricingPlan.PLATINUM -> 0.00
            else -> 0.00
        }
    val total get() = tax + cost

    val model: Returns get() =
        Returns.builder()
            .userId(userId)
            .date(Temporal.Date(date.toString()))
            .method(method)
            .address(address)
            .confrimationNumber(confirmationNumber)
            .status(status)
            .id(id)
            .build()
}

data class AddressInfo(
    val country: String= "",
    var state: String = "",
    val city: String = "",
    val zipcode: String = "",
    val street: String = "",
    val unit: String = "",
)