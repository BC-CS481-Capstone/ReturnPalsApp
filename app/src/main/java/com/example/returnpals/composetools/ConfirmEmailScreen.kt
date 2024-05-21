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
import com.example.returnpals.services.LoginViewModel

@Composable
fun ConfirmEmailScreen(navController: NavController, confirmVM: ConfirmEmailViewModel, loginVM: LoginViewModel) {
    val confirmSuccessful by confirmVM.confirmSuccessful.observeAsState()
    Box(modifier = Modifier
        .background(ReturnPalTheme.colorScheme.background)
        .fillMaxSize()) {
        ConfirmEmailContent(
            emailToConfirm = confirmVM.email,
            message = confirmVM.message.value,
            submitNumber = confirmVM.code.value,
            onSubmitNumberChange = { confirmVM.code.value = it },
            verifyButton = confirmVM::confirm
        )
    }
    if (confirmSuccessful == true) {
        loginVM.logIn()
        navController.navigate(MenuRoutes.Register) {
            popUpTo(MenuRoutes.Home) {
                // saveState = true
            }
            launchSingleTop = true
            //restoreState = true
        }
    }
}