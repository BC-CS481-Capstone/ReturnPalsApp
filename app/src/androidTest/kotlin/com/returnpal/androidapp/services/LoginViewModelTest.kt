package com.returnpal.androidapp.services

import org.junit.Test


//Test the backend logic for the login functionality
class LoginViewModelTest {

    private val loginVM = LoginViewModel()

    //First Test if view model hold data
    @Test
    fun email() {
        //Test if view model holds email data
        loginVM.email = "test@bellevue.college"
        assert(loginVM.email == "test@bellevue.college" )
    }

    @Test
    fun password() {
        //Test if view model holds password data
        loginVM.password = "Password123$"
        assert(loginVM.password == "Password123$")
    }

    @Test
    fun logInAsGuest() {
        //Test if view model holds boolean data for guest switching
        // TODO: implement LoginViewModel::logOut
//        loginVM.logOut()
//        assert(!loginVM.isGuest)
//        loginVM.email = "test@bellevue.college"
//        loginVM.logInAsGuest()
//        assert(loginVM.isGuest)
    }

    /** Removed test with amplify to get CI working for every one.
    @Test
    fun logIn() {
        //Test logIn if working with backend server
        launchActivity<MainActivity>().use { scenario ->
            scenario.moveToState(Lifecycle.State.CREATED)
            val test = LoginViewModel()
            test.logIn()
            Amplify.Auth.getCurrentUser({assert(true)}){assert(false)}
            scenario.moveToState(Lifecycle.State.DESTROYED)
        }
    }

    @Test
    fun singUp() {
        //Test signup if working with backend server
        launchActivity<MainActivity>().use { scenario ->
            scenario.moveToState(Lifecycle.State.CREATED)
            val test = LoginViewModel()
            test.changeEmail("test2@bellevue2.college2")
            test.singUp()
            Amplify.Auth.signUp("test2@bellevue2.college2","Password123$",
                AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), "test2@bellevue2.college2")
                .build(),{assert(false)}){assert(true)}
            scenario.moveToState(Lifecycle.State.DESTROYED)
        }
    }

    @Test
    fun signOut() {
        //Test signOut if working with backend server
        launchActivity<MainActivity>().use { scenario ->
            scenario.moveToState(Lifecycle.State.CREATED)
            val test = LoginViewModel()
            test.logIn()
            test.signOut()
            Amplify.Auth.getCurrentUser({assert(false)}){assert(true)}
            scenario.moveToState(Lifecycle.State.DESTROYED)
        }
    }
    **/
}