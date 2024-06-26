package com.example.returnpals.viewmodel


import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.returnpals.dataRepository.LoginRepositoryAmplify
import com.example.returnpals.mainMenu.AppNavigation
import com.example.returnpals.services.LoginViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test


// https://developer.android.com/kotlin/coroutines/test

//Test the backend logic for the login functionality
class LoginViewModelTest {
    private lateinit var navController: TestNavHostController
    private lateinit var vm: LoginViewModel
    @get:Rule

    val rule = createComposeRule()


    @Before
    fun setupAppNavHost() {
        rule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavigation(navController = navController)
            vm = LoginViewModel("joe.biden@mail.com","p4ssw0rd")
        }
    }


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
        vm.email = "test@bellevue.college"
        vm.password = ""
        async { withContext(Dispatchers.Main) {
            vm.logInAsGuest(this.coroutineContext)
        } }.await()
        assert(vm.isLoggedIn.value == true) { "isLoggedIn: expected true, was false" }
        assert(vm.isGuest.value == true) { "isGuest: expected true, was false" }
        assert(vm.isGuest.value == LoginRepositoryAmplify.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn.value == LoginRepositoryAmplify.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logIn() = runTest {
        vm.email = "daviddcmmoo@gmail.com"
        vm.password = "Password12345!"
        async { withContext(Dispatchers.Main) {
            vm.logOut(this.coroutineContext)
            //Would fail to login randomly. Set to make sure user log out first.
        } }.await()
        async { withContext(Dispatchers.Main) {
            vm.logIn(this.coroutineContext)
        } }.await()
        assert(vm.isLoggedIn.value == true) { "isLoggedIn: expected true, was false" }
        assert(vm.isGuest.value != true) { "isGuest: expected false, was true" }
        assert(vm.isGuest.value == LoginRepositoryAmplify.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn.value == LoginRepositoryAmplify.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
    }

    @Test
    fun logOut() = runTest {
        vm.email = "daviddcmmoo@gmail.com"
        vm.password = "Password12345!"
        async { withContext(Dispatchers.Main){
            vm.logIn(this.coroutineContext)
        }  }.await()
        async {withContext(Dispatchers.Main) {
            vm.logOut(this.coroutineContext)
        }  }.await()
        assert(vm.isLoggedIn.value == false) { "isLoggedIn: expected false, was true" }
        assert(vm.isGuest.value != true) { "isGuest: expected false, was true" }
        assert(vm.isGuest.value == LoginRepositoryAmplify.isGuest) { "isGuest: doesn't match with repository" }
        assert(vm.isLoggedIn.value == LoginRepositoryAmplify.isLoggedIn) { "isLoggedIn: doesn't match with repository" }
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