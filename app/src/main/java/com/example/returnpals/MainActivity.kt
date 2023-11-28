package com.example.returnpals

//import androidx.compose.material3.Text
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.returnpals.ui.theme.ReturnPalsTheme
import com.google.relay.compose.RelayContainer

class MainActivity : ComponentActivity() {

    private var isBronzeSelected: Boolean = false
    private var isSilverSelected: Boolean = false
    private var isGoldSelected: Boolean = false
    private var isPlatinumSelected: Boolean = false
    private val width = 393.dp
    private val height = 808.dp

    override fun onResume() {
        super.onResume()
        setContent {
            ReturnPalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChoosePlan(
                        width, height,
                        isBronzeSelected,
                        isSilverSelected,
                        isGoldSelected,
                        isPlatinumSelected,
                        this::onBackButtonTapped,
                        this::onNextButtonTapped,
                        this::onBronzePlanSelected,
                        this::onSilverPlanSelected,
                        this::onGoldPlanSelected,
                        this::onPlatinumPlanSelected
                    )
                }
            }
        }
    }

    private fun onBackButtonTapped() {
        // TODO: go to pickup details screen
    }

    private fun onNextButtonTapped() {
        // TODO: go to package info screen
    }

    private fun onBronzePlanSelected() {
        isBronzeSelected = true
    }

    private fun onSilverPlanSelected() {
        isSilverSelected = true
    }

    private fun onGoldPlanSelected() {
        isGoldSelected = true
    }

    private fun onPlatinumPlanSelected() {
        isPlatinumSelected = true
    }

}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    ChoosePlan(
        393.dp, 808.dp,
        isBronzeSelected = true,
        modifier = modifier
    )
}

@Preview(widthDp = 393, heightDp = 808, showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        RelayContainer {
            Greeting()
        }
    }
}