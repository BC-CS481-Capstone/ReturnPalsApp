package com.example.returnpals.navigation

import MainMenuScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.composetools.mainMenu.AboutContent
import com.example.returnpals.composetools.mainMenu.ContactContent
import com.example.returnpals.composetools.mainMenu.FAQContent
import com.example.returnpals.composetools.mainMenu.HomeContent
import com.example.returnpals.composetools.mainMenu.PricingContent
import com.example.returnpals.data.CognitoMainMenuRepository

//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenu(navController: NavController) {
    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf("Home") }
    var isSignedIn by remember {mutableStateOf<Boolean?>(null)}
    LaunchedEffect(context) {
        CognitoMainMenuRepository().isSignedIn { isSignedIn = it }
    }
    if (selectedItem == "Sign In") {
        if (isSignedIn == true) {
            navController.navigate(MenuRoutes.HomeDash) { // Clear all the back stack up to the start destination and save state
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when reselecting the same item
                launchSingleTop = true
                // Restore state when navigating back to the composable
                restoreState = true
            }
        } else if (isSignedIn == false) {
            navController.navigate(MenuRoutes.SignIn) { // Clear all the back stack up to the start destination and save state
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when reselecting the same item
                launchSingleTop = true
                // Restore state when navigating back to the composable
                restoreState = true
            }
        }

    }
    MainMenuScaffold(navController = navController,{selectedItem = it }) {
        when(selectedItem){
            "Home"->HomeContent(){selectedItem = "Sign In" }
            "About"->AboutContent()
            "Pricing"-> PricingContent()
            "Contact"-> ContactContent()
            "FAQ"-> FAQContent()
        }
    }
}

