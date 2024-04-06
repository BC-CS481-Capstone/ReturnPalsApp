package com.example.returnpals.composetools.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.composetools.pickup.AddPackagesScreen

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