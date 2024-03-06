package com.example.returnpals.mainMenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.ui.loginOptions
import com.example.returnpals.services.LoginViewModel

var viewModelLogin = LoginViewModel()
@Composable
fun SignIn(navController: NavController) {
    loginOptions().LoginUISate(viewModelLogin)
}