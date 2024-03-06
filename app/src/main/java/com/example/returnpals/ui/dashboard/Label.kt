package com.example.returnpals.ui.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.ui.pickup.AddPackagesScreen

@Composable
fun Label(navController: NavController) {
    AddPackagesScreen(
        packages = mapOf(
            1 to PackageInfo(
                "Nordstrom.png",
                PackageLabelType.DIGITAL,
            )
        ),
        onAddLabel = {},
        onRemoveLabel = {},
        onClickNext = {},
        onClickBack = {},
    )
}

@Composable
fun LabelContent(navController: NavController) {

}