package com.example.returnpals.composetools

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.example.returnpals.composetools.dashboard.ProfileContent
import com.example.returnpals.composetools.dashboard.ProfileViewModel
import com.example.returnpals.dataRepository.ProfileRepository
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
        rule.setContent{ ProfileContent(ProfileViewModel()) }
        rule.onNodeWithText("Your Plan:").assertIsDisplayed()
    }
    //Test Silver is displayed
    @Test
    fun planTest(){
        rule.setContent{ ProfileContent(ProfileViewModel()) }
        rule.onNodeWithTag(PricingPlan.BRONZE.toString()).assertIsDisplayed()
    }
    //Test welcome, will be updated once a continuous profile presence is established.
    @Test
    fun welcomeTest(){
        rule.setContent{ ProfileContent(ProfileViewModel()) }
        rule.onNodeWithText("Welcome, John Doe").assertIsDisplayed()
    }
    //Test expired date shows
    @Test
    fun expireTest(){
        rule.setContent{ ProfileContent(ProfileViewModel()) }
        rule.onNodeWithText("Plan Expires On:").assertIsDisplayed()
    }
    //Test cancel button is shown
    @Test
    fun cancelTest(){
        rule.setContent{ ProfileContent(ProfileViewModel()) }
        rule.onNodeWithText("Cancel").assertIsDisplayed()
    }
    //Test for profile view model
    @Test
    fun firstNameTest(){
        assertEquals("John", ProfileViewModel().getFirstName())
    }
    //Test for profile storing last name
    @Test
    fun lastNameTest(){
        assertEquals("Doe", ProfileViewModel().getLastName())
    }
    //test for profile storing type
    @Test
    fun typeTest(){
        assertEquals(PricingPlan.BRONZE.toString(), ProfileViewModel().getType())
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