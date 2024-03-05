package com.example.returnpals.composetools

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ReturnPalTheme
import com.example.returnpals.R

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

//Adding get methods for default fonts and colors
fun getFontFamily(): GenericFontFamily {
    return FontFamily.SansSerif
}
fun getBlueIconColor():Color {
    return Color(0xFF008BE6)
}
fun getBackGroundColor():Color {
    return Color(0xFFE1F6FF)
}
@Composable
fun getConfig(): Configuration {
    return LocalConfiguration.current
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

@Composable
fun NavigationBar(
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
    enabledNext: Boolean = true,
    nextButtonText: String = "Next",
    backButtonText: String = "Back",
) {
    Row(
        modifier = modifier.padding(15.dp,10.dp)
    ) {
        ButtonManager.BackButton(
            text = backButtonText,
            onClick = onClickBack,
            modifier = Modifier
                .align(Alignment.Bottom)
        )
        Spacer(Modifier.weight(1f))
        ButtonManager.NextButton(
            text = nextButtonText,
            onClick = onClickNext,
            enabled = enabledNext,
            modifier = Modifier
                .align(Alignment.Bottom)
        )
    }
}

@Composable
fun ProgressBar(
    step: Int,
    stepRange: IntRange,
    modifier: Modifier = Modifier,
    scale: Float = 1.0f,
    stepNames: Map<Int, String> = mapOf(),
) {
    val dotModifier = Modifier
        .requiredSize((6.0f * scale).dp)
        .offset(0.dp, (6.0f * scale).dp)
        .border(
            width = 1.dp,
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
    val completedDotModifier = dotModifier
        .background(
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
    val stepModifier = Modifier
        .requiredSize((18.0f * scale).dp)
        .border(
            width = 2.dp,
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
    val completedStepModifier = stepModifier
        .border(
            width = 5.dp,
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
        .background(
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
    val selectedStepModifier = stepModifier
        .border(
            width = 5.dp,
            color = ReturnPalTheme.colorScheme.primary,
            shape = CircleShape
        )
    Column(
        modifier = Modifier
            .background(ReturnPalTheme.colorScheme.onPrimaryContainer)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            for (i in stepRange) {
                Row {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box( // box that is actually a circle
                            if (i < step) completedStepModifier
                            else if (i == step) selectedStepModifier
                            else stepModifier
                        )
                        stepNames[i]?.let {
                            Spacer(Modifier.height(4.dp))
                            ProgressBarText(
                                text = it,
                                fontSize = (scale * 10f).sp,
                                lineHeight = (scale * 12f).sp,
                                modifier = Modifier.requiredWidth((42.0f * scale).dp)
                            )
                        }
                    }
                    if (i != stepRange.last) {
                        if (i < step) {
                            Box(completedDotModifier)
                            Spacer(Modifier.width((3.0f * scale).dp))
                            Box(completedDotModifier)
                            Spacer(Modifier.width((3.0f * scale).dp))
                            Box(completedDotModifier)
                        } else {
                            Box(dotModifier)
                            Spacer(Modifier.width((3.0f * scale).dp))
                            Box(dotModifier)
                            Spacer(Modifier.width((3.0f * scale).dp))
                            Box(dotModifier)
                        }
                    }
                }
            }
        }
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(heightDp = 100)
@Composable
private fun ProgressBarPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ProgressBar(
                step = 2,
                stepRange = 1..4,
                stepNames = mapOf(
                    1 to "Step 1",
                    2 to "Step 2",
                    3 to "Step 3",
                    4 to "Step 400,042"),
                scale = 1.5f
            )
        }
    }
}

@Preview(heightDp = 100)
@Composable
private fun NavigationBarPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            NavigationBar(
                onClickNext = {},
                onClickBack = {},
                enabledNext = false
            )
        }
    }
}

@Composable
private fun ProgressBarText(
    text: String,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight(400),
        fontFamily = getFontFamily(),
        color = ReturnPalTheme.colorScheme.inversePrimary,
        softWrap = true,
        lineHeight = lineHeight,
        overflow = TextOverflow.Visible,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}
