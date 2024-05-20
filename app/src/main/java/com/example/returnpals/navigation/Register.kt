package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.RegisterScreen
import com.example.returnpals.data.RegisterRepository
import com.example.returnpals.viewmodel.RegisterUserInfo
import com.example.returnpals.viewmodel.RegisterViewModel

@Composable
fun Register(navController:NavController) {
    val registerViewModel = RegisterViewModel(navController = navController, registerRepository = TestRepositoryforRegister() )
    RegisterScreen(viewModel())
}

class TestRepositoryforRegister: RegisterRepository {

    override fun registerUser(registerUserInfo: RegisterUserInfo, errorMessage: (String?) -> Unit) {
        TODO("Not yet implemented")
    }


}