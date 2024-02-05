package com.example.returnpals.composetools

import android.location.Address
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

/**
 * https://developer.android.com/jetpack/compose/state
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 */

@RequiresApi(Build.VERSION_CODES.O)
class ScheduleReturnViewModel(init: PickupInfo) : ViewModel() {

    private val _pickup: MutableLiveData<PickupInfo>
    val pickup: LiveData<PickupInfo>

    init {
        _pickup = MutableLiveData<PickupInfo>(init)
        pickup = _pickup
    }

    fun onChangeDate(value: LocalDate) {
        _pickup.value!!.date = value
    }

    fun onChangeAddress(value: Address) {
        _pickup.value!!.address = value
    }

    fun onChangePickupMethod(value: PickupMethod) {
        _pickup.value!!.method = value
    }

    fun onAddLabel(id: Int, value: PackageInfo) {
        _pickup.value!!.packages[id] = value
    }

    fun onRemoveLabel(id: Int) {
        _pickup.value!!.packages.remove(id)
    }

    fun onChangePricingPlan(value: Plan) {
        _pickup.value!!.pricing = value
    }

}