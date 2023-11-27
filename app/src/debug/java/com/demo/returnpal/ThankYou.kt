package com.demo.returnpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ThankYou : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThankYou()
        }
    }
}

