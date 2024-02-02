package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.composetools.PricingUI


@Composable
fun Pricing(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        PricingContent(navController = navController)
    }
}

@Composable
fun PricingContent(navController: NavController) {
    PricingUI()
}