package com.example.returnpals.composetools

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import org.junit.Rule
import org.junit.Test

class PackagesTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testPackagesUI() {
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
        next.performClick()
        assert(!isClicked) { "Next button not disabled when packages table is empty." }

        packages[1] = PackageInfo(1, "nordstrom.png", PackageLabelType.DIGITAL)
        rule.onNodeWithText("nordstrom.png").assertIsDisplayed()

        isClicked = false
        next.performClick()
        assert(isClicked) { "Next button not enabled when packages table is non-empty." }

        packages[2] = PackageInfo(2, "jcpenny.png", PackageLabelType.PHYSICAL)
        rule.onNodeWithText("jcpenny.png").assertIsDisplayed()

        val physical = rule.onNodeWithText("Physical Label")
        val digital = rule.onNodeWithText("Digital Label")
        val qrcode = rule.onNodeWithText("Amazon QR Code")

        physical.assertExists("Add physical label button does not exist.")
        digital.assertExists("Add digital label button does not exist.")
        qrcode.assertExists("Add amazon qr code label button does not exist.")

        physical.assertIsDisplayed()
        digital.assertIsDisplayed()
        qrcode.assertIsDisplayed()

        // TODO: Test add label popup UI, onAddLabel, and onRemoveLabel

    }

}