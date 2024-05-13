package com.returnpal.androidapp.services

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.returnpal.androidapp.IdManager
import com.returnpal.androidapp.PackageInfo
import com.returnpal.androidapp.PickupInfo
import java.time.LocalDate

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

    // Row ID is not the same as a package ID, package ID is what you use to reference the label in the remote amplify database.
    // Row ID is what you use to reference the package info object in the local map/table stored in this view model.
    // Row ID is needed so that the user can click on a label in the labels table and update or remove that specific label.
    // This is confusing and needs rework.
    private val _packageRowIdManager: IdManager = IdManager()

    // https://developer.android.com/topic/libraries/architecture/livedata

    val date = mutableStateOf(date)
    val address = mutableStateOf(address)
    val method = mutableStateOf(method)
    val plan = mutableStateOf(pricing)
    val packages = mutableStateMapOf(*_packageRowIdManager.allot(packages).toTypedArray())

    /**
     * Constructs a PickupInfo object from mutable state.
     */
    val info get() =
        PickupInfo(
            date = date.value,
            address = address.value,
            method = method.value,
            plan = plan.value,
            packages = packages.values.toList(),
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
        val rowId = _packageRowIdManager.allot()
        packages[rowId] = value
        Log.println(Log.INFO, "PickupViewModel::onAddLabel", "Inserted key-value pair: { $rowId , ${packages[rowId]} }")
    }

    // The row
    fun onRemoveLabel(rowId: Int) {
        packages.remove(rowId)
        _packageRowIdManager.free(rowId)
        Log.println(Log.INFO, "PickupViewModel::onRemoveLabel", "Removed entry with key $rowId")
    }

    fun onUpdateLabel(rowId: Int, info: PackageInfo) {
        packages[rowId] = info
        Log.println(Log.INFO, "PickupViewModel::onUpdateLabel", "Updated entry with key $rowId")
    }

}