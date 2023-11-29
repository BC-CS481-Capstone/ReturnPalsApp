package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.packageinfocomponent.PackageInfoComponent

class PackageInfoGuestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageInfoComponent(physicalLabelButton = {
                var x = Intent(this,PackageInfoAddLabelGuestActivity::class.java)
                startActivity(x)
            },
                digitalLabelButton = {
                    var x = Intent(this,PackageInfoAddLabelGuestActivity::class.java)
                    startActivity(x)
                }, amazonQRCode = {
                    var x = Intent(this,PackageInfoAddLabelGuestActivity::class.java)
                    startActivity(x)
                } )
        }
    }
}

