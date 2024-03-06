package com.example.returnpals.composetools

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.mainMenu.MenuRoutes

fun goto(
    controller: NavController,
    route: String,
) {
    controller.navigate(MenuRoutes.SelectAddress) {
        // Clear all the back stack up to the start destination and save state
        popUpTo(controller.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        // Restore state when navigating back to the composable
        restoreState = true
    }
}

fun go2(
    controller: NavController,
    route: String,
) {
    controller.navigate(route) {
        // Clear all the back stack up to the start destination and save state
        popUpTo(controller.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        // Restore state when navigating back to the composable
        restoreState = true
    }
}