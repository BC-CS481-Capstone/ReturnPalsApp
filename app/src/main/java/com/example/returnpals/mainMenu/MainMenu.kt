package com.example.returnpals.mainMenu

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainMenu() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Return Pals") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open() // Open the drawer
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(navController = navController, scaffoldState = scaffoldState) // Pass scaffoldState here
        }
    ) {

        AppNavigation(navController = navController)
    }
}

@Composable
fun DrawerContent(navController: NavController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()

    Column {
        DrawerItem(title = "Home", onClick = {
            navigateToScreen(navController, MenuRoutes.Home, scaffoldState, scope)
        })
        DrawerItem(title = "About", onClick = {
            navigateToScreen(navController, MenuRoutes.About, scaffoldState, scope)
        })
        DrawerItem(title = "Pricing", onClick = {
            navigateToScreen(navController, MenuRoutes.Pricing, scaffoldState, scope)
        })
        DrawerItem(title = "Video", onClick = {
            navigateToScreen(navController, MenuRoutes.Video, scaffoldState, scope)
        })
        DrawerItem(title = "Contact", onClick = {
            navigateToScreen(navController, MenuRoutes.Contact, scaffoldState, scope)
        })
        DrawerItem(title = "Sign In", onClick = {
            navigateToScreen(navController, MenuRoutes.SignIn, scaffoldState, scope)
        })
        DrawerItem(title = "FAQ", onClick = {
            navigateToScreen(navController, MenuRoutes.FAQ, scaffoldState, scope)
        })
    }
}

@Composable
fun DrawerItem(title: String, onClick: () -> Unit) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
    Divider()
}

// Helper function to navigate to a screen and close the drawer
private fun navigateToScreen(
    navController: NavController,
    route: String,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
    scope.launch {
        scaffoldState.drawerState.close() // Close the drawer
    }
}