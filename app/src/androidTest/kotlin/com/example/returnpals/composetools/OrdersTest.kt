package com.example.returnpals.composetools

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.mainMenu.OrdersContent
import org.junit.Rule
import org.junit.Test

class OrdersTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testYourOrders() {
        rule.setContent { OrdersContent() }
        rule.onNodeWithText("Order History:").assertIsDisplayed()
    }

    @Test
    fun testHeaders() {
        rule.setContent { OrdersContent() }
        rule.onNodeWithText("Status").assertIsDisplayed()
        rule.onNodeWithText("Date").assertIsDisplayed()
    }
    //Unsure how to test entries of table itself, WIP
}