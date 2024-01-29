package com.example.returnpals.composetools

import android.location.Address
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import java.util.Calendar
import java.util.Locale

class ConfirmPickupTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun progressBarChecks() {
        rule.setContent {
           ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("Pay & Confirm").assertIsDisplayed()
    }
    @Test
    fun confimYourPickupText() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("Confirm Your Pickup").assertIsDisplayed()
    }

    @Test
    fun orderSummeryText() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("Order Summary").assertIsDisplayed()
    }
    @Test
    fun calendarDates() {
        val dates = Calendar.getInstance()
        dates.set(2024 ,0, 28)
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(pickUpDate = dates,nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("Sunday January 28").assertIsDisplayed()
    }
    @Test
    fun pickupTypeChecks() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("Leave On doorstep").assertIsDisplayed()
    }
    @Test
    fun addresschecks() {
        val address = Address(Locale.CANADA)
        address.setAddressLine(0,"3000 Landerholm Cir SE, Bellevue, WA 98007")
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(pickUpAddress = address,nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("3000 Landerholm Cir SE, Bellevue, WA 98007").assertIsDisplayed()
    }
    @Test
    fun numberOfLabelsDigital() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("0 Package with digital label").assertIsDisplayed()
    }
    @Test
    fun numberOfLabelsPhysical() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("0 Package with physical label").assertIsDisplayed()
    }
    @Test
    fun numberOfLabelsIcons() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onAllNodesWithContentDescription("Box Icon").assertCountEquals(2)
    }
    @Test
    fun cardCheck() {
        val prices = arrayOf(11,1,12)
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(priceArray = prices,nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("5555").assertIsDisplayed()
    }
    @Test
    fun priceChecks() {
        val prices = arrayOf(11,1,12)
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(priceArray = prices,nextButton = {}, backButton = {}) {}
        }
        rule.onNodeWithText("12").assertIsDisplayed()
    }
    @Test
    fun nextButton() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNode(hasText("Next") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun backButton() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
        rule.onNode(hasText("Back") and hasClickAction()).assertIsDisplayed()
    }
}