package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.packageinfoshowlabelcomponent.PackageInfoShowLabelComponent

class PackageInfoShowLabelGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageInfoShowLabelComponent(nextButton = {
                var x = Intent(this,ConfirmPickupGuestActivity::class.java)
                startActivity(x)
            })
        }
    }
}
