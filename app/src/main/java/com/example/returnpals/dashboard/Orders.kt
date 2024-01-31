package com.example.returnpals.dashboard

import DashboardMenuScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun Orders(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        OrdersContent(navController = navController)
    }
}
@Composable
fun OrdersContent(navController: NavController) {

}