package com.returnpal.androidapp.compose

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.returnpal.androidapp.compose.mainMenu.HomeScreen
import org.junit.Rule
import org.junit.Test

class HomeTest {

    @get: Rule
    val rule = createComposeRule()

    @Test
    fun homeButtonTest() {

        rule.setContent {
            val navController = rememberNavController()
            HomeScreen(navController = navController) }

        rule.onNodeWithText("Schedule Now").assertHasClickAction().assertIsDisplayed()
    }

}