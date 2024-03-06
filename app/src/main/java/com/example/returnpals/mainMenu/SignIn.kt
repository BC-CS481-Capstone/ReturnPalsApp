package com.example.returnpals.mainMenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.composetools.LoginScreen
import com.example.returnpals.services.LoginViewModel

var viewModelLogin = LoginViewModel()
@Composable
fun SignIn(navController: NavController) {
    LoginScreen(viewModelLogin, navController)
}