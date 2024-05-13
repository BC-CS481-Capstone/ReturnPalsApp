package com.returnpal.androidapp.compose.mainMenu

import SettingsViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.returnpal.androidapp.compose.LoginScreen
import com.returnpal.androidapp.services.LoginViewModel

var viewModelLogin = LoginViewModel()
@Composable
fun SignIn(navController: NavController) {
    LoginScreen(viewModelLogin, SettingsViewModel(), navController)
}