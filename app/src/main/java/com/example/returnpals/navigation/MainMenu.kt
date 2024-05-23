package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.MainMenuScreen
import com.example.returnpals.composetools.mainMenu.MainMenuScreenViewModel
import com.example.returnpals.dataRepository.CognitoMainMenuScreenRepository

//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenu(navController: NavController) {

    val context = LocalContext.current
    //Create view model
    val viewModel = MainMenuScreenViewModel(
        CognitoMainMenuScreenRepository(),
        navController = navController
    )
    MainMenuScreen(viewModel)
}




