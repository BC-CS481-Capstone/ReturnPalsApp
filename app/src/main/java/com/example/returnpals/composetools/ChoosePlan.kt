package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: ChoosePlanGuestUI

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

enum class Plan {
    NONE, BRONZE, SILVER, GOLD, PLATINUM
}

@Composable
fun ChoosePlanUI(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onClickPlan: (Plan) -> Unit,
    selected: Plan = Plan.NONE,
    guest: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(height=50.dp)
        BronzePlanButton(
            onClick = { onClickPlan(Plan.BRONZE) },
            selected = selected == Plan.BRONZE
        )
        Spacer(height=10.dp)
        SilverPlanButton(
            onClick = { onClickPlan(Plan.SILVER) },
            selected = selected == Plan.SILVER,
            enabled = !guest
        )
        Spacer(height=10.dp)
        GoldPlanButton(
            onClick = { onClickPlan(Plan.GOLD) },
            selected = selected == Plan.GOLD,
            enabled = !guest
        )
        Spacer(height=10.dp)
        PlatinumPlanButton(
            onClick = { onClickPlan(Plan.PLATINUM) },
            selected = selected == Plan.PLATINUM,
            enabled = !guest
        )
    }
    ScheduleReturnUI(
        step = 3,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enableNext = selected != Plan.NONE
    )
}

@Composable
fun BronzePlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        BronzePlanText()
    }
}

@Composable
fun SilverPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        SilverPlanText()
    }
}

@Composable
fun GoldPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        GoldPlanText()
    }
}

@Composable
fun PlatinumPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        PlatinumPlanText()
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true, widthDp = 250, heightDp = 400)
@Composable
private fun ChoosePlanPreview() {
    ChoosePlanUI(
        onClickNext = {},
        onClickBack = {},
        onClickPlan = {},
        selected = Plan.BRONZE,
    )
}

@Composable
private fun Spacer(
    width: Dp = 0.dp,
    height: Dp = 0.dp
) {
    Box(
        modifier = Modifier
            .requiredSize(width, height)
    ) {

    }
}

@Composable
private fun PlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true,
    content: @Composable() (BoxScope.() -> Unit)
) {
    var modifier = modifier
        .requiredSize(135.dp, 65.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
        )

    if (selected) {
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
    ButtonManager.Button(
        onClick = onClick,
        enabled = enabled,
        color = Color.White,
        contentAlignment = Alignment.CenterStart,
        modifier = modifier,
        content = content
    )
}

@Composable
private fun SilverPlanText(modifier: Modifier = Modifier) {
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "SILVER",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(150, 170, 170),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$20.99")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled monthly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun PlatinumPlanText(modifier: Modifier = Modifier) {
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "PLATINUM",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(125, 175, 175),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$14.79")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled yearly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun GoldPlanText(modifier: Modifier = Modifier) {
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "GOLD",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(red = 230, green = 190, blue = 100),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$18.99")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled quarterly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun BronzePlanText(modifier: Modifier = Modifier) {
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "Bronze",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(200, 150, 100),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$10.99\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("+\$3.99 per additional box")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

/*
@Composable
private fun GuestSignUpButton(
    onTap: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        RelayText(
            content = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color.Blue
                    )
                ) {
                    append("Sign up\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 18.0.sp,
                        fontWeight = FontWeight(500)
                    )
                ) {
                    append("for more plan options")
                }
            },
            fontSize = 32.0.sp,
            fontFamily = avenirNext,
            height = 0.625.em,
            fontWeight = FontWeight(700),
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
}
*/