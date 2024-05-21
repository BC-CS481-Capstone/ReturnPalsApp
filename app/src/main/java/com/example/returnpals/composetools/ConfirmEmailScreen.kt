package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.compose.ReturnPalTheme
import com.example.returnpals.mainMenu.MenuRoutes
import com.example.returnpals.services.ConfirmEmailViewModel

@Composable
fun ConfirmEmailScreen(
    navController: NavController,
    confirmVM: ConfirmEmailViewModel
) {
    val confirmSuccess by confirmVM.confirmSuccessful.observeAsState()
    if (confirmSuccess == true) navController.goto(MenuRoutes.SignIn)
    Box(modifier = Modifier
        .background(ReturnPalTheme.colorScheme.background)
        .fillMaxSize()) {
        ConfirmEmailContent(
            emailToConfirm = confirmVM.email,
            message = confirmVM.message,
            submitNumber = confirmVM.code,
            onSubmitNumberChange = { confirmVM.code = it },
            verifyButton = confirmVM::confirm
        )
    }
}