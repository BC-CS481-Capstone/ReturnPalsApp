package com.example.returnpals.dashboard

import DashboardMenuScaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SelectAddress(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        SelectAddressContent()
    }
}


@Composable
fun SelectAddressContent() {
    Text(text = "Select Address")
}