package com.example.returnpals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.dataRepository.MainMenuScreenRepository
import com.example.returnpals.navigation.MenuRoutes

class MainMenuScreenViewModel(
    private val mainMenuScreenRepository: MainMenuScreenRepository,
): ViewModel() {
    /** Following the tutorial information from https://developer.android.com/topic/libraries/architecture/viewmodel
     * This is a view model for the MainMenuScreen.
     * This holds the state if the user is signed in or not.
     * */

    // contentSet is the state of UI on what menu option the user has selected from the scaffolding
    private val _contentSet = MutableLiveData<String?>("home")
    val contentSet: LiveData<String?> = _contentSet

    //Condition variable for navigation.  Null until it is set to the correct navigation route
    private val _readyToNav = MutableLiveData<String?>(null)
    val readyToNav: LiveData<String?> = _readyToNav

    //Set setContent allows user to select the scaffolding options.
    fun setContent(it:String) {
        if (it == "sign in") {
            onMainMenuSignInOrSchedule()
        } else {
            _contentSet.postValue(it)
        }
    }

    // on the main menu ther schedule return button or selecting the sign in option from the scaffolding should call this function.
    fun onMainMenuSignInOrSchedule() {
        //Selects the correct navigation route
        mainMenuScreenRepository.isSignedIn { isSignedIn ->
            if (isSignedIn) {
                _readyToNav.postValue(MenuRoutes.HomeDash)
            } else {
                _readyToNav.postValue(MenuRoutes.SignIn)
            }
        }
    }
}