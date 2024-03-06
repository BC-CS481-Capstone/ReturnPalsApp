package com.example.returnpals.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.PricingPlan
import com.example.returnpals.services.ProfileRepository
import com.example.returnpals.ui.dashboard.ProfileContent
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class ProfileTest {
    @get:Rule
    val rule = createComposeRule()
    private var profile = ProfileRepository(email = "test@test.com");
    //test YourPlan is displayed
    @Test
    fun yourPlanTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Your Plan:").assertIsDisplayed()
    }
    //Test Silver is displayed
    @Test
    fun planTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithTag(PricingPlan.SILVER.toString()).assertIsDisplayed()
    }
    //Test welcome, will be updated once a continuous profile presence is established.
    @Test
    fun welcomeTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Welcome, John Doe").assertIsDisplayed()
    }
    //Test expired date shows
    @Test
    fun expireTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Plan Expires On:").assertIsDisplayed()
    }
    //Test cancel button is shown
    @Test
    fun cancelTest(){
        rule.setContent{ ProfileContent() }
        rule.onNodeWithText("Cancel").assertIsDisplayed()
    }
    //Test for profile storing first name
    @Test
    fun firstNameTest(){
        assertEquals("John", profile.getFirstName())
    }
    //Test for profile storing last name
    @Test
    fun lastNameTest(){
        assertEquals("Doe", profile.getLastName())
    }
    //test for profile storing type
    @Test
    fun typeTest(){
        assertEquals("SILVER", profile.getType())
    }
    /*
    createRandomEntry()
    profile.getDataBase()
    @Test
    fun trueFirstNameTest(){
        assertEquals("random", profile.getFirstName())
    }
    @Test
    fun trueLastNameTest(){
        assertEquals("random", profile.getLastName())
    }
    @Test
    fun trueTypeTest(){
        assertEquals("random", profile.getType())
    }
    @Test
    fun trueDateTest(){
        assertEquals("random", profile.getDate())
    }
     */
}