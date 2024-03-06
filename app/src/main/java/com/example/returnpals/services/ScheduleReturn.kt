package com.example.returnpals.services

import android.util.Log
import androidx.navigation.NavController
import com.example.returnpals.composetools.AddressItem
import com.example.returnpals.composetools.OrderRepository
import java.time.LocalDate

/**
 * https://developer.android.com/jetpack/compose/state
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 * https://kotlinlang.org/docs/extensions.html#extension-functions
 */

/** Informative articles to learn more about how view-models work with Jetpack Compose:
 * https://developer.android.com/jetpack/compose/state-hoisting#viewmodels-as-state-owner
 * https://developer.android.com/topic/architecture/ui-layer/stateholders#ui-logic
 * https://developer.android.com/topic/libraries/architecture/viewmodel#best-practices
 * https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis
 */

class ScheduleReturnViewModel(
    pickup: PickupInfo = PickupInfo(),
    val navController: NavController? = null,
    private val minDate: LocalDate = LocalDate.now().minusDays(1),
    private val maxDate: LocalDate = LocalDate.now().plusYears(1),
) : PickupViewModel(pickup) {

    fun isValidDate(value: LocalDate): Boolean {
        return run {
            value > minDate && value < maxDate
        }.also {
            Log.println(Log.INFO, "ScheduleReturnViewModel::isValidDate", it.toString())
        }
    }

    fun onSubmit() {
        val order = OrderRepository(
            Backend.getEmail(),
            info.date,
            AddressItem(1, info.address.toString()),
            "Submitted"
        )
        order.setNotes("address", info.address.toString())
        order.setNotes("method", info.method.toString())
        order.setNotes("plan", info.plan.toString())
        Backend.createOrder(order)

        Log.println(Log.INFO, "ScheduleReturnViewModel::onSubmit", info.toString())
    }
//    companion object {
//
//        // This determines the default value for the view-model that gets instantiated in navigation.
//        // https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                ScheduleReturnViewModel(
//                    navController = ,
//                )
//            }
//        }
//
//    }

}