package com.example.returnpals.services

import com.example.returnpals.dataRepository.LoginRepositoryAmplify
import kotlinx.coroutines.test.runTest
import org.junit.Test

// https://developer.android.com/kotlin/coroutines/test

class LoginRepositoryAmplifyTest {

    val email = "test@bellevue.college"
    val password = "Password123$"
    val lambdaTest:(Boolean,String,String)->Unit =  {it,message,recoverSuggestion ->}

    @Test
    fun logInAsGuest() = runTest {
        if (LoginRepositoryAmplify.isLoggedIn == true)
            LoginRepositoryAmplify.logOut(){}
        LoginRepositoryAmplify.logInAsGuest(email,lambdaTest)
        assert(LoginRepositoryAmplify.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(LoginRepositoryAmplify.isGuest) { "isGuest: expected true, was false" }
        assert(LoginRepositoryAmplify.email == email) { "email: expected $email, was ${LoginRepositoryAmplify.email}" }
    }

    @Test
    fun logIn() = runTest {
        if (LoginRepositoryAmplify.isLoggedIn == true)
            LoginRepositoryAmplify.logOut(){}
        LoginRepositoryAmplify.logIn(email, password,lambdaTest)
        assert(LoginRepositoryAmplify.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(!LoginRepositoryAmplify.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepositoryAmplify.email == email) { "email: expected $email, was ${LoginRepositoryAmplify.email}" }
    }

    @Test
    fun logOut() = runTest {
        if (LoginRepositoryAmplify.isLoggedIn == false)
            LoginRepositoryAmplify.logIn(email, password,lambdaTest)
        LoginRepositoryAmplify.logOut(){}
        assert(LoginRepositoryAmplify.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!LoginRepositoryAmplify.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepositoryAmplify.email == null) { "email: expected null, was ${LoginRepositoryAmplify.email}" }
    }

}