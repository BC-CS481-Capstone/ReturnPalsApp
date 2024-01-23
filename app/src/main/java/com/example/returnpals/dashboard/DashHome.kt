package com.example.returnpals.dashboard

import DashboardMenuScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun HomeDash(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        HomeDashContent(navController = navController)
    }
}
@Composable
fun HomeDashContent(navController: NavController) {


}