package com.example.returnpals.composetools


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsConfiguration
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class IconManagerTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun getAmazonIcon() {
        rule.setContent { IconManager().getAmazonIcon(Modifier) }
        rule.onNodeWithContentDescription("Amazon Icon").assertIsDisplayed()
    }
    @Test
    fun getBarcodeIcon() {
        rule.setContent {IconManager().getBarcodeIcon(Modifier)}
        rule.onNodeWithContentDescription("Barcode Icon").assertIsDisplayed()
    }

    @Test
    fun getBestchoiceIcon() {
        rule.setContent {IconManager().getBestchoiceIcon(Modifier)}
        rule.onNodeWithContentDescription("Bestchoice Icon").assertIsDisplayed()
    }

    @Test
    fun getBoxIcon() {
        rule.setContent {IconManager().getBoxIcon(Modifier)}
        rule.onNodeWithContentDescription("Box Icon").assertIsDisplayed()
    }

    @Test
    fun getBoxholdIcon() {
        rule.setContent {IconManager().getBoxholdIcon(Modifier)}
        rule.onNodeWithContentDescription("Boxhold Icon").assertIsDisplayed()
    }

    @Test
    fun getBoxliftIcon() {
        rule.setContent {IconManager().getBoxliftIcon(Modifier)}
        rule.onNodeWithContentDescription("Boxlift Icon").assertIsDisplayed()
    }

    @Test
    fun getCalendarIcon() {
        rule.setContent {IconManager().getCalendarIcon(Modifier)}
        rule.onNodeWithContentDescription("Calendar Icon").assertIsDisplayed()
    }

    @Test
    fun getCheckmarkIcon() {
        rule.setContent {IconManager().getCheckmarkIcon(Modifier)}
        rule.onNodeWithContentDescription("Checkmark Icon").assertIsDisplayed()
    }

    @Test
    fun getComputerIcon() {
        rule.setContent {IconManager().getComputerIcon(Modifier)}
        rule.onNodeWithContentDescription("Computer Icon").assertIsDisplayed()
    }

    @Test
    fun getDoorstepIcon() {
        rule.setContent {IconManager().getDoorstepIcon(Modifier)}
        rule.onNodeWithContentDescription("Doorstep Icon").assertIsDisplayed()
    }

    @Test
    fun getFileIcon() {
        rule.setContent {IconManager().getFileIcon(Modifier)}
        rule.onNodeWithContentDescription("File Icon").assertIsDisplayed()
    }

    @Test
    fun getHandoffIcon() {
        rule.setContent {IconManager().getHandoffIcon(Modifier)}
        rule.onNodeWithContentDescription("Handoff Icon").assertIsDisplayed()
    }

    @Test
    fun getLabelIcon() {
        rule.setContent {IconManager().getLabelIcon(Modifier)}
        rule.onNodeWithContentDescription("Label Icon").assertIsDisplayed()
    }

    @Test
    fun getPinIcon() {
        rule.setContent {IconManager().getPinIcon(Modifier)}
        rule.onNodeWithContentDescription("Pin Icon").assertIsDisplayed()
    }

    @Test
    fun getReturnPalNameIcon() {
        rule.setContent {IconManager().getReturnPalNameIcon(Modifier)}
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }

    @Test
    fun getReturnPalIcon() {
        rule.setContent {IconManager().getReturnPalIcon(Modifier)}
        rule.onNodeWithContentDescription("ReturnPal Image").assertIsDisplayed()
    }

    @Test
    fun getStopwatchIcon() {
        rule.setContent {IconManager().getStopwatchIcon(Modifier)}
        rule.onNodeWithContentDescription("Stopwatch Icon").assertIsDisplayed()
    }

    @Test
    fun getTruckIcon() {
        rule.setContent {IconManager().getTruckIcon(Modifier)}
        rule.onNodeWithContentDescription("Truck Icon").assertIsDisplayed()
    }

    @Test
    fun getVanIcon() {
        rule.setContent {IconManager().getVanIcon(Modifier)}
        rule.onNodeWithContentDescription("Van Icon").assertIsDisplayed()
    }
}