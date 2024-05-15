package com.example.returnpals.navigation

import MainMenuScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.returnpals.composetools.mainMenu.AboutContent
import com.example.returnpals.composetools.mainMenu.ContactContent
import com.example.returnpals.composetools.mainMenu.FAQContent
import com.example.returnpals.composetools.mainMenu.HomeContent
import com.example.returnpals.composetools.mainMenu.PricingContent

//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenu(navController: NavController) {
    var selectedItem by remember { mutableStateOf("Home") }
    if (selectedItem == "Sign In") {
        navController.navigate(MenuRoutes.SignIn)
    }
    MainMenuScaffold(navController = navController,{selectedItem = it }) {
        when(selectedItem){
            "Home"->HomeContent({selectedItem = "Sign In" })
            "About"->AboutContent()
            "Pricing"-> PricingContent()
            "Contact"-> ContactContent()
            "FAQ"-> FAQContent()
        }
    }
}

