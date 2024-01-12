package com.example.returnpals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
    onClickMethod: (PickupMethod) -> Unit,
    selectedMethod: PickupMethod = PickupMethod.NONE
) {
    Box(
        modifier = modifier
            .background(Color(210,240,245))
    ) {
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.DOORSTEP) },
            isSelected = selectedMethod == PickupMethod.HANDOFF,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(0.0.dp, 120.0.dp)
        ) {
            DoorstepDescription()
        }
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.HANDOFF) },
            isSelected = selectedMethod == PickupMethod.DOORSTEP,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(0.0.dp, (-120.0).dp)
        ) {
            HandOffDescription()
        }
        ProgressBar(step = 4)
        BackButton(
            onClick = onClickBack,
            modifier = Modifier
                .offset(8.dp,(-8).dp)
        )
        if (selectedMethod != PickupMethod.NONE) {
            NextButton(
                onClick = onClickNext,
                modifier = Modifier
                    .offset((-8).dp,(-8).dp)
            )
        }
    }
}

@Preview(widthDp = 393, heightDp = 808)
@Composable
private fun PickupMethodPreview() {
    MaterialTheme {
        PickupMethodUI(
            onClickBack = {},
            onClickNext = {},
            onClickMethod = {},
            selectedMethod = PickupMethod.DOORSTEP,
        )
    }
}

@Composable
private fun PickupMethodButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    content: @Composable() (RowScope.() -> Unit)
) {
    var modifier = modifier
        .requiredSize(220.dp, 200.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
        )

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

    Button(
        modifier = modifier,
        onClick = onClick,
        content = content,
    )
}

@Composable
private fun HandOffDescription(
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.pickup_details_method_vector1),
        modifier = Modifier
            .offset(0.dp, 20.dp)
    )
    Text(
        text = buildAnnotatedString {
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
        modifier = Modifier
            .offset(0.dp, 65.dp)
            .requiredWidth(180.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun DoorstepDescription(
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.pickup_details_method_vector7),
        modifier = Modifier
            .offset(0.dp, 20.dp)
    )
    Text(
        text = buildAnnotatedString {
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
        modifier = Modifier
            .offset(0.dp, 65.dp)
            .requiredWidth(180.dp),
        textAlign = TextAlign.Center
    )
}