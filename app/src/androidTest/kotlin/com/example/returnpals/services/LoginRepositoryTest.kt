package com.example.returnpals.services

import com.example.returnpals.services.backend.LoginRepository
import com.example.returnpals.services.backend.RepoResult
import kotlinx.coroutines.test.runTest
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

// https://developer.android.com/kotlin/coroutines/test

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class LoginRepositoryTest {

    val email = "test@bellevue.college"
    val password = "Password123$"
    
    @Test
    fun test0_init() = runTest {
        LoginRepository.update()
        if (LoginRepository.isLoggedIn == true)
            LoginRepository.logOut()
    }

    @Test
    fun test1_update() = runTest {
        val result = LoginRepository.update()
        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
    }

    @Test
    fun test2_logIn() = runTest {
        val result = LoginRepository.logIn(email, password)
        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
        assert(LoginRepository.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepository.email == email) { "email: expected $email, was ${LoginRepository.email}" }
    }

    @Test
    fun test3_logOut() = runTest {
        val result = LoginRepository.logOut()
        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
        assert(LoginRepository.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepository.email == null) { "email: expected null, was ${LoginRepository.email}" }
    }

    @Test
    fun test4_logInAsGuest() = runTest {
        val result = LoginRepository.logInAsGuest(email)
        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
        assert(LoginRepository.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
        assert(LoginRepository.isGuest) { "isGuest: expected true, was false" }
        assert(LoginRepository.email == email) { "email: expected $email, was ${LoginRepository.email}" }
    }

    @Test
    fun test5_logOut_guest() = runTest {
        val result = LoginRepository.logOut()
        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
        assert(LoginRepository.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
        assert(LoginRepository.email == null) { "email: expected null, was ${LoginRepository.email}" }
    }

//    @Test
//    fun test6_register() = runTest {
//        val email = "andrewthomaspogue@gmail.com"
//        val result = LoginRepository.register(email, password)
//        assert(result == RepoResult.INCOMPLETE) {"result: expected INCOMPLETE, was $result... ${result.message}"}
//        assert(LoginRepository.isLoggedIn == true) { "isLoggedIn: expected true, was false" }
//        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
//        assert(LoginRepository.email == email) { "email: expected $email, was ${LoginRepository.email}" }
//    }

//    @Test
//    fun test7_deleteCurrentUser() = runTest {
//        val email = "andrewthomaspogue@gmail.com"
//        assert(LoginRepository.email == email) { "current user: expected $email, was ${LoginRepository.email}" }
//        val result = LoginRepository.deleteCurrentUser()
//        assert(result == RepoResult.SUCCESS) {"result: expected SUCCESS, was $result... ${result.message}"}
//        assert(LoginRepository.isLoggedIn == false) { "isLoggedIn: expected false, was true" }
//        assert(!LoginRepository.isGuest) { "isGuest: expected false, was true" }
//        assert(LoginRepository.email == null) { "email: expected null, was ${LoginRepository.email}" }
//    }

}