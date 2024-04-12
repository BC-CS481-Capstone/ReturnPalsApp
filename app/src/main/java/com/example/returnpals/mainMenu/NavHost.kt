package com.example.returnpals.mainMenu

import android.location.Address
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.returnpals.composetools.pickup.ConfirmPickup
import com.example.returnpals.composetools.pickup.AddPackagesScreen
import com.example.returnpals.composetools.pickup.PickupDateScreen
import com.example.returnpals.composetools.pickup.PickupMethodScreen
import com.example.returnpals.composetools.pickup.PricingScreen
import com.example.returnpals.composetools.pickup.ThankYou
import com.example.returnpals.composetools.ConfirmNumber
import com.example.returnpals.composetools.dashboard.HomeDash
import com.example.returnpals.composetools.dashboard.Orders
import com.example.returnpals.composetools.dashboard.Profile
import com.example.returnpals.composetools.dashboard.Settings
import com.example.returnpals.composetools.pickup.SelectAddressScreen
import com.example.returnpals.services.AddressesViewModel
import com.example.returnpals.services.ScheduleReturnViewModel
import java.util.Locale

@Composable
fun AppNavigation(navController: NavController) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = MenuRoutes.Home
    ) {

        composable(MenuRoutes.Home) {
            Home(navController)
        }
        composable(MenuRoutes.About) { About(navController) }
        composable(MenuRoutes.Pricing) { Pricing(navController) }
        composable(MenuRoutes.Contact) { Contact(navController) }
        composable(MenuRoutes.Video) { Video(navController) }
        composable(MenuRoutes.SignIn) { SignIn(navController) }
        composable(MenuRoutes.FAQ) { FAQ(navController) }
        composable(MenuRoutes.Register) { Register(navController)}

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
        composable(MenuRoutes.ConfirmNumber) { ConfirmNumber(navController) }

        navigation(
            startDestination = "select_date",
            route = MenuRoutes.PickupProcess
        ) {
            composable("select_date") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                PickupDateScreen(
                    date = pickupVM.date.value,
                    onChangeDate = pickupVM::onChangeDate,
                    isValidDate = pickupVM::isValidDate,
                    onClickNext = { navController.navigate("select_address") },
                    onClickBack = { navController.navigate(MenuRoutes.HomeDash) },
                )
            }
            composable("select_address") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                val addressesVM = entry.sharedViewModel<AddressesViewModel>(navController)
                // TODO: retrieve addresses from user account
                // TODO: send added addresses to user account
                SelectAddressScreen(
                    selectedAddressId = addressesVM.selectedId.value,
                    addresses = addressesVM.addresses,
                    onSelectAddress = { id ->
                        addressesVM.onSelectAddress(id)
                        addressesVM.selectedAddress?.let { pickupVM.onChangeAddress(it) }
                    },
                    onAddAddress = addressesVM::onAddAddress,
                    onClickNext = { navController.navigate("select_method") },
                    onClickBack = { navController.navigate(("select_date")) }
                )
            }
            composable("select_method") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                PickupMethodScreen(
                    method = pickupVM.method.value,
                    onChangeMethod = pickupVM::onChangeMethod,
                    onClickNext = { navController.navigate("select_pricing") },
                    onClickBack = { navController.navigate("select_address") },
                )
            }
            composable("select_pricing") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                PricingScreen(
                    plan = pickupVM.plan.value,
                    onChangePlan = pickupVM::onChangePlan,
                    onClickNext = { navController.navigate("add_labels") },
                    onClickBack = { navController.navigate("select_method") },
                )
            }
            composable("add_labels") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                AddPackagesScreen(
                    packages = pickupVM.packages.toMap(),
                    onAddLabel = pickupVM::onAddLabel,
                    onRemoveLabel = pickupVM::onRemoveLabel,
                    onClickNext = { navController.navigate("confirm") },
                    onClickBack = { navController.navigate("select_pricing") },
                )
            }
            composable("confirm") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                ConfirmPickup().drawConfirmPickup(
                    typeOfPickup = pickupVM.method.value.toString(),
//                    TODO: change type of pickupDate parameter to LocalDate
//                       OR change type of PackageInfo.date to Calendar
//                    TODO: show pricing only if BRONZE plan is selected
                    pickUpAddress = Address(Locale.CANADA),
                    nextButton = {
                        pickupVM.onSubmit()
                        navController.navigate("thanks") },
                    backButton = { navController.navigate("add_labels") },
                    promoButton = {}
                )
            }
            composable("thanks") { entry ->
                val pickupVM = entry.sharedViewModel<ScheduleReturnViewModel>(navController)
                ThankYou().drawThankYouUI(
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