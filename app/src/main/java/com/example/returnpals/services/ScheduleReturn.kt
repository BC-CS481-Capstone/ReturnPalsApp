package com.example.returnpals.services

import android.util.Log
import androidx.navigation.NavController
import com.example.returnpals.composetools.goto
import com.example.returnpals.mainMenu.MenuRoutes
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
        // TODO: send pickup info to repository
        Log.println(Log.INFO, "ScheduleReturnViewModel::onSubmit", pickup.value.toString())
    }

    fun onCancel() {
        if (navController != null)
            goto(navController, MenuRoutes.Home)
        Log.println(Log.INFO, "ScheduleReturnViewModel::onCancel", "")
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