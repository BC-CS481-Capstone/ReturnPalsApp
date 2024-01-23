package com.example.returnpals.mainMenu

import MainMenuScaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController



@Composable
fun SignIn(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        SignInContent(navController = navController)
    }
}
@Composable
fun SignInContent(navController: NavController) {
    Text(text = "Test6")
}