package com.example.returnpals.viewmodel

import androidx.compose.runtime.mutableStateOf
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
    private val _isSignedIn = mutableStateOf<Boolean?>(null)

    private val _contentSet = MutableLiveData<String?>("home")
    val contentSet: LiveData<String?> = _contentSet

    private val _readyToNav = MutableLiveData<String?>(null)
    val readyToNav: LiveData<String?> = _readyToNav
    fun setContent(it:String) {
        if (it == "sign in") {
            onMainMenuSignInOrSchedule()
        } else {
            _contentSet.postValue(it)
        }
    }
    fun onMainMenuSignInOrSchedule() {
        mainMenuScreenRepository.isSignedIn { isSignedIn ->
            if (isSignedIn) {
                _readyToNav.postValue(MenuRoutes.HomeDash)
            } else {
                _readyToNav.postValue(MenuRoutes.SignIn)
            }
        }
    }
}