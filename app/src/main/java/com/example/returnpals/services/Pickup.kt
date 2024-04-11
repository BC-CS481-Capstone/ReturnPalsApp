package com.example.returnpals.services

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.returnpals.IdManager
import com.example.returnpals.PackageInfo
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

data class PickupInfo(
    var date: LocalDate = LocalDate.now(),
    var address: String? = null,
    var method: PickupMethod? = null,
    var plan: PricingPlan? = null,
    var packages: List<PackageInfo> = listOf()
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

open class PickupViewModel(
    date: LocalDate = LocalDate.now(),
    address: String? = null,
    method: PickupMethod? = null,
    pricing: PricingPlan? = null,
    packages: List<PackageInfo> = listOf()
) : ViewModel() {

    constructor(
        pickup: PickupInfo,
    ) : this(
        date=pickup.date,
        address=pickup.address,
        method=pickup.method,
        pricing=pickup.plan,
        packages=pickup.packages
    )

    private val _packageIdManager: IdManager = IdManager()

    // https://developer.android.com/topic/libraries/architecture/livedata

    val date = mutableStateOf(date)
    val address = mutableStateOf(address)
    val method = mutableStateOf(method)
    val plan = mutableStateOf(pricing)
    val packages = mutableStateMapOf(*_packageIdManager.allot(packages).toTypedArray())

    /**
     * Constructs a PickupInfo object from mutable state.
     */
    val info get() =
        PickupInfo(
            date = date.value,
            address = address.value,
            method = method.value,
            plan = plan.value,
            packages = packages.values.toList()
        )

    val isValid get() =
        address.value != null &&
        method.value != null &&
        plan.value != null

    fun onChangeDate(value: LocalDate) {
        date.value = value
        Log.println(Log.INFO, "PickupViewModel::onChangeDate", "Updated value: ${date.value}")
    }

    fun onChangeAddress(value: String) {
        address.value = value
        Log.println(Log.INFO, "PickupViewModel::onChangeAddress", "Updated value: ${address.value}")
    }

    fun onChangeMethod(value: PickupMethod) {
        method.value = value
        Log.println(Log.INFO, "PickupViewModel::onChangeAddress", "Updated value: ${method.value}")
    }

    fun onChangePlan(value: PricingPlan) {
        plan.value = value
        Log.println(Log.INFO, "PickupViewModel::onChangePlan", "Updated value: $plan")
    }

    fun onAddLabel(value: PackageInfo) {
        val id = _packageIdManager.allot()
        packages[id] = value
        Log.println(Log.INFO, "PickupViewModel::onAddLabel", "Inserted key-value pair: { $id , ${packages[id]} }")
    }

    fun onRemoveLabel(id: Int) {
        packages.remove(id)
        _packageIdManager.free(id)
        Log.println(Log.INFO, "PickupViewModel::onRemoveLabel", "Removed entry with key $id")
    }

}