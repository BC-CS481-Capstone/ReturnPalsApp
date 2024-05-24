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
import com.example.returnpals.PickupInfo
import com.example.returnpals.composetools.ConfirmEmailScreen
import com.example.returnpals.composetools.LoginScreen
import com.example.returnpals.composetools.dashboard.HomeDash
import com.example.returnpals.composetools.dashboard.Orders
import com.example.returnpals.composetools.dashboard.Profile
import com.example.returnpals.composetools.dashboard.Settings
import com.example.returnpals.composetools.login.ConfirmEmailScreen
import com.example.returnpals.composetools.login.LoginScreen
import com.example.returnpals.composetools.mainMenu.About
import com.example.returnpals.composetools.mainMenu.Contact
import com.example.returnpals.composetools.mainMenu.FAQ
import com.example.returnpals.composetools.mainMenu.Home
import com.example.returnpals.composetools.mainMenu.Pricing
import com.example.returnpals.composetools.mainMenu.Video
import com.example.returnpals.composetools.pickup.AddPackagesScreen
import com.example.returnpals.composetools.pickup.PickupDateScreen
import com.example.returnpals.composetools.pickup.PickupMethodScreen
import com.example.returnpals.composetools.pickup.PricingScreen
import com.example.returnpals.composetools.pickup.SelectAddressScreen
import com.example.returnpals.composetools.pickup.ThankYouScreen
import com.example.returnpals.composetools.pickup.ThankYouViewModel
import com.example.returnpals.services.ConfirmEmailViewModel
import com.example.returnpals.services.LoginViewModel
import com.example.returnpals.viewmodel.OrderViewModel
import com.example.returnpals.composetools.pickup.PaymentApp
import com.stripe.android.paymentsheet.PaymentSheetResult

@Composable
fun AppNavigation(navController: NavController) {
    val loginVM = remember { LoginViewModel("test@bellevue.college", "Password123$") }

    NavHost(
        navController = navController as NavHostController,
        startDestination = "MainMenu"
    ) {
        /**START of the Main Menu Navigation*/
        composable("MainMenu"){ MainMenu(navController)}
        composable(MenuRoutes.Home) { Home(navController) }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { Contact(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.FAQ) { FAQ(navController) }
        composable(MenuRoutes.Register) { RegistrationScreen(navController)}

        navigation(
            startDestination = MenuRoutes.HomeDash,
            route = "dashboard home"
        ) {
            /**START of the Dashboard Home Navigation*/
            composable(MenuRoutes.HomeDash) { HomeDash(navController, loginVM) }
            composable(MenuRoutes.Profile) { Profile(navController, loginVM) }
            composable(MenuRoutes.Settings) { Settings(navController, loginVM) }
            composable(MenuRoutes.Orders) { Orders(navController, loginVM) }
            // composable(MenuRoutes.SelectAddress) { SelectAddress(navController) }
            // composable(MenuRoutes.PickupDetails) { PickupDetails(navController) }
            //  composable(MenuRoutes.Label) { Label(navController) }
            /**END of the Dashboard Home Navigation*/
        }
        navigation(
            startDestination = MenuRoutes.SignIn,
            route = "Login"
        ) {
            /**START of the Login Navigation*/
            composable(MenuRoutes.SignIn) { entry ->
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                LoginScreen(loginVM, settingsVM, navController)
            }
            composable(MenuRoutes.Register) {
                com.example.returnpals.composetools.login.Register(
                    navController
                )
            }
            composable(MenuRoutes.ConfirmNumber) {
                // this vm should be destroyed when confirmation is complete
                val confirmVm = remember { ConfirmEmailViewModel(loginVM.email) }
                ConfirmEmailScreen(navController, confirmVm)
            }
            /**END of the Login Navigation*/
        }

        navigation(
            startDestination = "select_date",
            route = MenuRoutes.PickupProcess
        ) {
            /**START of the Pickup Process Navigation*/
            composable("select_date") { entry ->
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                PickupDateScreen(
                    date = pickupVM.date.value,
                    onChangeDate = pickupVM::onChangeDate,
                    isValidDate = pickupVM::isValidDate,
                    onClickNext = { navController.navigate("select_address") },
                    onClickBack = { navController.goto("MainMenu") },
                )
            }
            composable("select_address") { entry ->
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
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                pickupVM.updatePickupAddress(selectedAddress)
                PickupMethodScreen(
                    method = pickupVM.method.value,
                    onChangeMethod = pickupVM::onChangeMethod,
                    onClickNext = { navController.navigate("select_pricing") },
                    onClickBack = { navController.navigate("select_address") },
                )
            }
            composable("select_pricing") { entry ->
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                pickupVM.updatePickupAddress(selectedAddress)
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
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                pickupVM.updatePickupAddress(selectedAddress)
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
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                pickupVM.updatePickupAddress(selectedAddress)

                val thankyouVM = ThankYouViewModel()
                val hasUserName by thankyouVM.hasUserNames.observeAsState()
                val createReturnSuccessful by pickupVM.createReturnSuccessful.observeAsState()
                val createLabelsSuccessful by pickupVM.createLabelsSuccessful.observeAsState()
                var readyToNav = false
                if (hasUserName != true) {
                    thankyouVM.init()
                }
                if (hasUserName == true) {
                    pickupVM.onSubmit(thankyouVM.userEmail.value)
                }
                if (createReturnSuccessful == true) {
                    pickupVM.submitLabels()
                }
                if (/*createLabelsSuccessful ==*/ true) {
                    PaymentApp(
                        info = pickupVM.info,
                        onPaymentSheetResult = { paymentSheetResult: PaymentSheetResult ->
                            when (paymentSheetResult) {
                                is PaymentSheetResult.Canceled -> {
                                    Log.e("PaymentApp", "Canceled")
                                    print("Canceled")
                                }

                                is PaymentSheetResult.Failed -> {
                                    Log.e("PaymentApp", "Error")
                                    print("Error: ${paymentSheetResult.error}")
                                }

                                is PaymentSheetResult.Completed -> {
                                    Log.e("PaymentApp", "Completed")
                                    navController.navigate("thanks")
                                }
                            }
                        },
                        onClickBack = { navController.navigate("add_labels") },
                        //onClickPromoButton = {}
                    )
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