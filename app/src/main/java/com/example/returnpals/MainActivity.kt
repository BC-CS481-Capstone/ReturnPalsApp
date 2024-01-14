package com.example.returnpals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.returnpals.composetools.ChoosePlanUI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import com.example.returnpals.composetools.IconManager
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        var icon = IconManager()
        setContent {
            Column() {
                icon.getTruckIcon()
                icon.getComputerMonitorIcon()
                icon.getQRcodeIcon()
                icon.getAmazonIcon()
                icon.getFileIcon()
                icon.getDoorIcon()
                icon.getPackageIcon()
            }
            ChoosePlanUI(
                onClickNext = {},
                onClickBack = {},
                onClickPlan = {}
            )
        }
    }
}

