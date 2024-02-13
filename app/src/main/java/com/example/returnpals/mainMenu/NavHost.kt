package com.example.returnpals.mainMenu

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.example.returnpals.composetools.dashboard.HomeDash
import com.example.returnpals.composetools.dashboard.Label
import com.example.returnpals.composetools.dashboard.Orders
import com.example.returnpals.composetools.dashboard.PickupDetails
import com.example.returnpals.composetools.dashboard.PickupProcess
import com.example.returnpals.composetools.dashboard.Profile
import com.example.returnpals.composetools.dashboard.SelectAddress
import com.example.returnpals.composetools.dashboard.Settings


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(navController: NavController) {

    // Create the navGraph
    val navGraph = navController.createGraph(startDestination = MenuRoutes.Home) {
        composable(MenuRoutes.Home) { Home(navController) }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { Contact(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.SignIn) { SignIn(navController) }
        composable(MenuRoutes.FAQ) { FAQ(navController) }

        composable(MenuRoutes.HomeDash) { HomeDash(navController) }
        composable(MenuRoutes.Profile) { Profile(navController) }
        composable(MenuRoutes.Settings) { Settings(navController) }
        composable(MenuRoutes.Orders) { Orders(navController) }
        composable(MenuRoutes.PickupProcess) { PickupProcess(navController) }
        composable(MenuRoutes.SelectAddress) { SelectAddress(navController) }
        composable(MenuRoutes.PickupDetails) { PickupDetails(navController) }
        composable(MenuRoutes.Label) { Label(navController) }


        // Add more destinations as needed
    }

    // Use the navGraph in NavHost
    NavHost(navController = navController as NavHostController, graph = navGraph)
}
