package com.example.returnpals.dashboard

import DashboardMenuScaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController




@Composable
fun Settings(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        SettingsContent(navController = navController)
    }
}
@Composable
fun SettingsContent(navController: NavController){

}