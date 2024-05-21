package com.example.returnpals.services

import com.example.returnpals.services.backend.LoginRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

//Test the backend logic for the login functionality
class LoginViewModelTest {

    private val vm = LoginViewModel()

    @Test
    fun logInAsGuest() = runTest {
        val email = "test@bellevue.college"
        val password = ""
        async { vm.logInAsGuest(email, this.coroutineContext) }.await()
        assert(vm.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(vm.isGuest) { "isGuest: expected true, was false" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logIn() = runTest {
        val email = "test@bellevue.college"
        val password = "Password123$"
        async { vm.logIn(email, password, this.coroutineContext) }.await()
        assert(vm.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(!vm.isGuest) { "isGuest: expected false, was true" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logOut() = runTest {
        val email = "test@bellevue.college"
        val password = "Password123$"
        async { vm.logIn(email, password, this.coroutineContext) }.await()
        async { vm.logOut(this.coroutineContext) }.await()
        assert(vm.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!vm.isGuest) { "isGuest: expected false, was true" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn()) { "isLoggedIn: doesn't match with repository" }
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