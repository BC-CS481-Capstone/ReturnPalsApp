package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.RegisterContent
import com.example.returnpals.viewmodel.RegisterViewModel

@Composable
fun Register(navController:NavController) {
    val registerViewModel = RegisterViewModel()
    RegisterContent(navController = navController, onCancel = {}, onClick = {},registerViewModel)
}