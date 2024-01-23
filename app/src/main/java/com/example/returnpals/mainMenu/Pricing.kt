package com.example.returnpals.mainMenu


import MainMenuScaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController



@Composable
fun Pricing(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        PricingContent(navController = navController)
    }
}

@Composable
fun PricingContent(navController: NavController) {
    Text(text = "Test3")


}