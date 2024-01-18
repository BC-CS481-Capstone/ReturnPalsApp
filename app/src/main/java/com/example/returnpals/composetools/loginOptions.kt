package com.example.returnpals.composetools
import androidx.compose.foundation.background
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.example.returnpals.composetools.IconManager

class loginOptions {
    /* This is the login options class used to create the two login uis for guest and user.*/
    @Composable
    fun drawGuestUI(user:(String) -> Unit, pass:(String) -> Unit, guest: () -> Unit, reset: () -> Unit, signin:() -> Unit, signup: () -> Unit) {
        Column(Modifier.background(color = Color(0xE1F6FF))) {
            IconManager().getReturnPalIcon(Modifier)
            Column() {
                Row() {
                    Text(text = "Sign In |")
                    ButtonManager().BackButton(onClick = guest, text = "Guest")
                }
                TextField(value = "Email", onValueChange = user)
                TextField(value = "Password", onValueChange = pass)
            }
            Column() {
                ButtonManager().BackButton(onClick = reset, text = "Forgot your password?")
                ButtonManager().NextButton(onClick = signin,text = "Sign In")
                Row() {
                    Text(text = "Don't have an account yet?")
                    ButtonManager().BackButton(onClick = signup, text = "Sign up")
                }
            }
        }
    }
}