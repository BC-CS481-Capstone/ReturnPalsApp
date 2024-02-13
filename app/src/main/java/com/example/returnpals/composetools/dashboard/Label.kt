package com.example.returnpals.composetools.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.composetools.PackagesUI

@Composable
fun Label(navController: NavController) {
    PackagesUI(
        packages = listOf(
            PackageInfo(
                1,
                "Nordstrom.png",
                PackageLabelType.DIGITAL,
                "Digital"
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