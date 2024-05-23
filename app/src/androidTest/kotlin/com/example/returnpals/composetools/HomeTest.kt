package com.example.returnpals.composetools

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.composetools.mainMenu.HomeContent
import org.junit.Rule
import org.junit.Test

class HomeTest {

    @get: Rule
    val rule = createComposeRule()

    @Test
    fun homeButtonTest() {

        rule.setContent {
            HomeContent({  }) }

        rule.onNodeWithText("Schedule Now").assertHasClickAction().assertIsDisplayed()
    }

}