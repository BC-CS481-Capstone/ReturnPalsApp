package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors))
    ){


        PricingUI(
            plan = state.plan.collectAsState().value,
            onChangePlan = { state.onChangePlan(it) },
        )
    }
}

