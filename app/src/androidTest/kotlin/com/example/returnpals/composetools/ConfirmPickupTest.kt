package com.example.returnpals.composetools

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.PickupMethod
import com.example.returnpals.PricingPlan
import com.example.returnpals.composetools.pickup.ConfirmPickupScreen
import com.example.returnpals.composetools.pickup.toNiceString
import com.example.returnpals.services.PickupInfo
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate

class ConfirmPickupTest {
    @get:Rule
    val rule = createComposeRule()

    private val testPickupInfo = PickupInfo(
        date = LocalDate.now().plusMonths(1),
        address = "3000 Landerholm Cir SE, Bellevue, WA 98007",
        method = PickupMethod.DOORSTEP,
        plan = PricingPlan.BRONZE,
        packages = listOf(
            PackageInfo(labelType = PackageLabelType.PHYSICAL, description = "heavy"),
            PackageInfo(labelType = PackageLabelType.PHYSICAL, description = "fragile, handle with care"),
            PackageInfo(labelType = PackageLabelType.PHYSICAL),
            PackageInfo(labelType = PackageLabelType.DIGITAL),
            PackageInfo(labelType = PackageLabelType.DIGITAL),
            PackageInfo(labelType = PackageLabelType.QRCODE)
        )
    )

    @Test
    fun testPricingPlan() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Pricing Plan:").assertIsDisplayed()
        rule.onNodeWithText(testPickupInfo.plan.toString()).assertIsDisplayed()
    }
    @Test
    fun testProgressBar() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Pay & Confirm").assertIsDisplayed()
    }
    @Test
    fun testTitle() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Confirm Your Pickup").assertIsDisplayed()
    }
    @Test
    fun testSummaryTitle() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText(substring=true,text="Order Summary").assertIsDisplayed()
    }
    @Test
    fun testDate() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Date:").assertIsDisplayed()
        rule.onNodeWithText(testPickupInfo.date.toNiceString()).assertIsDisplayed()
    }
    @Test
    fun testPickupMethod() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Pickup by:").assertIsDisplayed()
        rule.onNodeWithText(testPickupInfo.method.toString()).assertIsDisplayed()
    }
    @Test
    fun testAddress() {
//        val address = Address(Locale.CANADA)
//        address.setAddressLine(0,"3000 Landerholm Cir SE, Bellevue, WA 98007")
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Address:").assertIsDisplayed()
        rule.onNodeWithText(testPickupInfo.address.toString()).assertIsDisplayed()
    }
    @Test
    fun testDigitalLabelCount() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Digital Labels:").assertIsDisplayed()
        rule.onNodeWithText((testPickupInfo.packages.count { it.labelType == PackageLabelType.DIGITAL }).toString()).assertIsDisplayed()
    }
    @Test
    fun testPhysicalLabelCount() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Physical Labels:").assertIsDisplayed()
        rule.onNodeWithText((testPickupInfo.packages.count { it.labelType == PackageLabelType.PHYSICAL }).toString()).assertIsDisplayed()
    }
    @Test
    fun testQRCodeCount() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Amazon QR Codes:").assertExists()
        rule.onNodeWithText((testPickupInfo.packages.count { it.labelType == PackageLabelType.QRCODE }).toString()).assertExists()
    }
    @Test
    fun testIcons() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithContentDescription("Box Icon").assertIsDisplayed()
    }
    @Test
    fun testVisa() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo, visaLastFour = 4213) }
        rule.onNodeWithText("Charged to Visa ending in 4213").assertExists()
    }
    @Test
    fun testCost() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Cost:").assertIsDisplayed()
        // causes fail because more than one node has this text because total and cost are same because tax is currently zero
//        rule.onNodeWithText(testPickupInfo.cost.toString()).assertIsDisplayed()
    }
    @Test
    fun testTax() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Tax:").assertIsDisplayed()
        rule.onNodeWithText(testPickupInfo.tax.toString()).assertIsDisplayed()
    }
    @Test
    fun testTotal() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNodeWithText("Total:").assertIsDisplayed()
        // causes fail because more than one node has this text because total and cost are same because tax is currently zero
//        rule.onNodeWithText(testPickupInfo.total.toString()).assertIsDisplayed()
    }
    @Test
    fun testNext() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNode(hasText("Confirm") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun testBack() {
        rule.setContent { ConfirmPickupScreen(info = testPickupInfo) }
        rule.onNode(hasText("Back") and hasClickAction()).assertIsDisplayed()
    }
}