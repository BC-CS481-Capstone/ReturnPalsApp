package com.example.returnpals.ui.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.PickupMethod
import com.example.returnpals.ui.pickup.PickupMethodScreen
import com.example.returnpals.ui.goto
import com.example.returnpals.mainMenu.MenuRoutes

@Composable
fun PickupDetails(navController: NavController) {
    PickupMethodScreen(
        method = PickupMethod.DOORSTEP,
        onChangeMethod = {},
        onClickNext = {},
        onClickBack = { goto(navController, MenuRoutes.SelectAddress) }
    )
}
