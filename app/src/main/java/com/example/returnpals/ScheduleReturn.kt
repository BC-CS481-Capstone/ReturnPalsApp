package com.example.returnpals

import android.location.Address
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.returnpals.composetools.PickupMethodUI
import com.example.returnpals.composetools.ConfirmPickup
import com.example.returnpals.composetools.PackagesUI
import com.example.returnpals.composetools.PickupDateUI
import com.example.returnpals.composetools.PricingUI
import com.example.returnpals.composetools.ThankYou
import com.example.returnpals.composetools.goto
import com.example.returnpals.mainMenu.MenuRoutes
import java.time.LocalDate

/**
 * https://developer.android.com/jetpack/compose/state
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 * https://kotlinlang.org/docs/extensions.html#extension-functions
 */

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

enum class ScheduleReturnStep {
    SelectDate,
    SelectAddress,
    SelectMethod,
    SelectPricing,
    AddLabels,
    Confirmation,
    Thanks;

    operator fun inc(): ScheduleReturnStep {
//        if (this == Thanks) throw overflow error
        return ScheduleReturnStep.values()[this.ordinal+1]
    }

    operator fun dec(): ScheduleReturnStep {
//        if (this == Thanks) throw overflow error
        return ScheduleReturnStep.values()[this.ordinal-1]
    }
}

@Composable
fun DemoScheduleReturn() {
    val controller = rememberNavController()
    ScheduleReturn(
        navController = controller,
    )
}

@Composable
fun ScheduleReturn(
    navController: NavController,
) {
    val step = remember { mutableStateOf(ScheduleReturnStep.values()[0]) }
    val pickupVM = PickupViewModel(PickupInfo())

    ScheduleReturnContent(step.value, pickupVM,
        onClickNext = { step.value++; Log.println(Log.INFO, "onClickNext", step.value.toString()) },
        onClickBack = { step.value--; Log.println(Log.INFO, "onClickBack", step.value.toString()) },
        onSubmit = { goto(navController, MenuRoutes.HomeDash) }
    )

}

open class PickupViewModel(
    pickup: PickupInfo,
) : ViewModel() {

    private val _idManager: IdManager = IdManager()
    private val _data: MutableLiveData<PickupInfo> = MutableLiveData(pickup)
    val data: LiveData<PickupInfo> = _data
    private val _minDate: LocalDate = LocalDate.now().minusDays(1)
    private val _maxDate: LocalDate = LocalDate.now().plusMonths(2)

    // not sure why _data.value is nullable...

    fun isValidDate(value: LocalDate): Boolean {
        return value > _minDate && value < _maxDate
    }

    fun onChangeDate(value: LocalDate) {
        if (isValidDate(value)) _data.value!!.date = value
    }

    fun onChangeAddress(value: Address) {
        _data.value!!.address = value
    }

    fun onChangeMethod(value: PickupMethod) {
        _data.value!!.method = value
    }

    fun onAddLabel(value: PackageInfo) {
        val id = _idManager.allot()
        _data.value!!.packages[id] = value.copy(id=id)
    }

    fun onRemoveLabel(id: Long) {
        _data.value!!.packages.remove(id)
        _idManager.free(id)
    }

    fun onChangePlan(value: PricingPlan) {
        _data.value!!.pricing = value
    }

}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview
@Composable
private fun ScheduleReturnPreview() {
    ScheduleReturnContent(
        ScheduleReturnStep.AddLabels,
        PickupViewModel(PickupInfo()),
        onClickNext = {},
        onClickBack = {},
        onSubmit = {}
    )
}

@Composable
private fun ScheduleReturnContent(
    step: ScheduleReturnStep,
    pickupVM: PickupViewModel,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pickup : PickupInfo by pickupVM.data.observeAsState(PickupInfo())
    val confirm = ConfirmPickup()

    when (step) {
        ScheduleReturnStep.SelectDate -> PickupDateUI(
            date = pickup.date,
            onChangeDate = pickupVM::onChangeDate,
            isValidDate = pickupVM::isValidDate,
            onClickNext = { onClickNext(); onClickNext() },
            onClickBack = onClickBack,
            modifier = modifier)
        ScheduleReturnStep.SelectAddress -> onClickNext()
//            SelectAddressContent(navController = navController)
        ScheduleReturnStep.SelectMethod -> PickupMethodUI(
            method = pickup.method,
            onChangeMethod = pickupVM::onChangeMethod,
            onClickNext = onClickNext,
            onClickBack = { onClickBack(); onClickBack() },
            modifier = modifier)
        ScheduleReturnStep.SelectPricing -> PricingUI(
            plan = pickup.pricing,
            onChangePlan = pickupVM::onChangePlan,
            onClickNext = onClickNext,
            onClickBack = onClickBack,
            modifier = modifier)
        ScheduleReturnStep.AddLabels -> PackagesUI(
            packages = pickup.packages.values.toList(),
            onAddLabel = pickupVM::onAddLabel,
            onRemoveLabel = pickupVM::onRemoveLabel,
            onClickNext = onClickNext,
            onClickBack = onClickBack)
        ScheduleReturnStep.Confirmation -> confirm.drawConfirmPickup(
            typeOfPickup = pickup.method.toString(),
//            TODO: change type of pickupDate parameter to LocalDate
//               OR change type of PackageInfo.date to Calendar
//            TODO: show pricing only if BRONZE plan is selected
            pickUpAddress = pickup.address!!,
            nextButton = onClickNext,
            backButton = onClickBack,
            promoButton = {})
        ScheduleReturnStep.Thanks -> ThankYou().drawThankYouUI(
            dashBoardButton = onSubmit
        )
    }

}