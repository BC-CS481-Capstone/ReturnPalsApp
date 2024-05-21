package com.example.returnpals.mainMenu

import SettingsViewModel
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.returnpals.composetools.ConfirmEmailScreen
import com.example.returnpals.composetools.LoginScreen
import com.example.returnpals.composetools.dashboard.HomeDash
import com.example.returnpals.composetools.dashboard.Orders
import com.example.returnpals.composetools.dashboard.Profile
import com.example.returnpals.composetools.dashboard.Settings
import com.example.returnpals.composetools.goto
import com.example.returnpals.composetools.pickup.AddPackagesScreen
import com.example.returnpals.composetools.pickup.ConfirmPickupScreen
import com.example.returnpals.composetools.pickup.PickupDateScreen
import com.example.returnpals.composetools.pickup.PickupMethodScreen
import com.example.returnpals.composetools.pickup.PricingScreen
import com.example.returnpals.composetools.pickup.SelectAddressScreen
import com.example.returnpals.composetools.pickup.ThankYouScreen
import com.example.returnpals.composetools.pickup.ThankYouViewModel
import com.example.returnpals.services.ConfirmEmailViewModel
import com.example.returnpals.services.LoginViewModel
import com.example.returnpals.services.OrderViewModel

@Composable
fun AppNavigation(navController: NavController) {
    val loginVM = remember { LoginViewModel("test@bellevue.college","Password123$") }

    NavHost(
        navController = navController as NavHostController,
        startDestination = MenuRoutes.Home
    ) {

        composable(MenuRoutes.Home) { entry ->
            if (loginVM.isLoggedIn == true && !loginVM.isGuest) {
                Log.d("NavHost", "User is already logged in, going to dashboard.")
                navController.goto("dashboard home")
            } else {
                HomeScreen(navController) {
                    if (loginVM.isGuest) navController.goto(MenuRoutes.PickupProcess)
                    else navController.goto(MenuRoutes.SignIn)
                }
            }
        }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { Contact(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.SignIn) { entry ->
            val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
            loginVM.failMessage = ""
            LoginScreen(loginVM, settingsVM, navController)
        }
        composable(MenuRoutes.FAQ) { FAQ(navController) }
        composable(MenuRoutes.Register) { RegistrationScreen(navController)}

        navigation(
            startDestination = MenuRoutes.HomeDash,
            route = "dashboard home"
        ) {
            composable(MenuRoutes.HomeDash) { HomeDash(navController, loginVM) }
            composable(MenuRoutes.Profile) { Profile(navController, loginVM) }
            composable(MenuRoutes.Settings) { Settings(navController, loginVM) }
            composable(MenuRoutes.Orders) { Orders(navController, loginVM) }
            // composable(MenuRoutes.SelectAddress) { SelectAddress(navController) }
            // composable(MenuRoutes.PickupDetails) { PickupDetails(navController) }
            //  composable(MenuRoutes.Label) { Label(navController) }
        }
        composable(MenuRoutes.ConfirmNumber) {
            // this vm should be destroyed when confirmation is complete
            val confirmVm = remember { ConfirmEmailViewModel() }
            ConfirmEmailScreen(navController, confirmVm, loginVM)
        }
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
                    onClickBack = { navController.goto(MenuRoutes.Home) },
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
                    isGuest = loginVM.isGuest,
                    onChangePlan = pickupVM::onChangePlan,
                    onClickNext = { navController.navigate("add_labels") },
                    onClickBack = { navController.navigate("select_method") },
                    onClickSignUp = { navController.goto(MenuRoutes.Register) }
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