package com.demo.returnpal


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.returnpal.thankyoucomponent.ThankYouComponent

class ThankYouActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThankYouComponent(dashboardButton = {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            })
        }
    }
}
