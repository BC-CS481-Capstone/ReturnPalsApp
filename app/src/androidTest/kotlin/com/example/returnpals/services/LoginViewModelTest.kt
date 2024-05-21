package com.example.returnpals.services

import com.example.returnpals.services.backend.LoginRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

//Test the backend logic for the login functionality
class LoginViewModelTest {

    val vm = LoginViewModel("test@bellevue.college","Password123$")

    @Test
    fun email() {
        vm.email = "joe.biden@bellevuecollege.edu"
        assert(vm.email == "joe.biden@bellevuecollege.edu") { "incorrect email stored: ${vm.email}"}
    }

    @Test
    fun password() {
        vm.password = "password123"
        assert(vm.password == "password123") { "incorrect password stored: ${vm.password}"}
    }

    @Test
    fun logInAsGuest() = runTest {
        vm.email = "test@bellevue.college"
        vm.password = ""
        async { vm.logInAsGuest(this.coroutineContext) }.await()
        assert(vm.isLoggedIn == true) { "user is not logged in... " + vm.failMessage }
        assert(vm.isGuest) { "user not marked as guest" }
        assert(vm.isGuest == LoginRepository.isGuest) { "data doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "data doesn't match with repository" }
    }

    @Test
    fun logIn() = runTest {
        vm.email = "test@bellevue.college"
        vm.password = "Password123$"
        async { vm.logIn(this.coroutineContext) }.await()
        assert(vm.isLoggedIn == true) { "user is not logged in... " + vm.failMessage }
        assert(!vm.isGuest) { "user marked as guest" }
        assert(vm.isGuest == LoginRepository.isGuest) { "data doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "data doesn't match with repository" }
    }

    @Test
    fun logOut() = runTest {
        vm.email = "test@bellevue.college"
        vm.password = "Password123$"
        async { vm.logIn(this.coroutineContext) }.await()
        async { vm.logOut(this.coroutineContext) }.await()
        assert(vm.isLoggedIn == false) { "user still logged in" }
        assert(!vm.isGuest) { "user still marked as guest" }
        assert(vm.isGuest == LoginRepository.isGuest) { "data doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "data doesn't match with repository" }
    }

//    results in "Username already exists in the system" error
//    @Test
//    fun register() = runTest {
//        vm.email = "test@bellevue.college"
//        vm.password = "Password123$"
//        async { vm.register(this) }.await()
//        assert(vm.signUpSuccessful) { "sign up unsuccessful... " + vm.failMessage }
//        assert(!vm.isLoggedIn) { "user not supposed to be logged in before confirmation" }
//        assert(!vm.isGuest) { "user not supposed to be marked as guest" }
//        assert(vm.isGuest == LoginRepository.isGuest) { "data doesn't match with repository" }
//        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "data doesn't match with repository" }
//    }
}