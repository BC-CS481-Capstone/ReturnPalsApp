package com.example.returnpals.composetools

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.composetools.dashboard.OrdersContent
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
    //Commented out for CI to work
    /*
    @Test
    fun orderUploadTest() {
        launchActivity<MainActivity>().use { scenario ->
            scenario.moveToState(Lifecycle.State.CREATED)
            var order = OrderRepository("Fred@email.com")
            Backend.createOrder(order)
            scenario.moveToState(Lifecycle.State.DESTROYED)
        }
    }
    */
    //Unsure how to test entries of table itself, WIP
}