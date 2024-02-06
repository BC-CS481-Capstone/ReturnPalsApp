package com.example.returnpals

import android.location.Address
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
        private val _pickup: MutableStateFlow<PickupInfo>
        val pickup: StateFlow<PickupInfo>

        init {
            _pickup = MutableStateFlow(init)
            pickup = _pickup.asStateFlow()
            // _pickup.value and pickup.value should NOT be null after init
        }

        fun onChangeDate(value: LocalDate) {
            _pickup.update {
                it.date = value
                it
            }
        }

        fun onChangeAddress(value: Address) {
            _pickup.update {
                it.address = value
                it
            }
        }

        fun onChangePickupMethod(value: PickupMethod) {
            _pickup.update {
                it.method = value
                it
            }
        }

        fun onAddLabel(value: PackageInfo) {
            _pickup.update {
                val label = value.copy(id=idManager.allot())
                it.packages[label.id] = label
                it
            }
        }

        fun onRemoveLabel(id: Long) {
            _pickup.update {
                it.packages.remove(id)
                idManager.free(id)
                it
            }
        }

        fun onChangePricingPlan(value: PricingPlan) {
            _pickup.update {
                it.pricing = value
                it
            }
        }

    }

}