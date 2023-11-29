package com.example.returnpals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.chooseplan.cairo
import com.google.relay.compose.EmptyPainter
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

enum class PickupMethod {
    NONE, HANDOFF, DOORSTEP
}

@Composable
fun PickupMethodUI(
    width: Dp, height: Dp,
    selected: PickupMethod = PickupMethod.NONE,
    onOptionSelected: (PickupMethod) -> Unit = {},
    onBackButtonTapped: () -> Unit = {},
    onNextButtonTapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color(210,240,245))
    ) {
        PickupMethodOption(
            onTap = { onOptionSelected(PickupMethod.DOORSTEP) },
            description = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(700),
                    )
                ) {
                    append("Direct Handoff\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(500)
                    )
                ) {
                    append("Hand the package directly to our specialist at your door\n")
                }
            },
            vector = painterResource(R.drawable.pickup_details_method_vector7),
            isSelected = selected == PickupMethod.HANDOFF,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(0.0.dp, 120.0.dp)
        )
        PickupMethodOption(
            onTap = { onOptionSelected(PickupMethod.HANDOFF) },
            description = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(700),
                    )
                ) {
                    append("Leave on Doorstep\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(500)
                    )
                ) {
                    append("Place items outside your door ahead of your pick up window\n")
                }
            },
            vector = painterResource(R.drawable.pickup_details_method_vector1),
            isSelected = selected == PickupMethod.DOORSTEP,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(0.0.dp, (-120.0).dp)
        )
        NextButton(
            onClick = onNextButtonTapped,
            hide = selected == PickupMethod.NONE,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(
                    x = width - 100.0.dp,
                    y = height - 50.0.dp
                )
        )
        BackButton(
            onClick = onBackButtonTapped,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(
                    x = 20.0.dp,
                    y = height - 50.0.dp
                )
        )
        ProgressBar(
            width = width,
            modifier = Modifier
                .align(Alignment.TopStart)
        )
    }
}

@Preview(widthDp = 393, heightDp = 808)
@Composable
private fun PickupMethodUI() {
    MaterialTheme {
        PickupMethodUI(
            selected = PickupMethod.DOORSTEP,
            width = 393.dp,
            height = 808.dp
        )
    }
}

@Composable
fun PickupMethodOption(
    onTap: () -> Unit,
    description: AnnotatedString,
    vector: Painter = EmptyPainter(),
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    var modifier = modifier
        .requiredSize(220.dp, 200.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
        )
        .tappable(onTap)

    if (isSelected) {
        modifier = modifier.border(
            width = 6.dp,
            color = Color(0,180,250),
            shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
        )
    } else {
        modifier = modifier.border(
            width = 2.dp,
            color = Color.Black,
            shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
        )
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        RelayVector(
            vector = vector,
            modifier = Modifier
                .offset(0.dp, 20.dp)
        )
        Text(
            text = description,
            modifier = Modifier
                .offset(0.dp,65.dp)
                .requiredWidth(180.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProgressBar(
    width: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .requiredSize(width, 74.dp)
            .background(Color(5,50,70))
    ) {

    }
}
