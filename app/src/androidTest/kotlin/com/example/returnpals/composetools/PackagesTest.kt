package com.example.returnpals.composetools

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import org.junit.Rule
import org.junit.Test

// TODO: Test add label popup UI, onAddLabel, and onRemoveLabel

/**
 * Tests the [PackagesUI] composable.
 */
class PackagesTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testNextButton() {
        val packages = mutableStateMapOf<Long, PackageInfo>()
        var isClicked: Boolean

        rule.setContent {
            PackagesUI(
                packages = packages.values.toList(),
                onAddLabel = { packages[it.id] = it },
                onRemoveLabel = { packages.remove(it) },
                onClickBack = { isClicked = true },
                onClickNext = { isClicked = true }
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
        back.performClick()
        assert(isClicked) { "Back button does not work." }

        isClicked = false
        packages[1] = PackageInfo(1, "nordstrom.png", PackageLabelType.DIGITAL)
        next.performClick()
        assert(isClicked) { "Next button on-click event does not work." }

        isClicked = false
        packages.clear()
        next.performClick()
        assert(!isClicked) { "Next button not disabled when packages table is empty." }
    }

    @Test
    fun testBackButton() {
        var isClicked: Boolean

        rule.setContent {
            PackagesUI(
                packages = emptyList(),
                onAddLabel = { },
                onRemoveLabel = { },
                onClickBack = { isClicked = true },
                onClickNext = { }
            )
        }

        val back = rule.onNodeWithText("Back")
        back.assertExists("Back button does not exist.")
        back.assertIsDisplayed()

        isClicked = false
        back.performClick()
        assert(isClicked) { "Back button on-click does not work." }
    }

    /**
     * Test that every item in packages argument is displayed.
     */
    @Test
    fun testPackagesTable() {
        val packages = mutableStateMapOf<Long, PackageInfo>()

        rule.setContent {
            PackagesUI(
                packages = packages.values.toList(),
                onAddLabel = { packages[it.id] = it },
                onRemoveLabel = { },
                onClickBack = { },
                onClickNext = { }
            )
        }

        // Test next and back buttons:

        packages[1] = PackageInfo(1, "nordstrom.png", PackageLabelType.DIGITAL)
        rule.onNodeWithText("nordstrom.png").assertIsDisplayed()

        packages[2] = PackageInfo(2, "jcpenny.png", PackageLabelType.PHYSICAL)
        rule.onNodeWithText("jcpenny.png").assertIsDisplayed()
    }

    /**
     * INCOMPLETE: functionality not yet tested.
     */
    @Test
    fun testAddLabelPhysical() {
        val packages = mutableStateMapOf<Long, PackageInfo>()

        rule.setContent {
            PackagesUI(
                packages = packages.values.toList(),
                onAddLabel = { packages[it.id] = it },
                onRemoveLabel = { },
                onClickBack = { },
                onClickNext = { }
            )
        }

        val physical = rule.onNodeWithText("Physical Label")
        physical.assertExists("Add Physical Label button does not exist.")
        physical.assertIsDisplayed()
    }

    /**
     * INCOMPLETE: functionality not yet tested.
     */
    @Test
    fun testAddLabelDigital() {
        val packages = mutableStateMapOf<Long, PackageInfo>()

        rule.setContent {
            PackagesUI(
                packages = packages.values.toList(),
                onAddLabel = { packages[it.id] = it },
                onRemoveLabel = { },
                onClickBack = { },
                onClickNext = { }
            )
        }

        val digital = rule.onNodeWithText("Digital Label")
        digital.assertExists("Add Digital Label button does not exist.")
        digital.assertIsDisplayed()
    }

    /**
     * INCOMPLETE: functionality not yet tested.
     */
    @Test
    fun testAddLabelQRCode() {
        val packages = mutableStateMapOf<Long, PackageInfo>()

        rule.setContent {
            PackagesUI(
                packages = packages.values.toList(),
                onAddLabel = { packages[it.id] = it },
                onRemoveLabel = { },
                onClickBack = { },
                onClickNext = { }
            )
        }

        val qrcode = rule.onNodeWithText("Amazon QR Code")
        qrcode.assertExists("Add Amazon QR Code button does not exist.")
        qrcode.assertIsDisplayed()
    }

    /**
     * INCOMPLETE: component not yet implemented.
     */
    @Test
    fun testRemoveLabel() {}

}