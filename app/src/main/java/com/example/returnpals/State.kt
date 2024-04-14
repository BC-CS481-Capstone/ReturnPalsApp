package com.example.returnpals

import android.net.Uri
import com.amplifyframework.datastore.generated.model.LabelType
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

data class PackageInfo(
    val label: Uri = Uri.EMPTY, // label is a filename
    val labelType: LabelType,
    val description: String? = null, // additional info provided by user
)

data class PickupInfo(
    val date: LocalDate = LocalDate.now(),
    val address: String? = null,
    val method: PickupMethod? = null,
    val plan: PricingPlan? = null,
    val packages: List<PackageInfo> = listOf(),
    val status: PickupStatus? = null,
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
}