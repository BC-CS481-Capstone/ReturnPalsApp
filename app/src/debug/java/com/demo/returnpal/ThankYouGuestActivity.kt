package com.demo.returnpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.thankyouguestcomponent.ThankYouGuestComponent

class ThankYouGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThankYouGuestComponent()
        }
    }
}

