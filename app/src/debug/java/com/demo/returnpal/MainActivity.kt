package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            buttonChoice(guest = {startActivity(Intent(this,PackageInfoGuestActivity::class.java))},
                user = {startActivity(Intent(this,PackageInfoActivity::class.java))})
        }
    }
}
@Composable
fun buttonChoice(guest: () -> Unit = {},
                 user: () -> Unit = {}) {
    Row(){
        guestButton(guest)
        userButton(user)
    }
}

@Composable
fun guestButton(onClick: () -> Unit) {
    Button(onClick = {onClick()}) {
       Text("Guest")
    }
}

@Composable
fun userButton(onClick: () -> Unit) {
    Button(onClick = {onClick()}) {
        Text("User")
    }
}