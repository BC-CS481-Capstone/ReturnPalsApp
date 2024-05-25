package com.example.returnpals.services

import com.example.returnpals.services.backend.LoginRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

//Test the backend logic for the login functionality
class LoginViewModelTest {

    private val vm = LoginViewModel()
    val email = "test@bellevue.college"
    val password = "Password123$"

    @Test
    fun password() {
        vm.password = "p4ssw0rd"
        assertEquals(vm.password, "p4ssw0rd")
    }

    @Test
    fun email() {
        vm.email = "joe.biden@mail.com"
        assertEquals(vm.email, "joe.biden@mail.com")
    }

    @Test
    fun logInAsGuest() = runTest {
        vm.email = email
        LoginRepository.update()
        if (vm.isLoggedIn != false) async { vm.logOut(this.coroutineContext) }.await()
        async { vm.logInAsGuest(this.coroutineContext) }.await()
        assert(LoginRepository.email == email) { "LoginRepository.email: expected $email, was ${LoginRepository.email}" }
        assert(vm.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(vm.isGuest) { "isGuest: expected true, was false" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logIn() = runTest {
        vm.email = email
        vm.password = password
        LoginRepository.update()
        if (vm.isLoggedIn != false) async { vm.logOut(this.coroutineContext) }.await()
        async { vm.logIn(this.coroutineContext) }.await()
        assert(LoginRepository.email == email) { "LoginRepository.email: expected $email, was ${LoginRepository.email}" }
        assert(vm.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(!vm.isGuest) { "isGuest: expected false, was true" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logOut() = runTest {
        vm.email = "test@bellevue.college"
        vm.password = "Password123$"
        LoginRepository.update()
        if (vm.isLoggedIn != true) async { vm.logIn(this.coroutineContext) }.await()
        async { vm.logOut(this.coroutineContext) }.await()
        assert(LoginRepository.email == null) { "LoginRepository.email: expected null, was ${LoginRepository.email}" }
        assert(vm.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!vm.isGuest) { "isGuest: expected false, was true" }
        assert(vm.isGuest == LoginRepository.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn == LoginRepository.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
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