package com.example.returnpals.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.returnpals.PickupMethod
import com.example.returnpals.ui.pickup.PickupMethodScreen
import org.junit.Rule
import org.junit.Test

/**
 * Tests the [PickupMethodScreen] composable.
 */
class PickupMethodTest {

    @get:Rule
    val rule = createComposeRule()

    /**
     * Test the next button. Check that it is displayed, that the on-click callback works, and that it can be disabled.
     */
    @Test
    fun testNextButton() {
        val method = mutableStateOf<PickupMethod?>(null)
        var isClicked: Boolean

        rule.setContent {
            PickupMethodScreen(
                method = method.value,
                onChangeMethod = { },
                onClickBack = { },
                onClickNext = { isClicked = true },
            )
        }

        val next = rule.onNodeWithText("Next")
        next.assertExists("Next button does not exist.")
        next.assertIsDisplayed()

        method.value = PickupMethod.DOORSTEP
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button on-click event does not work." }

        method.value = null
        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button enabled when no valid option is selected." }
    }

    /**
     * Test the back button. Check that it is displayed, and that the on-click callback works.
     */
    @Test
    fun testBackButton() {
        var isClicked: Boolean

        rule.setContent {
            PickupMethodScreen(
                method = null,
                onChangeMethod = { },
                onClickBack = { isClicked = true },
                onClickNext = { },
            )
        }

        val back = rule.onNodeWithText("Back")
        back.assertExists("Back button does not exist.")
        back.assertIsDisplayed()

        isClicked = false
        back.performClick()
        assert(isClicked) { "Back button on-click event does not work." }
    }

    /**
     * Test the doorstep method button. Check that it is displayed, and that the on-change-method callback works.
     */
    @Test
    fun testDoorstepOption() {
        val method = mutableStateOf<PickupMethod?>(null)

        rule.setContent {
            PickupMethodScreen(
                method = method.value,
                onChangeMethod = { method.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val doorstep = rule.onNodeWithText("Leave on Doorstep")
        doorstep.assertExists("\"Leave on Doorstep\" option does not exist.")
        doorstep.assertIsDisplayed()

        method.value = null
        doorstep.performClick()
        assert(method.value == PickupMethod.DOORSTEP) { "\"Leave on Doorstep\" option on-click event does not work." }
    }

    /**
     * Test the handoff method button. Check that it is displayed, and that the on-change-method callback works.
     */
    @Test
    fun testHandoffOption() {
        val method = mutableStateOf<PickupMethod?>(null)

        rule.setContent {
            PickupMethodScreen(
                method = method.value,
                onChangeMethod = { method.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val handoff = rule.onNodeWithText("Direct Handoff")
        handoff.assertExists("\"Direct Handoff\" option does not exist.")
        handoff.assertIsDisplayed()

        method.value = null
        handoff.performClick()
        assert(method.value == PickupMethod.HANDOFF) { "\"Direct Handoff\" option on-click event does not work." }
    }

}