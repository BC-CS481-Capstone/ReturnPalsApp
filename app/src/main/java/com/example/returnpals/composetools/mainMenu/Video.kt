package com.example.returnpals.composetools.mainMenu

import MainMenuScaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController




@Composable
fun Video(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        VideoContent()
    }
}
@Composable
fun VideoContent() {
    Text(text = "Test4")
}