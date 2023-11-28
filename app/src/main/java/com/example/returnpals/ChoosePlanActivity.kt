package com.example.returnpals

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.returnpals.ui.theme.ReturnPalsTheme

class ChoosePlanActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReturnPalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChoosePlan(
                        modifier = Modifier,
                        onBackButtonTapped = {},
                        onSilverPlanButtonTapped = {},
                        onPlatinumPlanButtonTapped = {},
                        onGoldPlanButtonTapped = {},
                        onBronzePlanButtonTapped = {},
                    )
                }
            }
        }
    }
}