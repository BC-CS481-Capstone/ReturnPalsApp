package com.example.returnpals.dashboard

import DashboardMenuScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun Profile(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        ProfileContent(navController = navController)
    }
}
@Composable
fun ProfileContent(navController: NavController) {

}