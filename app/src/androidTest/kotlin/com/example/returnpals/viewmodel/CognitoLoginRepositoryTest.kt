package com.example.returnpals.services

import com.example.returnpals.dataRepository.CognitoLoginRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

class CognitoLoginRepositoryTest {

    val email = "test@bellevue.college"
    val password = "Password123$"

    @Test
    fun logInAsGuest() = runTest {
        if (CognitoLoginRepository.isLoggedIn == true)
            CognitoLoginRepository.logOut()
        CognitoLoginRepository.logInAsGuest(email)
        assert(CognitoLoginRepository.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(CognitoLoginRepository.isGuest) { "isGuest: expected true, was false" }
        assert(CognitoLoginRepository.email == email) { "email: expected $email, was ${CognitoLoginRepository.email}" }
    }

    @Test
    fun logIn() = runTest {
        if (CognitoLoginRepository.isLoggedIn == true)
            CognitoLoginRepository.logOut()
        CognitoLoginRepository.logIn(email, password)
        assert(CognitoLoginRepository.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(!CognitoLoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(CognitoLoginRepository.email == email) { "email: expected $email, was ${CognitoLoginRepository.email}" }
    }

    @Test
    fun logOut() = runTest {
        if (CognitoLoginRepository.isLoggedIn == false)
            CognitoLoginRepository.logIn(email, password)
        CognitoLoginRepository.logOut()
        assert(CognitoLoginRepository.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!CognitoLoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(CognitoLoginRepository.email == null) { "email: expected null, was ${CognitoLoginRepository.email}" }
    }

}