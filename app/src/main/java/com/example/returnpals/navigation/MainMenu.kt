package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.MainMenuScreen
import com.example.returnpals.dataRepository.CognitoMainMenuScreenRepository
import com.example.returnpals.viewmodel.MainMenuScreenViewModel

//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenu(navController: NavController) {


    //Create view model
    val viewModel = MainMenuScreenViewModel(
        CognitoMainMenuScreenRepository(),
    )
    val readyToNav by viewModel.readyToNav.observeAsState()
    if (readyToNav != null) {
        navController.goto(readyToNav!!)
    }
    MainMenuScreen(viewModel)
}




