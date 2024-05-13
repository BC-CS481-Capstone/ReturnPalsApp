package com.returnpal.androidapp.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.returnpal.androidapp.compose.pickup.drawThankYouUI
import org.junit.Rule
import org.junit.Test

class ThankYouTest {
    //ThankYouTest Class uses an android device emulation to display UI compose functions.
    //Rules are used to assert UI elements are displayed.
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun progressBarChecks() {
        rule.setContent {
            drawThankYouUI {}
        }
        rule.onNodeWithText("Pay & Confirm").assertIsDisplayed()
    }
    @Test
    fun truckIcon() {
        rule.setContent {
            drawThankYouUI {}
        }
        rule.onNodeWithContentDescription("Truck Icon").assertIsDisplayed()
    }
    @Test
    fun thankYouText() {
        rule.setContent {
            drawThankYouUI {}
        }
        rule.onNodeWithText("Thank you for scheduling a return with us!").assertIsDisplayed()
    }
    @Test
    fun confirmText() {
        rule.setContent {
            drawThankYouUI(userName ="David", confirmNumber = "#TEST45873231997") {}
        }
        rule.onNodeWithText("David, your pickup order #TEST45873231997 is confirmed.").assertIsDisplayed()
    }
    @Test
    fun emailText() {
        rule.setContent {
            drawThankYouUI(email = "david.caldwell@returnpal.ham") {}
        }
        rule.onNodeWithText("A confirmation email will be sent to: david.caldwell@returnpal.ham").assertIsDisplayed()
    }
    @Test
    fun dashBoardButton() {
        rule.setContent {
            drawThankYouUI {}
        }
        rule.onNode(hasText("Return to Dashboard") and hasClickAction()).assertIsDisplayed()
    }

}