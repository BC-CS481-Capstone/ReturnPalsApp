package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.returnpals.PricingPlan
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
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    Column ( modifier = Modifier
        .fillMaxSize()
        .background(Brush.verticalGradient(colors = gradientColors))
        .padding(16.dp)

    ) {


        PricingOptions(
            selected = state.plan.collectAsState().value,
            onClickPlan = { state.onChangePlan(it) },
            modifier = Modifier.fillMaxSize()
        )
    }
}