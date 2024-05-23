package com.example.returnpals.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.goto(route: String) {
    Log.i("NavController", "Going to $route screen.")
    val controller = this
    this.navigate(route) {
        // Clear all the back stack up to the start destination and save state
        popUpTo(controller.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when re-selecting the same item
        launchSingleTop = true
        // Restore state when navigating back to the composable
        restoreState = true
    }
}

fun go2(
    controller: NavController,
    route: String,
) {
    Log.i("go2", "Going to $route screen.")
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