package com.returnpal.androidapp.compose.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.returnpal.androidapp.compose.nav.goto
import com.returnpal.androidapp.compose.pickup.PickupMethodScreen
import com.returnpal.androidapp.compose.nav.MenuRoutes

@Composable
fun PickupDetails(navController: NavController) {
    PickupMethodScreen(
        method = PickupMethod.DOORSTEP,
        onChangeMethod = {},
        onClickNext = {},
        onClickBack = { navController.goto(MenuRoutes.SelectAddress) }
    )
}
