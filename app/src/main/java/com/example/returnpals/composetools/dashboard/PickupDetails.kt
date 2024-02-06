package com.example.returnpals.composetools.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.PickupMethod
import com.example.returnpals.ScheduleReturn
import com.example.returnpals.composetools.PickupMethodUI

@Composable
fun PickupDetails(navController: NavController) {
    PickupMethodUI(
        method = PickupMethod.DOORSTEP,
        onChangeMethod = {},
        onClickNext = {},
        onClickBack = {}
    )
}
