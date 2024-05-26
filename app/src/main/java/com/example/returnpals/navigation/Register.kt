package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import com.example.returnpals.composetools.login.RegisterScreen
import com.example.returnpals.viewmodel.RegisterViewModel

@Composable
fun Register(registerVM: RegisterViewModel) {
    RegisterScreen(registerVM)
}