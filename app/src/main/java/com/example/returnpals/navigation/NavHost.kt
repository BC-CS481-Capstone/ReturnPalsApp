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
import com.example.returnpals.composetools.dashboard.HomeDash
import com.example.returnpals.composetools.dashboard.History
import com.example.returnpals.composetools.dashboard.Profile
import com.example.returnpals.composetools.dashboard.Settings
import com.example.returnpals.composetools.login.ConfirmEmailScreen
import com.example.returnpals.composetools.login.LoginScreen
import com.example.returnpals.composetools.mainMenu.About
import com.example.returnpals.composetools.mainMenu.ContactScreen
import com.example.returnpals.composetools.mainMenu.FAQ
import com.example.returnpals.composetools.mainMenu.Home
import com.example.returnpals.composetools.mainMenu.MainMenuScreen
import com.example.returnpals.composetools.mainMenu.Pricing
import com.example.returnpals.composetools.mainMenu.Video
import com.example.returnpals.composetools.pickup.AddPackagesScreen
import com.example.returnpals.composetools.pickup.PaymentApp
import com.example.returnpals.composetools.pickup.PickupDateScreen
import com.example.returnpals.composetools.pickup.PickupMethodScreen
import com.example.returnpals.composetools.pickup.PricingScreen
import com.example.returnpals.composetools.pickup.SelectAddressScreen
import com.example.returnpals.composetools.pickup.ThankYouScreen
import com.example.returnpals.composetools.pickup.ThankYouViewModel
import com.example.returnpals.dataRepository.CognitoMainMenuScreenRepository
import com.example.returnpals.dataRepository.RegisterRepositoryAmplify
import com.example.returnpals.navigation.MenuRoutes
import com.example.returnpals.navigation.Register
import com.example.returnpals.navigation.goto
import com.example.returnpals.services.ConfirmEmailViewModel
import com.example.returnpals.services.LoginViewModel
import com.example.returnpals.viewmodel.MainMenuScreenViewModel
import com.example.returnpals.viewmodel.ReturnViewModel
import com.example.returnpals.viewmodel.RegisterViewModel
import com.stripe.android.paymentsheet.PaymentSheetResult

