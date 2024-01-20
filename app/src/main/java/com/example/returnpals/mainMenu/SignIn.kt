package com.example.returnpals.mainMenu

import android.widget.Toast
import androidx.compose.material3.Text
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