package com.example.returnpals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.MainMenuScreen
import com.example.returnpals.composetools.mainMenu.MainMenuScreenViewModel
import com.example.returnpals.data.CognitoMainMenuScreenRepository

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
    LaunchedEffect(context) {
        //Launch API call to talk to server
        viewModel.checkSignedIn()
    }
    MainMenuScreen(
        mainMenuScreenViewModel = viewModel,
        )
}




