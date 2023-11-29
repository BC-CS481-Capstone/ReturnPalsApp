package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.packageinfoaddlabelcomponent.PackageInfoAddLabelComponent

class PackageInfoAddLabelGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageInfoAddLabelComponent(addPackageButton = {
                var x = Intent(this,PackageInfoShowLabelGuestActivity::class.java)
                startActivity(x)
            })
        }
    }
}
