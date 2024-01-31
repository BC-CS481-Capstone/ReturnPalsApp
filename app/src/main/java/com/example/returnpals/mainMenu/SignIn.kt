package com.example.returnpals.mainMenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.composetools.loginOptions
@Composable
fun SignIn(navController: NavController) {
    loginOptions().drawLoginUI(    user = {},
    pass = { } ,
    guest = { } ,
    reset = { } ,
    signin = { } ,
    signup = { } )
}