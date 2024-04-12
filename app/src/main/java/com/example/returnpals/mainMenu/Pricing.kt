package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.example.returnpals.composetools.pickup.PricingOptions
import com.example.returnpals.composetools.pickup.PricingViewModel


@Composable
fun Pricing(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        PricingContent(navController = navController)
    }
}

@Composable
fun PricingContent(navController: NavController) {
    val state = remember { PricingViewModel(PricingPlan.BRONZE) }
    PricingOptions(
        selected = state.plan.collectAsState().value,
        onClickPlan = { state.onChangePlan(it) },
        modifier = Modifier.fillMaxSize()
    )
}