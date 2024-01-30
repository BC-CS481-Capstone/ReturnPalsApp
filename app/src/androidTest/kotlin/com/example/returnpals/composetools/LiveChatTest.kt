package com.example.returnpals.composetools

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class LiveChatTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun sendMessage() {
        rule.setContent{
            //LiveChat().drawChatFrame(send = { /*TODO*/ }, message = , messages = )
        }
    }

    @Test
    fun readMessages() {
        rule.setContent {}
    }

    @Test
    fun sendButton() {
        rule.setContent {}
    }

    @Test
    fun textField() {
        rule.setContent {}
    }
    @Test
    fun iconChecks() {
        rule.setContent {}
    }
    @Test
    fun iconChecks2() {
        rule.setContent {}
    }

}