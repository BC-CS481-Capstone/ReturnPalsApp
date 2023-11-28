package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.demo.returnpal.packageinfocomponent.PackageInfoComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageInfoComponent()
            createbuttonConfirm()
        }
    }
    @Composable
    fun createbuttonConfirm() {
        Button(onClick = {
            var x = Intent(this,ThankYouActivity::class.java)
            startActivity(x)
        }) {
            Text("HERE PUSH ME")
        }
    }
}

