package com.returnpal.androidapp.compose.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.returnpal.androidapp.compose.pickup.AddPackagesScreen

@Composable
fun Label(navController: NavController) {
    AddPackagesScreen(

        packages = mapOf(),

        onAddLabel = {},
        onRemoveLabel = {},
        onClickNext = {},
        onClickBack = {},
    )
}

@Composable
fun LabelContent(navController: NavController) {

}