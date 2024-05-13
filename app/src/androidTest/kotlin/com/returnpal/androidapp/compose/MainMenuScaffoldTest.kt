package com.returnpal.androidapp.compose


import DrawerContent
import MainMenuScaffold
import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainMenuScaffoldTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun appTopBarTest() {
        rule.setContent {
            val navController = rememberNavController()
            MainMenuScaffold(navController = navController) {

            }
        }

        rule.onNodeWithContentDescription("Menu").performClick()
    }

    @Test
    fun drawerTest() {
        // Set up the testing environment for DrawerContent
        rule.setContent {
            TestDrawerContent()
        }

        // Check if the "Home" item is displayed in the drawer
        rule.onNodeWithText("Home").assertIsDisplayed().assertHasClickAction()
        rule.onNodeWithText("About").assertIsDisplayed().assertHasClickAction()
        rule.onNodeWithText("Pricing").assertIsDisplayed().assertHasClickAction()
        rule.onNodeWithText("Contact").assertIsDisplayed().assertHasClickAction()
        rule.onNodeWithText("Sign In").assertIsDisplayed().assertHasClickAction()
        rule.onNodeWithText("FAQ").assertIsDisplayed().assertHasClickAction()

    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun TestDrawerContent() {
        val scaffoldState = rememberScaffoldState()
        val navController = rememberNavController()


        // Scaffold to provide the necessary environment for DrawerContent
        Scaffold(scaffoldState = scaffoldState) {
            DrawerContent(navController = navController, scaffoldState = scaffoldState)
        }
    }



}