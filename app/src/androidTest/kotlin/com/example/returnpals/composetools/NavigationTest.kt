package com.example.returnpals.composetools

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.testing.TestNavHostController
import com.example.returnpals.navigation.AppNavigation
import com.example.returnpals.navigation.MenuRoutes
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val rule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        rule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavigation(navController = navController)
        }
    }

    @Test
    fun appNavHost_verifyStartDestination() {
        assertEquals("MainMenu", navController.currentDestination?.route)
    }

    @Test
    fun navigateToHome_verifyNavigation() {
        // Simulate navigation action
        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Home)
        }

        // Verify navigation to Home
        assertEquals(MenuRoutes.Home, navController.currentDestination?.route)
    }

    @Test
    fun navigateToAbout_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.About)
        }

        assertEquals(MenuRoutes.About, navController.currentDestination?.route)
    }

    @Test
    fun navigateToPricing_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Pricing)
        }


        assertEquals(MenuRoutes.Pricing, navController.currentDestination?.route)
    }
    @Test
    fun navigateToContact_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Contact)
        }

        assertEquals(MenuRoutes.Contact, navController.currentDestination?.route)

    }

    @Test
    fun navigateToSignIn_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.SignIn)
        }

        assertEquals(MenuRoutes.SignIn, navController.currentDestination?.route)

    }

    @Test
    fun navigateToFAQ_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.FAQ)
        }

        assertEquals(MenuRoutes.FAQ, navController.currentDestination?.route)

    }

    @Test
    fun navigateToDashboard_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.HomeDash)
        }

        assertEquals(MenuRoutes.HomeDash, navController.currentDestination?.route)

    }

    @Test
    fun navigateToProfile_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Profile)
        }

        assertEquals(MenuRoutes.Profile, navController.currentDestination?.route)

    }

    @Test
    fun navigateToSettings_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Settings)
        }

        assertEquals(MenuRoutes.Settings, navController.currentDestination?.route)

    }

    @Test
    fun navigateToOrders_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Orders)
        }

        assertEquals(MenuRoutes.Orders, navController.currentDestination?.route)

    }


    @Test
    fun navigateBackFromProfileToHome_verifyBackNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Profile)
        }

        // Simulate back press
        rule.runOnUiThread {
            navController.popBackStack()
        }

        // Verify back navigation to Home
        assertEquals("MainMenu", navController.currentDestination?.route)
    }
}

