package com.example.returnpals.services

import android.location.Address
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.IdManager
import com.example.returnpals.PackageInfo
import com.example.returnpals.PickupMethod
import com.example.returnpals.PricingPlan
import java.time.LocalDate

data class PickupInfo(
    var date: LocalDate = LocalDate.now(),
    var address: Address? = null,
    var method: PickupMethod? = null,
    var packages: HashMap<Long, PackageInfo> = hashMapOf(),
    var pricing: PricingPlan? = null,
)

open class PickupViewModel(
    pickup: PickupInfo,
) : ViewModel() {

    constructor(
        date: LocalDate = LocalDate.now(),
        address: Address? = null,
        method: PickupMethod? = null,
        packages: HashMap<Long, PackageInfo> = hashMapOf(),
        pricing: PricingPlan? = null
    ) : this(
        PickupInfo(
            date=date,
            address=address,
            method=method,
            packages=packages,
            pricing=pricing
        )
    )

    private val _idManager: IdManager = IdManager()
    private val _pickup = MutableLiveData(pickup)
    val pickup: LiveData<PickupInfo> = _pickup

    // not sure why _data.value is nullable...

    fun onChangeDate(value: LocalDate) {
        _pickup.value = _pickup.value?.copy()?.apply {
            date = value
            Log.println(Log.INFO, "PickupViewModel::onChangeDate", "Updated value: $date")
        }
    }

    fun onChangeAddress(value: Address) {
        _pickup.value = _pickup.value?.copy()?.apply {
            address = value
            Log.println(Log.INFO, "PickupViewModel::onChangeAddress", "Updated value: $address")
        }
    }

    fun onChangeMethod(value: PickupMethod) {
        _pickup.value = _pickup.value?.copy()?.apply {
            method = value
            Log.println(Log.INFO, "PickupViewModel::onChangeAddress", "Updated value: $method")
        }
    }

    fun onAddLabel(value: PackageInfo) {
        _pickup.value = _pickup.value?.copy()?.apply {
            val id = _idManager.allot()
            packages[id] = value
            Log.println(Log.INFO, "PickupViewModel::onAddLabel", "Inserted key-value pair: { $id , ${packages[id]} }")
        }
    }

    fun onRemoveLabel(id: Long) {
        _pickup.value = _pickup.value?.copy()?.apply {
            packages.remove(id)
            _idManager.free(id)
            Log.println(Log.INFO, "PickupViewModel::onRemoveLabel", "Removed entry with key $id")
        }
    }

    fun onChangePlan(value: PricingPlan) {
        _pickup.value = _pickup.value?.copy()?.apply {
            pricing = value
            Log.println(Log.INFO, "PickupViewModel::onChangePlan", "Updated value: $pricing")
        }
    }

}