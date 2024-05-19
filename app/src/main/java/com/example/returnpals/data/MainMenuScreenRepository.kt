package com.example.returnpals.data


//This file exposes the call to see if the user is logged in for navigating away from main menu
interface MainMenuScreenRepository {
    //Interface needs Express and AWS implementation

    /**Uses a callback function to expose boolen for isLoggedIn*/
    suspend fun isSignedIn(result:(Boolean)->Unit)
}