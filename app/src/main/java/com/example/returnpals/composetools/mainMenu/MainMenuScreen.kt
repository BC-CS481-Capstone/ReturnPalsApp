package com.example.returnpals.composetools.mainMenu

import MainMenuScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.returnpals.viewmodel.MainMenuScreenViewModel


/**
 * This file is a top level
 *
 *
 * */



//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenuScreen(mainMenuScreenViewModel: MainMenuScreenViewModel) {
    val selectedItem by mainMenuScreenViewModel.contentSet.observeAsState()
    MainMenuScaffold(navigateRoute = mainMenuScreenViewModel::setContent) {
        when(selectedItem){
            "home"->HomeContent(mainMenuScreenViewModel::onMainMenuSignInOrSchedule)
            "about"->AboutContent()
            "pricing"-> PricingContent()
            "contact"-> ContactContent()
            "faq"-> FAQContent()
        }
    }
}


