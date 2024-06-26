package com.example.returnpals.composetools.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.example.returnpals.navigation.goto
import com.example.returnpals.composetools.pickup.PickupMethodScreen
import com.example.returnpals.navigation.MenuRoutes

@Composable
fun PickupDetails(navController: NavController) {
    PickupMethodScreen(
        method = PickupMethod.DOORSTEP,
        onChangeMethod = {},
        onClickNext = {},
        onClickBack = { navController.goto(MenuRoutes.SelectAddress) }
    )
}
