package com.example.returnpals.composetools

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.amplifyframework.datastore.generated.model.LabelType
import com.example.returnpals.PackageInfo
import com.example.returnpals.composetools.pickup.AddPackagesScreen
import com.example.returnpals.toNiceString
import org.junit.Rule
import org.junit.Test

// TODO: Test add label popup UI, onAddLabel, and onRemoveLabel

/**
 * Tests the [AddPackagesScreen] composable.
 */
class PackagesTest {

    @get:Rule
    val rule = createComposeRule()

    /**
     * Test the next button. Check that it is displayed, that the on-click callback works, and that it can be disabled.
     */
    @Test
    fun testNextButton() {
        val packages = mutableStateMapOf<Int, PackageInfo>()
        var isClicked: Boolean

        rule.setContent {
            AddPackagesScreen(
                packages = packages.toMap(),
                onAddLabel = { },
                onRemoveLabel = { },
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

        packages[1] = PackageInfo(labelType=LabelType.DIGITAL)
        next.performClick()
        assert(isClicked) { "Next button on-click event does not work." }

        isClicked = false
        packages.clear()
        next.performClick()
        assert(!isClicked) { "Next button not disabled when packages table is empty." }
    }

    /**
     * Test the back button. Check that it is displayed, and that the on-click callback works.
     */
    @Test
    fun testBackButton() {
        var isClicked: Boolean

        rule.setContent {
            AddPackagesScreen(
                packages = emptyMap(),
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
     * Test the package table. Check that every item in packages argument is displayed.
     */
    @Test
    fun testPackagesTable() {
        val packages = mutableStateMapOf<Int, PackageInfo>()
        var nextId = 0

        rule.setContent {
            AddPackagesScreen(
                packages = packages.toMap(),
                onAddLabel = { packages[nextId++] = it },
                onRemoveLabel = { },
                onClickBack = { },
                onClickNext = { }
            )
        }

        // Test next and back buttons:


        packages[1] = PackageInfo(labelType=LabelType.DIGITAL, description="Test 1")
        rule.onNodeWithText(LabelType.DIGITAL.toNiceString()).assertIsDisplayed()
        rule.onNodeWithText("Test 1").assertIsDisplayed()

        packages[2] = PackageInfo(labelType=LabelType.PHYSICAL, description="Test 2")
        rule.onNodeWithText(LabelType.PHYSICAL.toNiceString()).assertIsDisplayed()
        rule.onNodeWithText("Test 2").assertIsDisplayed()
    }

    /**
     * Test the "Add Physical" label button. Check that it is displayed.
     * INCOMPLETE: functionality not yet fully implemented.
     */
    @Test
    fun testAddLabelPhysical() {
        val packages = mutableStateMapOf<Int, PackageInfo>()
        var nextId = 0

        rule.setContent {
            AddPackagesScreen(
                packages = packages.toMap(),
                onAddLabel = { packages[nextId++] = it },
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
     * Test the "Add Digital" label button. Check that it is displayed.
     * INCOMPLETE: functionality not yet fully implemented.
     */
    @Test
    fun testAddLabelDigital() {
        val packages = mutableStateMapOf<Int, PackageInfo>()
        var nextId = 0

        rule.setContent {
            AddPackagesScreen(
                packages = packages.toMap(),
                onAddLabel = { packages[nextId++] = it },
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
     * Test the "Add Amazon QR Code" button. Check that it is displayed.
     * INCOMPLETE: functionality not yet fully implemented.
     */
    @Test
    fun testAddLabelQRCode() {
        val packages = mutableStateMapOf<Int, PackageInfo>()
        var nextId = 0

        rule.setContent {
            AddPackagesScreen(
                packages = packages.toMap(),
                onAddLabel = { packages[nextId++] = it },
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