package com.example.returnpals.composetools.mainMenu

import MainMenuScaffold
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.dataRepository.MainMenuScreenRepository
import com.example.returnpals.navigation.MenuRoutes


/**
 * This file is a top level
 *
 *
 * */



//This file create the navigation for the main menu.
//Then navigate to either the dashboard or sign in.

@Composable
fun MainMenuScreen(mainMenuScreenViewModel: MainMenuScreenViewModel) {
    val selectedItem by mainMenuScreenViewModel.navRoute.observeAsState()
    MainMenuScaffold(navigateRoute = mainMenuScreenViewModel::selectedNavRoute) {
        when(selectedItem){
            "sign in"->mainMenuScreenViewModel.onSignInOrScheduleButton()
            "home"->HomeContent(){mainMenuScreenViewModel.selectedNavRoute("sign in") }
            "about"->AboutContent()
            "pricing"-> PricingContent()
            "contact"-> ContactContent()
            "faq"-> FAQContent()
        }
    }
}


class MainMenuScreenViewModel(
    private val mainMenuScreenRepository: MainMenuScreenRepository,
    private val navController: NavController
): ViewModel() {
    /** Following the tutorial information from https://developer.android.com/topic/libraries/architecture/viewmodel
     * This is a view model for the MainMenuScreen.
     * This holds the state if the user is signed in or not.
     * */
    private val _isSignedIn = mutableStateOf<Boolean?>(null)

    private val _navRoute = MutableLiveData<String?>("home")
    val navRoute: LiveData<String?> = _navRoute

    fun checkSignedIn(){
        mainMenuScreenRepository.isSignedIn { isSignedIn ->
            _isSignedIn.value = isSignedIn
        }
    }
    fun selectedNavRoute(it:String) {
        _navRoute.postValue(it)
    }
    @Composable
    fun onSignInOrScheduleButton() {
        checkSignedIn()
        if (_isSignedIn.value == true) {
            navigateAwayFromMainMenu(MenuRoutes.HomeDash)
        } else if (_isSignedIn.value==false) {
            navigateAwayFromMainMenu(MenuRoutes.SignIn)
        } else {
            Log.e("MainMenuScreenViewModel","Unknown if user is signed in or not already. Suspect API call has not returned.")
            return
        }


    }

    private fun navigateAwayFromMainMenu(route:String) {

        navController.navigate(route) { // Clear all the back stack up to the start destination and save state
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when reselecting the same item
            launchSingleTop = true
            // Restore state when navigating back to the composable
            restoreState = true
        }
    }

}


