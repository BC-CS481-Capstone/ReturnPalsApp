package com.returnpal.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.returnpal.compose.ReturnPalTheme
import com.returnpal.androidapp.compose.nav.AppNavigation
import com.returnpal.androidapp.services.Backend

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Backend.accessEmail()
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    ReturnPalTheme {
        AppNavigation(navController = navController)
    }
}