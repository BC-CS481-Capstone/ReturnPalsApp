package com.example.returnpals.composetools

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class ConfirmPickupTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun progressBarChecks() {
        rule.setContent {
           ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun confimYourPickupText() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }

    @Test
    fun orderSummeryText() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun calendarDates() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun pickupTypeChecks() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun addresschecks() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun numberOfLabelsDigital() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun numberOfLabelsPhysical() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun numberOfLabelsIcons() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun cardCheck() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun priceChecks() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun nextButton() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun backButton() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
    @Test
    fun promoChecks() {
        rule.setContent {
            ConfirmPickup().drawConfirmPickup(nextButton = {}, backButton = {}) {}
        }
    }
}