package com.example.returnpals

import android.location.Address
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.returnpals.composetools.PickupMethodUI
import com.example.returnpals.composetools.ConfirmPickup
import com.example.returnpals.composetools.PackagesUI
import com.example.returnpals.composetools.PickupDateUI
import com.example.returnpals.composetools.PricingUI
import com.example.returnpals.composetools.ThankYou
import com.example.returnpals.composetools.dashboard.SelectAddressContent
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

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

object ScheduleReturn {}

@Composable
fun ScheduleReturn(
    navController: NavController,
    pickupInfo: PickupInfo,
) {

    val viewModel = remember { ScheduleReturnViewModel(pickupInfo) }
    val step = remember { mutableIntStateOf(1) }
    val state = viewModel.pickup.collectAsState();

    val confirm = ConfirmPickup()
    val thanks = ThankYou()

    val minDate = LocalDate.now().minusDays(1)
    val maxDate = LocalDate.now().plusMonths(2)

    when (step.intValue) {
        1 -> PickupDateUI(
                date = state.value.date,
                onChangeDate = { state.value.date = it },
                onClickNext = { step.intValue++ },
                onClickBack = { step.intValue-- },
                isValidDate = { state.value.date > minDate && state.value.date < maxDate }
            )
        2 -> SelectAddressContent(
                navController = navController,
            )
        3 -> PickupMethodUI(
                method = state.value.method,
                onClickNext = {},
                onClickBack = {},
                onChangeMethod = {},
            )
        4 -> PricingUI(
                onClickNext = {},
                onClickBack = {},
                onChangePlan = {},
                plan = state.value.pricing,
            )
        5 -> PackagesUI(
                packages = state.value.packages.values.toList(),
                onAddLabel = {},
                onRemoveLabel = {},
                onClickNext = {},
                onClickBack = {},
            )
        6 -> confirm.drawConfirmPickup(
                typeOfPickup = state.value.method.toString(),
//            TODO: change type of pickupDate parameter to LocalDate
//               OR change type of PackageInfo.date to Calendar
//            TODO: show pricing only if BRONZE plan is selected
                pickUpAddress = state.value.address!!,
                nextButton = { step.intValue++ },
                backButton = { step.intValue-- },
                promoButton = {}
            )
        7 -> thanks.drawThankYouUI(
                dashBoardButton = { /* TODO: navigate to dashboard */ },
            )
    }

}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////
// other files need not be aware of or concerned with everything below here

private class ScheduleReturnViewModel(init: PickupInfo) : androidx.lifecycle.ViewModel() {

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