@Composable
fun AppNavigation(navController: NavController) {
    val loginVM = remember { LoginViewModel("", "") }
    val registerVM = RegisterViewModel(RegisterRepositoryAmplify())
    //val ordersVM = remember {}
    //val settingsVM = remember {}
    //val profileVM = remember {}
    //val homeDashVM = remember {}
    //TODO make view models^^^^
    NavHost(
        navController = navController as NavHostController,
        startDestination = "MainMenu"
    ) {
        //Start at main menu.
        composable("MainMenu"){
            val mainMenuVM = remember {MainMenuScreenViewModel(CognitoMainMenuScreenRepository())}
            val navigate by mainMenuVM.readyToNav.observeAsState()
            /**$navigate is a nullable string.
             * @Null do not navigate
             * @String navigate to the specific destination*/
            if (navigate != null) navController.goto(navigate!!)
            //Call Content
            MainMenuScreen(mainMenuVM)
        }

        navigation(
            startDestination = MenuRoutes.HomeDash,
            route = "dashboard home"
        ) {
            /**START of the Dashboard Home Navigation*/
            composable(MenuRoutes.HomeDash) {
                //TODO get navigate logic from view model>val navigate by homeDashVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                HomeDash(navController, loginVM)
            }
            composable(MenuRoutes.Profile) {
                //TODO get navigate logic from view model>val navigate by profileVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                Profile(navController, loginVM)
            }
            composable(MenuRoutes.Settings) {
                //TODO get navigate logic from view model>val navigate by settingsVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                Settings(navController, loginVM)
            }
            composable(MenuRoutes.History) {
                //TODO get navigate logic from view model>val navigate by ordersVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                History(navController, loginVM)
            }
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
                //TODO get navigate logic from view model>val navigate by settingsVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                LoginScreen(loginVM, settingsVM, navController)
            }
            composable(MenuRoutes.Register) {
                val navigate by registerVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                if (navigate != null) navController.goto(navigate!!)
                //Call Content
                Register(registerVM)
            }
            composable(MenuRoutes.ConfirmNumber) {
                // this vm should be destroyed when confirmation is complete
                val confirmVm = remember { ConfirmEmailViewModel(registerVM.uiState.value.email) }
                //TODO get navigate logic from view model>val navigate by confirmVm.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                ConfirmEmailScreen(navController, confirmVm)
            }
            /**END of the Login Navigation*/
        }

        navigation(
            startDestination = "select_date",
            route = MenuRoutes.PickupProcess
        ) {
            val pickupVM =  ReturnViewModel()
            /**START of the Pickup Process Navigation*/
            composable("select_date") { entry ->
                //val pickupVM = entry.sharedViewModel<ReturnViewModel>(navController)
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
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
                //TODO get navigate logic from view model>val navigate by settingsVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                SelectAddressScreen( //TODO change signature to accept 1 view model for the screen
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
                //val pickupVM = entry.sharedViewModel<OrderViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                //pickupVM.updatePickupAddress(selectedAddress,pickupVM.packageList!!)
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                PickupMethodScreen( //TODO change signature to accept 1 view model for the screen
                    method = pickupVM.method.value,
                    onChangeMethod = pickupVM::onChangeMethod,
                    onClickNext = { navController.navigate("select_pricing") },
                    onClickBack = { navController.navigate("select_address") },
                )
                Log.i("Println", "Method post:" + pickupVM.method.value.toString())

            }
            composable("select_pricing") { entry ->
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                //val pickupVM = entry.sharedViewModel<ReturnViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                //pickupVM.updatePickupAddress(selectedAddress,pickupVM.packageList!!)
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                PricingScreen( //TODO change signature to accept 1 view model
                    plan = pickupVM.plan.value,
                    isGuest = loginVM.isGuest.value == true,
                    onChangePlan = pickupVM::onChangePlan,
                    onClickNext = { navController.navigate("add_labels") },
                    onClickBack = { navController.navigate("select_method") },
                    onClickSignUp = { navController.goto(MenuRoutes.Register) }
                )
            }
            composable("add_labels") { entry ->
                val settingsVM = entry.sharedViewModel<SettingsViewModel>(navController)
                //val pickupVM = entry.sharedViewModel<ReturnViewModel>(navController)
                val selectedAddress = settingsVM.getSelectedAddress()
                //pickupVM.updatePickupAddress(selectedAddress,pickupVM.packageList!!)
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                AddPackagesScreen( //TODO change signature to accept 1 view model
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
                //val pickupVM = ReturnViewModel()
                val selectedAddress = settingsVM.getSelectedAddress()
                val selectedMethod = pickupVM.method.value!!
                val selectedDate = pickupVM.date.value
                Log.i("Println", "No do :(" + pickupVM.method.value.toString())
                pickupVM.updatePickupAddress(selectedAddress, selectedMethod, selectedDate, pickupVM.packageList!!)
                Log.i("Println", "Is do?" + pickupVM.method.value.toString())
                val thankyouVM = ThankYouViewModel()
                val hasUserName by thankyouVM.hasUserNames.observeAsState()
                val createReturnSuccessful by pickupVM.createReturnSuccessful.observeAsState()
                val createLabelsSuccessful by pickupVM.createLabelsSuccessful.observeAsState()
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                //Call Content
                if (hasUserName != true) {
                    thankyouVM.init()
                }
                if ( createLabelsSuccessful== true) {
                    navController.navigate("thanks")
                }
                if (createReturnSuccessful == true) {
                    pickupVM.submitLabels()
                }
                if (hasUserName == true) {
                    PaymentApp( //TODO change signature to accept 1 view model
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
                                    pickupVM.onSubmit(thankyouVM.userEmail.value)
                                }
                            }
                        },
                        onClickBack = { navController.navigate("add_labels") },
                        //onClickPromoButton = {}
                    )
                }
            }
            composable("thanks") { entry ->
                val pickupVM = entry.sharedViewModel<ReturnViewModel>(navController)
                //TODO get navigate logic from view model>val navigate by pickupVM.readyToNav.observeAsState()
                /**$navigate is a nullable string.
                 * @Null do not navigate
                 * @String navigate to the specific destination*/
                //TODO use navigate logic>if (navigate != null) navController.goto(navigate!!)
                ThankYouScreen( //TODO change signature to accept 1 view model
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
        //TODO NOT USED other than test class remove from test files and here
        composable(MenuRoutes.Home) { Home(navController) }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { ContactScreen(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.FAQ) { FAQ(navController) }
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