package com.example.returnpals.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate
import com.example.returnpals.ui.ButtonManager.DateSelector
import com.example.returnpals.ui.pickup.PickupDateScreen

/**
 * Test the [PickupDateScreen] composable.
 */
class PickupDateTest {

    @get:Rule
    val rule = createComposeRule()

    /**
     * Test the next button. Check that it is displayed, that the on-click callback works, and that it can be disabled.
     */
    @Test
    fun testNextButton() {
        val minDate = LocalDate.now()
        val date = mutableStateOf(minDate)
        var isClicked: Boolean

        rule.setContent {
            PickupDateScreen(
                date = date.value,
                onChangeDate = { },
                onClickBack = { },
                onClickNext = { isClicked = true },
                isValidDate = { it >= minDate }
            )
        }

        val next = rule.onNodeWithText("Next")
        next.assertExists("Next button does not exist.")
        next.assertIsDisplayed()

        date.value = minDate
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button on-click event does not work." }

        date.value = minDate.minusDays(1)
        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button not disabled on invalid date." }
    }

    /**
     * Test the back button. Check that it is displayed, and that the on-click callback works.
     */
    @Test
    fun testBackButton() {
        var isClicked: Boolean

        rule.setContent {
            PickupDateScreen(
                date = LocalDate.now(),
                onChangeDate = { },
                onClickBack = { isClicked = true },
                onClickNext = { },
                isValidDate = { true }
            )
        }

        val back = rule.onNodeWithText("Cancel")
        back.assertExists("Back button does not exist.")
        back.assertIsDisplayed()

        isClicked = false
        back.performClick()
        assert(isClicked) {"Back button on-click event does not work."}
    }

    /**
     * Test the [DateSelector]. Check that it is displayed, and that the increment/decrement date buttons work.
     */
    @Test
    fun testDateSelector() {
        val initDate = LocalDate.now()
        val date = mutableStateOf(initDate)

        rule.setContent {
            PickupDateScreen(
                date = date.value,
                onChangeDate = { date.value = it },
                onClickBack = { },
                onClickNext = { },
                isValidDate = { true }
            )
        }

        // Test that selected date is displayed

        val month = rule.onNodeWithText(date.value.month.toString())
        val day = rule.onNodeWithText(date.value.dayOfMonth.toString())
        val year = rule.onNodeWithText(date.value.year.toString())

        month.assertExists("Selected Month does not exist.")
        day.assertExists("Selected Day does not exist.")
        year.assertExists("Selected Year does not exist.")

        month.assertIsDisplayed()
        day.assertIsDisplayed()
        year.assertIsDisplayed()

        // Test that previous date is displayed

        val prevMonth = rule.onNodeWithText(date.value.minusMonths(1).month.toString())
        val prevDay = rule.onNodeWithText(date.value.minusDays(1).dayOfMonth.toString())
        val prevYear = rule.onNodeWithText(date.value.minusYears(1).year.toString())

        prevMonth.assertExists("Previous Month does not exist.")
        prevDay.assertExists("Previous Day does not exist.")
        prevYear.assertExists("Previous Year does not exist.")

        prevMonth.assertIsDisplayed()
        prevDay.assertIsDisplayed()
        prevYear.assertIsDisplayed()

        // Test that next date is displayed

        val nextMonth = rule.onNodeWithText(date.value.plusMonths(1).month.toString())
        val nextDay = rule.onNodeWithText(date.value.plusDays(1).dayOfMonth.toString())
        val nextYear = rule.onNodeWithText(date.value.plusYears(1).year.toString())

        nextMonth.assertExists("Next Month does not exist.")
        nextDay.assertExists("Next Day does not exist.")
        nextYear.assertExists("Next Year does not exist.")

        nextMonth.assertIsDisplayed()
        nextDay.assertIsDisplayed()
        nextYear.assertIsDisplayed()

        // Test onChangeDate for previous date buttons:

        date.value = initDate
        prevMonth.performClick()
        assert(date.value == initDate.minusMonths(1)) {
            "Decrement Month button does not work."
        }

        date.value = initDate
        prevDay.performClick()
        assert(date.value == initDate.minusDays(1)) {
            "Decrement Day button does not work."
        }

        date.value = initDate
        prevYear.performClick()
        assert(date.value == initDate.minusYears(1)) {
            "Decrement Year button does not work."
        }

        // Test onChangeDate for next date buttons:

        date.value = initDate
        nextMonth.performClick()
        assert(date.value == initDate.plusMonths(1)) {
            "Increment Month button does not work."
        }

        date.value = initDate
        nextDay.performClick()
        assert(date.value == initDate.plusDays(1)) {
            "Increment Day button does not work."
        }

        date.value = initDate
        nextYear.performClick()
        assert(date.value == initDate.plusYears(1)) {
            "Increment Year button does not work."
        }
    }

}