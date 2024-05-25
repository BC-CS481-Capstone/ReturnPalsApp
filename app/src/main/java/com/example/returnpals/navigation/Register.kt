package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.returnpals.composetools.login.ConfirmEmailScreen
import com.example.returnpals.composetools.login.RegisterScreen
import com.example.returnpals.dataRepository.RegisterRepositoryAmplify
import com.example.returnpals.services.ConfirmEmailViewModel
import com.example.returnpals.viewmodel.RegisterViewModel
val registerRepository = RegisterRepositoryAmplify()
val registerVM = RegisterViewModel(registerRepository)
@Composable
fun Register(navController: NavController) {

    val confirmEmailVM = ConfirmEmailViewModel()
    /** Navigation Logic HERE */
    //Condition variables from view models
    val confirmSuccessful by confirmEmailVM.confirmSuccessful.observeAsState()
    if (confirmSuccessful == true) navController.goto(MenuRoutes.SignIn)
    /** Navigation Logic STOP */
    val submissionSuccessful by registerVM.submissionSuccessful.observeAsState()
    val registerUIState by registerVM.uiState.collectAsState()
    if (submissionSuccessful == true) {
        ConfirmEmailScreen(navController, ConfirmEmailViewModel(registerUIState.email))
    }
    RegisterScreen(registerVM)
}