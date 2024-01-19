package com.example.returnpals.composetools
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.returnpals.composetools.IconManager

class loginOptions {
    /* This is the login options class used to create the two login uis for guest and user.*/
    @Composable
    fun drawGuestUI(user:(String) -> Unit, pass:(String) -> Unit, guest: () -> Unit, reset: () -> Unit, signin:() -> Unit, signup: () -> Unit) {
        val config = getConfig()
        val modifer = Modifier.size(config.screenWidthDp.dp,config.screenHeightDp.dp).background(color = Color(0xFFE1F6FF))

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifer, verticalArrangement = Arrangement.SpaceBetween) {
                IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row() {
                        Text(text = "Sign In |")
                        ButtonManager.BackButton(onClick = guest, text = "Guest")
                    }
                    TextField(value = "Email", onValueChange = user)
                    TextField(value = "Password", onValueChange = pass)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ButtonManager.BackButton(onClick = reset, text = "Forgot your password?")
                    ButtonManager.NextButton(onClick = signin, text = "Sign In",modifier = Modifier.size(config.screenWidthDp.dp/3,config.screenWidthDp.dp/15))
                    Row() {
                        Text(text = "Don't have an account yet?")
                        ButtonManager.BackButton(onClick = signup, text = "Sign up")
                    }
                }
            }
    }
}