package com.returnpal.androidapp.services

import org.junit.Test


//Test the backend logic for the login functionality
class LoginViewModelTest {

    //First Test if view model hold data
    @Test
    fun getEmail() {
        //Test if view model holds email data
        val test = LoginViewModel()
        test.changeEmail("test@bellevue.college")
        assert(test.getEmail() == "test@bellevue.college" )
    }

    @Test
    fun getPassword() {
        //Test if view model holds password data
        val test = LoginViewModel()
        assert(test.password.value == "Password123$")
    }

    @Test
    fun isGuest() {
        //Test if view model holds boolean data for guest switching
        val test = LoginViewModel()
        assert(!test.isGuest.value)
    }

    @Test
    fun changeEmail() {
        //Test if viewmodel can update email data
        val test = LoginViewModel()
        test.changeEmail("test2@bellevue2.college2")
        assert(test.getEmail() == "test2@bellevue2.college2")
    }

    @Test
    fun changePass() {
        //Test if viewmodel can update password data
        val test = LoginViewModel()
        test.changePass("PASSTEST?")
        assert(test.password.value == "PASSTEST?")
    }

    @Test
    fun switchGuestUser() {
        //Test if viewmodel can update guest boolean data
        val test = LoginViewModel()
        test.switchGuestUser()
        assert(test.isGuest.value)
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