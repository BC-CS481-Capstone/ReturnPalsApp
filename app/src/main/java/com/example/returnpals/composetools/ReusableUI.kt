package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.R

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

//Adding get methods for default fonts and colors
fun getFontFamily(): GenericFontFamily {
    return FontFamily.SansSerif
}

//Adding Font Families as described here https://developer.android.com/jetpack/compose/text/fonts
val cairoFontFamily = FontFamily(
    Font(R.font.cairo_light, FontWeight.Light),
    Font(R.font.cairo, FontWeight.Normal),
    Font(R.font.cairo_medium, FontWeight.Medium),
    Font(R.font.cairo_bold, FontWeight.Bold),
    Font(R.font.cairo_black, FontWeight.Black),
    Font(R.font.cairo_extrabold, FontWeight.ExtraBold),
    Font(R.font.cairo_extralight, FontWeight.ExtraLight),
    Font(R.font.cairo_simibold, FontWeight.SemiBold)
)


/**
 * A Material3 scaffold containing a back button, next button, and a
 * top bar showing the user's progress in the "Schedule a Return" process.
 */
@Composable
fun ScheduleReturnScaffold(
    step: Int,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
    enabledNext: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            BackNextNavBar(
                onClickBack = onClickBack,
                onClickNext = onClickNext,
                enabledNext = enabledNext,
            ) },
        topBar = { ProgressBar(step = step) },
        content = content
    )
}


@Composable
fun BackNextNavBar(
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    enabledNext: Boolean = true
) {
    Row {
        ButtonManager.BackButton(
            modifier = Modifier
                .align(Alignment.Bottom)
                .scale(0.7f),
            onClick = onClickBack,
        )
        Spacer(Modifier.weight(1f))
        ButtonManager.NextButton(
            modifier = Modifier
                .align(Alignment.Bottom)
                .scale(0.7f),
            onClick = onClickNext,
            enabled = enabledNext,
        )
    }
}

/**
 * Draws a top bar showing the user's progress in the "Schedule a Return" process
 */
@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    step: Int
) {
    val stepMax = 5
    val lightBlue = Color(0, 138, 230)
    val darkBlue = Color(5,50,70)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(25.dp)
                .background(darkBlue)
        ) {
            for (i in 1..stepMax) {
                var stepModifier = Modifier.requiredSize(14.dp)
                if (i < step) {
                    stepModifier = stepModifier
                        .border(
                            width = 2.dp,
                            color = lightBlue,
                            shape = CircleShape
                        )
                        .background(
                            color = lightBlue,
                            shape = CircleShape
                        )
                } else if (i == step) {
                    stepModifier = stepModifier
                        .border(
                            width = 2.dp,
                            color = lightBlue,
                            shape = CircleShape)
                } else {
                    stepModifier = stepModifier
                        .border(
                            width = 1.dp,
                            color = lightBlue,
                            shape = CircleShape)
                }
                Box(stepModifier) // box that is actually a circle
                if (i != stepMax) {
                    // divider
                    Text(
                        text = "....",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = getFontFamily(),
                        color = lightBlue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.offset(x=0.dp,y=(-6).dp)
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(16.dp)
                .background(darkBlue)
        ) {
            ProgressBarText("Pickup Date")
            Box(Modifier.requiredWidth(9.dp))
            ProgressBarText("Pickup Details")
            Box(Modifier.requiredWidth(9.dp))
            ProgressBarText("Choose Plan")
            Box(Modifier.requiredWidth(9.dp))
            ProgressBarText("Package Details")
            Box(Modifier.requiredWidth(9.dp))
            ProgressBarText("Pay & Confirm")
        }
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true, widthDp = 250, heightDp = 400)
@Composable
private fun ReusableUIPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ScheduleReturnScaffold(
            step = 4,
            onClickNext = {},
            onClickBack = {},
            enabledNext = false
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Black,
                            shape = RectangleShape
                        ),
                ) {
                    Text(
                        text = "Hello World",
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "Guest",
                        color = Color(0, 138, 230),
                        modifier = Modifier.scale(0.65f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProgressBarText(text: String) {
    Text(
        text = text,
        fontSize = 5.sp,
        fontWeight = FontWeight(400),
        fontFamily = getFontFamily(),
        color = Color.LightGray,
        softWrap = true,
        lineHeight = 6.sp,
        overflow = TextOverflow.Visible,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .requiredWidth(24.dp)
    )
}
