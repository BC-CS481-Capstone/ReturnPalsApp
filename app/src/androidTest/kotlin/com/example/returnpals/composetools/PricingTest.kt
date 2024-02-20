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

class PricingTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testPricingUI() {
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

        plan.value = PricingPlan.BRONZE
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button not enabled when pickup method is selected." }

        isClicked = false
        back.performClick()
        assert(isClicked) { "Back button does not work." }

        // Test pricing plan options:

        val bronze = rule.onNodeWithTag(PricingPlan.BRONZE.toString())
        val silver = rule.onNodeWithTag(PricingPlan.SILVER.toString())
        val gold = rule.onNodeWithTag(PricingPlan.GOLD.toString())
        val platinum = rule.onNodeWithTag(PricingPlan.PLATINUM.toString())

        bronze.assertExists("Bronze plan does not exist.")
        silver.assertExists("Silver plan does not exist.")
        gold.assertExists("Gold plan does not exist.")
        platinum.assertExists("Platinum plan does not exist.")

        bronze.assertIsDisplayed()
        silver.assertIsDisplayed()
        gold.assertIsDisplayed()
        platinum.assertIsDisplayed()

        plan.value = null
        bronze.performClick()
        assert(plan.value == PricingPlan.BRONZE) { "Bronze plan's onclick does not work." }

        plan.value = null
        silver.performClick()
        assert(plan.value == PricingPlan.SILVER) { "Silver plan's onclick does not work." }

        plan.value = null
        gold.performClick()
        assert(plan.value == PricingPlan.GOLD) { "Gold plan's onclick does not work." }

        plan.value = null
        platinum.performClick()
        assert(plan.value == PricingPlan.PLATINUM) { "Platinum plan's onclick does not work." }
    }

}