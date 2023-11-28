package com.demo.returnpal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.demo.returnpal.confirmpickupcomponent.ConfirmPickupComponent

class ConfirmPickupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfirmPickupComponent(nextButton = {
                var x = Intent(this,ThankYouActivity::class.java)
                startActivity(x)
            })
        }
    }

}

