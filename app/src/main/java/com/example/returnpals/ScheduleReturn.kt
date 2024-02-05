package com.example.returnpals

import android.location.Address
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.time.LocalDate

/**
 * https://developer.android.com/jetpack/compose/state
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 * https://kotlinlang.org/docs/extensions.html#extension-functions
 */

/**
 * This object is extended with ui functions defined in `com.example.returnpals.composetools`.
 * It's used as a namespace, grouping together features related to the "Schedule a Return" action.
 */
object ScheduleReturn {

    @RequiresApi(Build.VERSION_CODES.O)
    class ViewModel(init: PickupInfo) : androidx.lifecycle.ViewModel() {

        private val idManager: IdManager = IdManager()
        private val _pickup: MutableLiveData<PickupInfo>
        val pickup: LiveData<PickupInfo>

        init {
            _pickup = MutableLiveData<PickupInfo>(init)
            pickup = _pickup
            // _pickup.value and pickup.value should NOT be null after init
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

        fun onAddLabel(value: PackageInfo) {
            val label = value.copy(id=idManager.allot())
            _pickup.value!!.packages[label.id] = label
        }

        fun onRemoveLabel(id: ULong) {
            _pickup.value!!.packages.remove(id)
            idManager.free(id)
        }

        fun onChangePricingPlan(value: PricingPlan) {
            _pickup.value!!.pricing = value
        }

    }

}