package com.example.returnpals.composetools

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.returnpals.PickupMethod
import org.junit.Rule
import org.junit.Test

class PickupMethodTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testPickupMethodUI() {
        val method = mutableStateOf<PickupMethod?>(null)
        var isClicked: Boolean

        rule.setContent {
            PickupMethodUI(
                method = method.value,
                onChangeMethod = { method.value = it },
                onClickBack = { isClicked = true },
                onClickNext = { isClicked = true },
            )
        }

        // Test next and back buttons:

        val next = rule.onNodeWithText("Next")
        val back = rule.onNodeWithText("Back")

        next.assertExists("Next button does not exist")
        back.assertExists("Back button does not exist")

        next.assertIsDisplayed()
        back.assertIsDisplayed()

        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button not disabled when no pickup method is selected." }

        method.value = PickupMethod.DOORSTEP
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button not enabled when pickup method is selected." }

        isClicked = false
        back.performClick()
        assert(isClicked) { "Back button does not work." }

        // Test pickup method options:

        val doorstep = rule.onNodeWithText("Leave on Doorstep")
        val handoff = rule.onNodeWithText("Direct Handoff")

        doorstep.assertExists("Doorstep option does not exist.")
        handoff.assertExists("Handoff option does not exist.")

        doorstep.assertIsDisplayed()
        handoff.assertIsDisplayed()

        method.value = null
        doorstep.performClick()
        assert(method.value == PickupMethod.DOORSTEP) { "Doorstep option's onclick does not work." }

        method.value = null
        handoff.performClick()
        assert(method.value == PickupMethod.HANDOFF) { "Doorstep option's onclick does not work." }
    }

}