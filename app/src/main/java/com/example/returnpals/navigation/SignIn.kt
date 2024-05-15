package com.example.returnpals.navigation

import SettingsViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.returnpals.composetools.LoginScreen
import com.example.returnpals.composetools.go2
import com.example.returnpals.viewmodel.LoginViewModel


@Composable
fun SignIn(navController: NavController) {
    val viewModelLogin = LoginViewModel()
    val signUpSuccessful by viewModelLogin.signUpSuccessful.observeAsState()
    val logInSuccessful by viewModelLogin.logInSuccessful.observeAsState()
    LoginScreen(viewModelLogin,
        SettingsViewModel(),
        navController,
        signin = {viewModelLogin.logIn() },
        signup = {viewModelLogin.signUp()})

    if (logInSuccessful == true) {
        go2(navController,MenuRoutes.HomeDash)
    }
    if (signUpSuccessful == true) {
        go2(navController,MenuRoutes.ConfirmNumber)
    }
}
