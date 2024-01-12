package com.example.returnpals

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    private var selectedPlan: Plan = Plan.NONE

    override fun onResume() {
        super.onResume()
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ChoosePlanUI(
                    selectedPlan = selectedPlan,
                    onClickPlan = this::onClickPlan,
                    onClickNext =  this::onClickNext,
                    onClickBack = this::onClickBack
                )
            }
        }
    }

    private fun onClickBack() {
        // TODO: go to pickup details screen
    }

    private fun onClickNext() {
        // TODO: go to package info screen
    }

    private fun onClickPlan(plan: Plan) {
        selectedPlan = plan
    }

}

@Preview(widthDp = 393, heightDp = 808, showBackground = true)
@Composable
private fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ChoosePlanUI(
            selectedPlan = Plan.SILVER,
            onClickPlan = {},
            onClickNext =  {},
            onClickBack = {}
        )
    }
}