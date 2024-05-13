package com.returnpal.androidapp.compose.mainMenu

import MainMenuScaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController




@Composable
fun Video(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        VideoContent(navController = navController)
    }
}
@Composable
fun VideoContent(navController: NavController) {
    Text(text = "Test4")
}