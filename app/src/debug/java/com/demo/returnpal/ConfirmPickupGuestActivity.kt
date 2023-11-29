package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.confirmpickupcomponent.ConfirmPickupComponent

class ConfirmPickupGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfirmPickupComponent(nextButton = {
                var x = Intent(this,ThankYouGuestActivity::class.java)
                startActivity(x)
            })
        }
    }
}
