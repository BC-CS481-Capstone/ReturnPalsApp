package com.example.returnpals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.returnpals.ui.theme.ReturnPalsTheme
import com.example.returnpals.thankyou.ThankYou
import com.example.returnpals.guestthankyou.GuestThankYou
import com.example.returnpals.packageinfoshowlabel.PackageInfoShowLabel
import com.example.returnpals.packageinfo.PackageInfo
import com.example.returnpals.guestpackageinfoshowlabel.GuestPackageInfoShowLabel
import com.example.returnpals.guestpackageinfo.GuestPackageInfo
import com.example.returnpals.guestconfirmpickup.GuestConfirmPickup
import com.example.returnpals.confirmpickup.ConfirmPickup



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            runDemoQ1Final()
        }
    }
}
@Composable
fun runDemoQ1Final() {
    PackageInfo()
    Thread.sleep(6000)
    GuestPackageInfo()
    Thread.sleep(6000)
    PackageInfoShowLabel()
    Thread.sleep(6000)
    GuestPackageInfoShowLabel()
    Thread.sleep(6000)
    ConfirmPickup()
    Thread.sleep(6000)
    GuestConfirmPickup()
    Thread.sleep(6000)
    ThankYou()
    Thread.sleep(6000)
    GuestThankYou()
}
