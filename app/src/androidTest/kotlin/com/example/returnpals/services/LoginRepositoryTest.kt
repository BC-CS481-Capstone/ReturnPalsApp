package com.example.returnpals.services

import com.example.returnpals.services.backend.LoginRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

class LoginRepositoryTest {

    val email = "test@bellevue.college"
    val password = "Password123$"

    @Test
    fun logInAsGuest() = runTest {
        if (LoginRepository.isLoggedIn())
            LoginRepository.logOut()
        LoginRepository.logInAsGuest(email)
        assert(LoginRepository.isLoggedIn()) { "isLoggedIn: expected true, was false" }
        assert(LoginRepository.isGuest) { "isGuest: expected true, was false" }
        assert(LoginRepository.email == email) { "email: expected $email, was ${LoginRepository.email}" }
    }

    @Test
    fun logIn() = runTest {
        if (LoginRepository.isLoggedIn())
            LoginRepository.logOut()
        LoginRepository.logIn(email, password)
        assert(LoginRepository.isLoggedIn()) { "isLoggedIn: expected true, was false" }
        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepository.email == email) { "email: expected $email, was ${LoginRepository.email}" }
    }

    @Test
    fun logOut() = runTest {
        if (!LoginRepository.isLoggedIn())
            LoginRepository.logIn(email, password)
        LoginRepository.logOut()
        assert(!LoginRepository.isLoggedIn()) { "isLoggedIn: expected false, was true" }
        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepository.email == null) { "email: expected null, was ${LoginRepository.email}" }
    }

}