package com.example.returnpals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.returnpals.chooseplan.avenirNext
import com.example.returnpals.chooseplan.cairo
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

/**
 * This composable was generated from the UI Package 'choose_plan'.
 * Generated code; do not edit directly
 */
@Composable
fun ChoosePlan(
    modifier: Modifier = Modifier,
    onBackButtonTapped: () -> Unit = {},
    onSilverPlanButtonTapped: () -> Unit = {},
    onPlatinumPlanButtonTapped: () -> Unit = {},
    onGoldPlanButtonTapped: () -> Unit = {},
    onBronzePlanButtonTapped: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        Background()
        SilverPlan(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 31.0.dp,
                    y = 411.0.dp
                )
            )
        ) {
            PlanButton(
                onTap = onSilverPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            SilverPlanText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 4.0.dp
                    )
                )
            )
        }
        PlatinumPlan(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 29.0.dp,
                    y = 96.0.dp
                )
            )
        ) {
            PlanButton(
                onTap = onPlatinumPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 10.0.dp
                    )
                )
            )
            PlatinumPlanText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 15.0.dp
                    )
                )
            )
        }
        GoldPlan(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 248.0.dp
                )
            )
        ) {
            PlanButton(
                onTap = onGoldPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 9.0.dp
                    )
                )
            )
            GoldPlanText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 10.0.dp
                    )
                )
            )
        }
        BronzePlan(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 564.0.dp
                )
            )
        ) {
            PlanButton(
                onTap = onBronzePlanButtonTapped,
                isSelected = true,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 50.0.dp,
                        y = 8.0.dp
                    )
                )
            )
            BronzePlanText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 1.0.dp,
                        y = 10.0.dp
                    )
                )
            )
        }
        BackButton(
            onClick = onBackButtonTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 20.0.dp,
                    y = 750.0.dp
                )
            )
        )
        ProgressBar {
            Rectangle56()
            Ellipse18(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 316.5.dp,
                        y = 17.5.dp
                    )
                )
            )
            Line6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 267.0.dp,
                        y = 30.0.dp
                    )
                )
            )
            Ellipse17(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 241.5.dp,
                        y = 17.5.dp
                    )
                )
            )
            Line5(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 192.0.dp,
                        y = 30.0.dp
                    )
                )
            )
            Ellipse16(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 165.5.dp,
                        y = 16.5.dp
                    )
                )
            )
            Line4(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 117.0.dp,
                        y = 30.0.dp
                    )
                )
            )
            Line3(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 42.0.dp,
                        y = 29.0.dp
                    )
                )
            )
            Ellipse14(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 15.5.dp,
                        y = 16.5.dp
                    )
                )
            )
            Vector1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 21.0.dp,
                        y = 25.0.dp
                    )
                )
            )
            ChoosePlan(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 152.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PackageDetails(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 227.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PayConfirm(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 302.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            Ellipse15(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 90.5.dp,
                        y = 16.5.dp
                    )
                )
            )
            Vector2(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 96.0.dp,
                        y = 24.0.dp
                    )
                )
            )
            PickupDate(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 2.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PickupDetails(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 77.0.dp,
                        y = 48.0.dp
                    )
                )
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ChoosePlanPreview() {
    MaterialTheme {
        RelayContainer {
            ChoosePlan(
                onBackButtonTapped = {},
                onSilverPlanButtonTapped = {},
                onPlatinumPlanButtonTapped = {},
                onGoldPlanButtonTapped = {},
                onBronzePlanButtonTapped = {},
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_background),
        modifier = modifier
            .requiredWidth(360.0.dp)
            .requiredHeight(800.0.dp)
    )
}

@Composable
fun SilverPlanText(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 150,
                        green = 170,
                        blue = 170
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("SILVER\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$20.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled monthly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 0.625.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(301.0.dp)
    )
}

@Composable
fun SilverPlan(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .requiredWidth(301.0.dp)
            .requiredHeight(110.0.dp)
    )
}

@Composable
fun PlatinumPlanText(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 125,
                        green = 175,
                        blue = 175
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("PLATINUM\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$14.79\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled yearly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 0.625.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(301.0.dp)
            .requiredHeight(95.0.dp)
    )
}

@Composable
fun PlatinumPlan(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .requiredWidth(301.0.dp)
            .requiredHeight(129.0.dp)
    )
}

@Composable
fun GoldPlanText(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 230,
                        green = 190,
                        blue = 100
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("GOLD\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$18.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled quarterly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 0.625.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(301.0.dp)
            .requiredHeight(109.0.dp)
    )
}

@Composable
fun GoldPlan(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .requiredWidth(301.0.dp)
            .requiredHeight(120.0.dp)
    )
}

@Composable
fun PlanButton(
    onTap: () -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (isSelected) {
        Box(modifier=modifier
            .size(width=200.dp, height=110.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
            .border(
                width = 6.dp,
                color = Color(0,180,250),
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
            .tappable(onTap)
        )
    } else {
        Box(modifier=modifier
            .size(width=200.dp, height=110.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
            .tappable(onTap)
        )
    }
}

@Composable
fun BronzePlanText(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 200,
                        green = 150,
                        blue = 100
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("BRONZE\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$10.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("+\$3.99 per additional box\nbilled once")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 0.625.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(301.0.dp)
    )
}

@Composable
fun BronzePlan(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(300.0.dp).requiredHeight(120.0.dp)
    )
}

@Composable
fun Arrow(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector),
        modifier = modifier
    )
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onClick)
    )
}

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = "Back",
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 22.479248046875.dp,
                    y = 0.0.dp
                )
            ),
            color = Color(
                alpha = 255,
                red = 0,
                green = 138,
                blue = 230
            ),
            fontSize = 20.0.sp,
            fontWeight = FontWeight(700),
            fontFamily = cairo,
            textAlign = TextAlign.Right,
        )
        Arrow(
            modifier = Modifier
                .boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = -15.dp,
                        y = 0.dp
                    )
                )
                .scale(1.5F)
        )
    }
}


@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_rectangle_56),
        modifier = modifier
            .requiredWidth(360.0.dp)
            .requiredHeight(73.68646240234375.dp)
    )
}

@Composable
fun Ellipse18(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_18),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_6),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse17(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_17),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_5),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse16(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_16),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_4),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Line3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_3),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse14(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_14),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Vector1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector1),
        modifier = modifier
            .requiredWidth(18.0.dp)
            .requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun ChoosePlan(modifier: Modifier = Modifier) {
    RelayText(
        content = "Choose Plan",
        fontSize = 8.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.31353759765625.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun PackageDetails(modifier: Modifier = Modifier) {
    RelayText(
        content = "Package Details",
        fontSize = 8.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.31353759765625.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun PayConfirm(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pay & Confirm",
        fontSize = 8.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.31353759765625.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Ellipse15(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_15),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Vector2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector2),
        modifier = modifier
            .requiredWidth(18.0.dp)
            .requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun PickupDate(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Date",
        fontSize = 8.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.30999755859375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun PickupDetails(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Details",
        fontSize = 8.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.30999755859375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(360.0.dp)
            .requiredHeight(73.68646240234375.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}
