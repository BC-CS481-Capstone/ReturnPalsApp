package com.example.returnpals.composetools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.R

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color = Color(0, 138, 230),
    border: BorderStroke? = null,
    shape: Shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp),
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable() (BoxScope.() -> Unit)
) {
    var modifier = modifier
        .clickable(enabled = true, onClick = onClick)
        .background(
            color = color,
            shape = shape
        )

    if (border != null) {
        modifier = modifier
            .border(
                border = border,
                shape = shape
            )
    }

    Box(
        modifier = modifier,
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "Next"
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color(0, 138, 230),
                    shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
                )
                .padding(12.dp, 6.dp)
                .clickable(enabled = true, onClick = onClick)
        )
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "Back"
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily.SansSerif,
            color = Color(0, 138, 230),
            modifier = Modifier
                .clickable(enabled = true, onClick = onClick)
                .padding(12.dp, 6.dp)
        )
    }
}

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
                        fontFamily = FontFamily.SansSerif,
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

@Preview(showBackground = true, widthDp = 250, heightDp = 400)
@Composable
private fun ReusableUIPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .requiredSize(85.dp, 30.dp),
            color = Color.Black,
            shape = RectangleShape,
            onClick = {},
        ) {
            Text(
                text = "Hello World",
                color = Color.White
            )
        }
        ProgressBar(step = 4)
        NextButton(
            onClick = { println("Click!") },
            modifier = Modifier.offset((-8).dp,(-8).dp)
        )
        BackButton(
            onClick = { println("Click!") },
            modifier = Modifier.offset((8).dp,(-8).dp)
        )
    }
}

@Composable
private fun ProgressBarText(text: String) {
    Text(
        text = text,
        fontSize = 5.sp,
        fontWeight = FontWeight(400),
        fontFamily = FontFamily.SansSerif,
        color = Color.LightGray,
        softWrap = true,
        lineHeight = 6.sp,
        overflow = TextOverflow.Visible,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .requiredWidth(24.dp)
    )
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