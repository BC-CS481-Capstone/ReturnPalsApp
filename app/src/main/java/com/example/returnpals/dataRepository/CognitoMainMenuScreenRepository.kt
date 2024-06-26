package com.example.returnpals.dataRepository


import com.amplifyframework.core.Amplify

class CognitoMainMenuScreenRepository :MainMenuScreenRepository{
    //This is the cognito implementation of MainMenuRepository

    override fun isSignedIn(result:(Boolean)->Unit) {
        //This fucntion calls for the current user. If not logged in will result in error message.
        Amplify.Auth.getCurrentUser({
            result(true)
        }){
            result(false)
        }
    }
}