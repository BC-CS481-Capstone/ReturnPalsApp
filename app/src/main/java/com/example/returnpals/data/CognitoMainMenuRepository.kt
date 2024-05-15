package com.example.returnpals.data


import com.amplifyframework.core.Amplify

class CognitoMainMenuRepository :MainMenuRepository{
    //This is the cognito implementation of MainMenuRepository

    override suspend fun isSignedIn(result:(Boolean)->Unit) {
        //This fucntion calls for the current user. If not logged in will result in error message.
        Amplify.Auth.getCurrentUser({
            result(true)
        }){
            result(false)
        }
    }
}