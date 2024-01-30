package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class LiveChat {
    //Live chat class

    // Source to fix padding with keyboard
    // https://stackoverflow.com/questions/64050392/software-keyboard-overlaps-content-of-jetpack-compose-view
    @Composable
    fun drawChatFrame(send:()->Unit,message:(String)->Unit,messages:List<String>) {
        // Draw frame for chat interface
        // Requires drawChatScroll box as correct height for keyboard
        Column(
            Modifier
                .fillMaxSize()
                .background(color = getBackGroundColor())){
            drawChatScroll(messages)
            drawChatInput(send = send) {message(it)}
        }
    }
    @Composable
    fun drawChatScroll(messages:List<String>) {
        //Shows all messages in scrollable column.
        //Sets height to fit with keyboard
        var height = getConfig().screenHeightDp/2
        Column(
            Modifier
                .fillMaxWidth()
                .height(height.dp).verticalScroll(rememberScrollState())) {
            for (text:String in messages) {
                Text(text,Modifier.background(color= Color.White,shape = RoundedCornerShape(10)))
            }
        }
    }
    @Composable
    fun drawChatInput(send:()->Unit,message:(String)->Unit) {
        //Creates a row for text input from user.
        //Includes a send button
        var inputText by remember { mutableStateOf("") }
        Row {
            OutlinedTextField(value = inputText,
                onValueChange = {it -> inputText = it
                                message(it)
                                }
            )
            ButtonManager.NextButton(text = "Send", onClick = send)
        }
    }
}