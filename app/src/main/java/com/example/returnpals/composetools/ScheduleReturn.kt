package com.example.returnpals.composetools

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ReturnPalTheme

/**
 * UI functionality and composables specific to the "Schedule a Return" process go here.
 */

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

/**
 * A [Scaffold] containing a back button, next button, and a
 * top bar showing the user's progress in the "Schedule a Return" process.
 */
@Composable
fun ScheduleReturnScaffold(
    step: Int,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
    enabledNext: Boolean = true,
    nextButtonText: String = "Next",
    backButtonText: String = "Back",
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                onClickBack = onClickBack,
                onClickNext = onClickNext,
                enabledNext = enabledNext,
                nextButtonText = nextButtonText,
                backButtonText = backButtonText
            ) },
        topBar = { ScheduleReturnProgressBar(step = step) },
        content = content
    )
}

@Composable
fun ScheduleReturnProgressBar(
    modifier: Modifier = Modifier,
    step: Int = 0,
) {
    ProgressBar(
        step = step,
        stepRange = 1..5,
        stepNames = mapOf(
            1 to "Pickup Date",
            2 to "Pickup Details",
            3 to "Pricing Plan",
            4 to "Package Details",
            5 to "Pay & Confirm"
        ),
        modifier = modifier
    )
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun ScheduleReturnScaffoldPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ScheduleReturnScaffold(
                step = 4,
                onClickNext = {},
                onClickBack = {},
                enabledNext = false,
                backButtonText = "Hello",
                nextButtonText = "World"
            ) {}
        }
    }
}
