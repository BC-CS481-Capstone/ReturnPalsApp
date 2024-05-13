package com.returnpal.androidapp.mainMenu

import SettingsViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.returnpal.androidapp.compose.ConfirmEmailScreen
import com.returnpal.androidapp.compose.LoginScreen
import com.returnpal.androidapp.compose.dashboard.HomeDash
import com.returnpal.androidapp.compose.dashboard.Orders
import com.returnpal.androidapp.compose.dashboard.Profile
import com.returnpal.androidapp.compose.dashboard.Settings
import com.returnpal.androidapp.compose.nav.goto
import com.returnpal.androidapp.compose.pickup.AddPackagesScreen
import com.returnpal.androidapp.compose.pickup.ConfirmPickupScreen
import com.returnpal.androidapp.compose.pickup.PickupDateScreen
import com.returnpal.androidapp.compose.pickup.PickupMethodScreen
import com.returnpal.androidapp.compose.pickup.PricingScreen
import com.returnpal.androidapp.compose.pickup.SelectAddressScreen
import com.returnpal.androidapp.compose.pickup.ThankYouScreen
import com.returnpal.androidapp.compose.pickup.ThankYouViewModel
import com.returnpal.androidapp.services.ConfirmEmailViewModel
import com.returnpal.androidapp.services.LoginViewModel
import com.returnpal.androidapp.services.OrderViewModel

@Composable
fun AppNavigation(navController: NavController) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = MenuRoutes.Home
    ) {

        composable(MenuRoutes.Home) { entry ->
            val loginVM = entry.sharedViewModel<LoginViewModel>(navController)
            HomeScreen(navController) {
                if (loginVM.logInSuccessful.value == true) navController.goto(MenuRoutes.HomeDash)
                else if (loginVM.isGuest) navController.goto(MenuRoutes.PickupProcess)
                else navController.goto(MenuRoutes.SignIn)
            }
        }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { Contact(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.SignIn) { entry ->
            val loginVM = entry.sharedViewModel<LoginViewModel>(navController)
            val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
            LoginScreen(loginVM, settingsVM, navController)
        }
        composable(MenuRoutes.FAQ) { FAQ(navController) }
        composable(MenuRoutes.Register) { RegistrationScreen(navController)}

        navigation(
            startDestination = MenuRoutes.HomeDash,
            route = "dashboard home"
        ) {
            composable(MenuRoutes.HomeDash) { HomeDash(navController) }
            composable(MenuRoutes.Profile) { Profile(navController) }
            composable(MenuRoutes.Settings) { Settings(navController) }
            composable(MenuRoutes.Orders) { Orders(navController) }
            // composable(MenuRoutes.SelectAddress) { SelectAddress(navController) }
            // composable(MenuRoutes.PickupDetails) { PickupDetails(navController) }
            //  composable(MenuRoutes.Label) { Label(navController) }
        }
        composable(MenuRoutes.ConfirmNumber) {
            val vm = ConfirmEmailViewModel()
            ConfirmEmailScreen(navController,vm) }

        navigation(
            startDestination = "select_date",
            route = MenuRoutes.PickupProcess
        ) {
            composable("select_date") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                PickupDateScreen(
                    date = pickupVM.date.value,
                    onChangeDate = pickupVM::onChangeDate,
                    isValidDate = pickupVM::isValidDate,
                    onClickNext = { navController.navigate("select_address") },
                    onClickBack = { navController.navigate(MenuRoutes.HomeDash) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    } },
                )
            }
            composable("select_address") { entry ->
//                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
//                val addressesVM = entry.sharedViewModel<AddressesViewModel>(navController)
                // TODO: retrieve addresses from user account
                // TODO: send added addresses to user account
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                SelectAddressScreen(
                    addresses = settingsVM.userAddresses.collectAsState().value,
                    selectedAddressId = settingsVM.selectedAddressId.collectAsState().value,
                    onSelectAddress = settingsVM::selectAddress,
                    onAddAddress = settingsVM::addNewAddress,
                    onClickNext = { navController.navigate("select_method") },
                    onClickBack = { navController.navigate("select_date") }
                )
            }
            composable("select_method") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                PickupMethodScreen(
                    method = pickupVM.method.value,
                    onChangeMethod = pickupVM::onChangeMethod,
                    onClickNext = { navController.navigate("select_pricing") },
                    onClickBack = { navController.navigate("select_address") },
                )
            }
            composable("select_pricing") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                PricingScreen(
                    plan = pickupVM.plan.value,
                    onChangePlan = pickupVM::onChangePlan,
                    onClickNext = { navController.navigate("add_labels") },
                    onClickBack = { navController.navigate("select_method") },
                )
            }
            composable("add_labels") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                AddPackagesScreen(
                    packages = pickupVM.packages.toMap(),
                    onAddLabel = pickupVM::onAddLabel,
                    onRemoveLabel = pickupVM::onRemoveLabel,
                    onUpdateLabel = pickupVM::onUpdateLabel,
                    onClickNext = { navController.navigate("confirm") },
                    onClickBack = { navController.navigate("select_pricing") },
                )
            }
            composable("confirm") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val thankyouVM = ThankYouViewModel()
                val hasUserName by thankyouVM.hasUserNames.observeAsState()
                val createReturnSuccessful by pickupVM.createReturnSuccessful.observeAsState()
                val createLabelsSuccessful by pickupVM.createLabelsSuccessful.observeAsState()
                if (hasUserName != true) {
                    thankyouVM.init()
                }
                if (hasUserName == true) {
                    ConfirmPickupScreen(
                        info = pickupVM.info,
                        onClickNext = {
                            if (hasUserName == true) {
                                pickupVM.onSubmit(thankyouVM.userEmail.value)
                            }
                        },
                        onClickBack = { navController.navigate("add_labels") },
                        onClickPromoButton = {}
                    )
                    if (createReturnSuccessful == true) {
                        pickupVM.submitLabels()
                        if (createLabelsSuccessful == true) {
                            navController.navigate("thanks")
                        }
                    }
                }
            }
            composable("thanks") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                ThankYouScreen(
                    dashBoardButton = {
                        navController.navigate("dashboard home") {
                            popUpTo(MenuRoutes.PickupProcess) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

    }

}


// magic https://youtu.be/FIEnIBq7Ups?si=O2ePHcmj0VsmQ7R-
@Composable
inline fun <reified T:ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val parentRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(parentRoute)
    }
    return viewModel(parentEntry)
}