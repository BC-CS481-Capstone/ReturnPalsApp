package com.example.returnpals.composetools

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.composetools.dashboard.ProfileContent
import org.junit.Rule
import org.junit.Test

class ProfileTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun yourPlanTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Your Plan:").assertIsDisplayed()
    }
    @Test
    fun planTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("SILVER").assertIsDisplayed()
    }
    @Test
    fun startDateTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Start Date:").assertIsDisplayed()
    }
    @Test
    fun billingTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Next Billing On:").assertIsDisplayed()
    }
    @Test
    fun cancelTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Cancel").assertIsDisplayed()
    }
}