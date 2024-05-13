package com.returnpal.androidapp.compose

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class LiveChatTest {
    @get:Rule
    val rule = createComposeRule()

   /** Removing unused test for functionality we will not use on current builds
    * @Test
    fun sendMessage() {
        var testString = ""
        rule.setContent{
            LiveChat().drawChatFrame(send = {  }, message = {it-> testString = it}, messages = listOf() )
        }
        rule.onNodeWithText("Thank you!").performTextInput("David Test 123")
        rule.onNodeWithText("Send").performClick()
        assert("David Test 123" == testString )
    }
    @Test
    fun sendMessageChatInput() {
        var testString = ""
        rule.setContent{
            LiveChat().drawChatInput(send = {  }, message = {it-> testString = it})
        }
        rule.onNodeWithText("Thank you!").performTextInput("David Test 456")
        rule.onNodeWithText("Send").performClick()
        assert("David Test 456" == testString )
    }*/

    @Test
    fun readTextInput() {
        rule.setContent {
            LiveChat().drawChatFrame(send = { }, message = {}, messages = listOf() )
        }
        rule.onNodeWithText("Thank you!").assertIsDisplayed()
    }
    @Test
    fun readMessages() {
        rule.setContent {
            LiveChat().drawChatFrame(send = { }, message = {}, messages = listOf("David Test 234") )
        }
        rule.onNodeWithText("David Test 234").assertIsDisplayed()
    }

    @Test
    fun sendButton() {
        rule.setContent {
            LiveChat().drawChatFrame(send = { }, message = {}, messages = listOf() )
        }
        rule.onNodeWithText("Send").assertHasClickAction()
    }


    @Test
    fun iconChecks() {
        rule.setContent {
            LiveChat().drawChatFrame(send = { }, message = {}, messages = listOf("This is From ReturnPal","David Test 345") )
        }
        rule.onNodeWithContentDescription("ReturnPal Image").assertIsDisplayed()
    }

}