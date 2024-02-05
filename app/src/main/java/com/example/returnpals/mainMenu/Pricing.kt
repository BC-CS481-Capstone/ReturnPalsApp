package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.returnpals.PricingPlan
import com.example.returnpals.composetools.PricingUI
import com.example.returnpals.composetools.PricingViewModel


@Composable
fun Pricing(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        PricingContent(navController = navController)
    }
}

@Composable
fun PricingContent(navController: NavController) {
    val state = remember { PricingViewModel(PricingPlan.BRONZE) }
    PricingUI(
        plan = state.plan.collectAsState().value,
        onChangePlan = { state.onChangePlan(it) },
    )
}