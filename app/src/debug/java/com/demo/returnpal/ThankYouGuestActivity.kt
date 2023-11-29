package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.thankyouguestcomponent.ThankYouGuestComponent

class ThankYouGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThankYouGuestComponent(scheduleAPickupButton = {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },
                createAnAccountButton = {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                })
        }
    }
}

