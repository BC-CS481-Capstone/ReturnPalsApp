package com.example.returnpals.composetools

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.returnpals.PricingPlan
import org.junit.Rule
import org.junit.Test

/**
 * Tests the [PricingUI] composable.
 */
class PricingTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testNextButton() {
        val plan = mutableStateOf<PricingPlan?>(null)
        var isClicked: Boolean

        rule.setContent {
            PricingUI(
                plan = plan.value,
                onChangePlan = { plan.value = it },
                onClickBack = { isClicked = true },
                onClickNext = { isClicked = true },
            )
        }

        val next = rule.onNodeWithText("Next")
        next.assertExists("Next button does not exist.")
        next.assertIsDisplayed()

        plan.value = PricingPlan.BRONZE
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button on-click event does not work." }

        plan.value = null
        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button not disabled when no pickup method is selected." }

    }

    @Test
    fun testBackButton() {
        var isClicked: Boolean

        rule.setContent {
            PricingUI(
                plan = null,
                onChangePlan = { },
                onClickBack = { isClicked = true },
                onClickNext = { isClicked = true },
            )
        }

        val back = rule.onNodeWithText("Back")
        back.assertExists("Back button does not exist.")
        back.assertIsDisplayed()

        isClicked = false
        back.performClick()
        assert(isClicked) { "Back button on-click event does not work." }
    }

    @Test
    fun testBronzeOption() {
        val plan = mutableStateOf<PricingPlan?>(null)

        rule.setContent {
            PricingUI(
                plan = plan.value,
                onChangePlan = { plan.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val bronze = rule.onNodeWithTag(PricingPlan.BRONZE.toString(), useUnmergedTree = true)
        bronze.assertExists("Bronze plan does not exist.")
        bronze.assertIsDisplayed()

        plan.value = null
        bronze.performClick()
        assert(plan.value == PricingPlan.BRONZE) { "Bronze option on-click does not work." }
    }

    @Test
    fun testSilverOption() {
        val plan = mutableStateOf<PricingPlan?>(null)

        rule.setContent {
            PricingUI(
                plan = plan.value,
                onChangePlan = { plan.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val silver = rule.onNodeWithTag(PricingPlan.SILVER.toString(), useUnmergedTree = true)
        silver.assertExists("Silver plan does not exist.")
        silver.assertIsDisplayed()

        plan.value = null
        silver.performClick()
        assert(plan.value == PricingPlan.SILVER) { "Silver option on-click does not work." }
    }

    @Test
    fun testGoldOption() {
        val plan = mutableStateOf<PricingPlan?>(null)

        rule.setContent {
            PricingUI(
                plan = plan.value,
                onChangePlan = { plan.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val gold = rule.onNodeWithTag(PricingPlan.GOLD.toString(), useUnmergedTree = true)
        gold.assertExists("Gold plan does not exist.")
        gold.assertIsDisplayed()

        plan.value = null
        gold.performClick()
        assert(plan.value == PricingPlan.GOLD) { "Gold option on-click does not work." }
    }

    @Test
    fun testPlatinumOption() {
        val plan = mutableStateOf<PricingPlan?>(null)

        rule.setContent {
            PricingUI(
                plan = plan.value,
                onChangePlan = { plan.value = it },
                onClickBack = { },
                onClickNext = { },
            )
        }

        val platinum = rule.onNodeWithTag(PricingPlan.PLATINUM.toString(), useUnmergedTree = true)
        platinum.assertExists("Platinum plan does not exist.")
        platinum.assertIsDisplayed()

        plan.value = null
        platinum.performClick()
        assert(plan.value == PricingPlan.PLATINUM) { "Platinum option on-click does not work." }
    }

}