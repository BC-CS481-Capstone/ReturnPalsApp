package com.example.returnpals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.compose.ReturnPalTheme
import com.example.returnpals.mainMenu.AppNavigation
import com.example.returnpals.services.Backend
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.net.URL

var email : String = ""



class MainActivity : ComponentActivity() {
    private var client =  OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        var url =  URL("http://localhost:4200/")
        with (url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
        }
        var requestbody = MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("","")
        var request = Request.Builder().url("http://localhost:4200/").build()
        var response = client.newCall(request).execute()
        response.isSuccessful



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