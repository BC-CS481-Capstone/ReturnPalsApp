package com.example.returnpals.composetools

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.testing.TestNavHostController
import com.example.returnpals.mainMenu.AppNavigation
import com.example.returnpals.mainMenu.Contact
import com.example.returnpals.mainMenu.MenuRoutes
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

    // Unit test
    @Test
    fun appNavHost_verifyStartDestination() {
        assertEquals(MenuRoutes.Home, navController.currentDestination?.route)
    }

    @Test
    fun navigateToProfile_verifyNavigation() {
        // Simulate navigation action
        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Profile)
        }

        // Verify navigation to Profile
        assertEquals(MenuRoutes.Profile, navController.currentDestination?.route)
    }

    @Test
    fun navigateToContact_verifyNavigation() {

        rule.runOnUiThread {
            navController.navigate(MenuRoutes.Contact)
        }

        assertEquals(MenuRoutes.Contact, navController.currentDestination?.route)

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
        assertEquals(MenuRoutes.Home, navController.currentDestination?.route)
    }
}

