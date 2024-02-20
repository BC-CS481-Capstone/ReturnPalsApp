package com.example.returnpals.composetools

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate

class PickupDateTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testPickupDateUI() {
        val minDate = LocalDate.now()
        val maxDate = minDate.plusMonths(1)
        var date = mutableStateOf(minDate)
        var isClicked: Boolean

        rule.setContent {
            PickupDateUI(
                date = date.value,
                onChangeDate = { date.value = it },
                onClickBack = { isClicked = true },
                onClickNext = { isClicked = true },
                isValidDate = { Log.println(Log.INFO, "date", it.toString()); it >= minDate && it < maxDate }
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
        assert(isClicked)

        isClicked = false
        back.performClick()
        assert(isClicked)

        // Test Date Selector:
        // Test that selected date is displayed:

        val month = rule.onNodeWithText(date.value.month.toString())
        val day = rule.onNodeWithText(date.value.dayOfMonth.toString())
        val year = rule.onNodeWithText(date.value.year.toString())

        month.assertExists("Month does not exist")
        day.assertExists("Day does not exist")
        year.assertExists("Year does not exist")

        month.assertIsDisplayed()
        day.assertIsDisplayed()
        year.assertIsDisplayed()

        // Test that previous date is displayed:

        val prevMonth = rule.onNodeWithText(date.value.minusMonths(1).month.toString())
        val prevDay = rule.onNodeWithText(date.value.minusDays(1).dayOfMonth.toString())
        val prevYear = rule.onNodeWithText(date.value.minusYears(1).year.toString())

        prevMonth.assertExists("Previous month does not exist")
        prevDay.assertExists("Previous day does not exist")
        prevYear.assertExists("Previous year does not exist")

        prevMonth.assertIsDisplayed()
        prevDay.assertIsDisplayed()
        prevYear.assertIsDisplayed()

        // Test onChangeDate for previous date buttons:

        date.value = minDate
        prevMonth.performClick()
        assert(date.value == minDate.minusMonths(1))

        date.value = minDate
        prevDay.performClick()
        assert(date.value == minDate.minusDays(1))

        date.value = minDate
        prevYear.performClick()
        assert(date.value == minDate.minusYears(1))

        // Test that next date is displayed:

        date.value = minDate
        val nextMonth = rule.onNodeWithText(date.value.plusMonths(1).month.toString())
        val nextDay = rule.onNodeWithText(date.value.plusDays(1).dayOfMonth.toString())
        val nextYear = rule.onNodeWithText(date.value.plusYears(1).year.toString())

        nextMonth.assertExists("Next month does not exist")
        nextDay.assertExists("Next day does not exist")
        nextYear.assertExists("Next year does not exist")

        nextMonth.assertIsDisplayed()
        nextDay.assertIsDisplayed()
        nextYear.assertIsDisplayed()

        // Test onChangeDate for next date buttons:

        date.value = minDate
        nextMonth.performClick()
        assert(date.value == minDate.plusMonths(1))

        date.value = minDate
        nextDay.performClick()
        assert(date.value == minDate.plusDays(1))

        date.value = minDate
        nextYear.performClick()
        assert(date.value == minDate.plusYears(1))

        // Test isValidDate:

        date.value = minDate.minusDays(1)
        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button not disabled on invalid date" }

        date.value = maxDate.plusDays(1)
        isClicked = false
        next.performClick()
        assert(!isClicked) { "Next button not disabled on invalid date" }

        date.value = minDate.plusDays(15)
        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button not enabled on invalid date" }

    }

}