/*

package com.example.returnpals.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.navigation.MenuRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardMenu(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        /*Image(
                            painter = painterResource(id = R.drawable.returnpal_500x196),
                            contentDescription = "ReturnPals Logo",
                            modifier = Modifier.size(190.dp) // Adjust the size as needed

                        )*/
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open() // Open the drawer
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                backgroundColor = Color.White, // Set background color to white
                elevation = 4.dp // Adjust elevation for shadow
            )
        },
        drawerContent = {
            DrawerContent(navController = navController, scaffoldState = scaffoldState)
        }
    ) {

    }
}


@Composable
fun DrawerContent(navController: NavController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf("") }

    Column {
        DrawerItem(title = "Dashboard", isSelected = selectedItem == "Dashboard", onClick = {
            selectedItem = "Dashboard"
            navigateToScreen(navController, MenuRoutes.HomeDash, scaffoldState, scope)
        })
        DrawerItem(title = "Profile", isSelected = selectedItem == "Profile", onClick = {
            selectedItem = "Profile"
            navigateToScreen(navController, MenuRoutes.Profile, scaffoldState, scope)
        })
        DrawerItem(title = "Orders", isSelected = selectedItem == "Orders", onClick = {
            selectedItem = "Orders"
            navigateToScreen(navController, MenuRoutes.Orders, scaffoldState, scope)
        })
        DrawerItem(title = "Settings", isSelected = selectedItem == "Settings", onClick = {
            selectedItem = "Settings"
            navigateToScreen(navController, MenuRoutes.Settings, scaffoldState, scope)
        })

        //Add more if needed
    }
}

@Composable
fun DrawerItem(title: String, isSelected: Boolean, onClick: () -> Unit) {
    val selectedBlue = Color(0xFF008BE7)
    val dashBlue = Color(0xFF052A42)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(dashBlue)
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            ),
            color = if (isSelected) selectedBlue else Color.White,
            modifier = Modifier.padding(2.dp)

        )

    }
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


 */
