package com.example.returnpals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.Dp
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

@Composable
fun ChoosePlan(
    width: Dp,
    height: Dp,
    isBronzeSelected: Boolean = false,
    isSilverSelected: Boolean = false,
    isGoldSelected: Boolean = false,
    isPlatinumSelected: Boolean = false,
    onBackButtonTapped: () -> Unit = {},
    onNextButtonTapped: () -> Unit = {},
    onBronzePlanButtonTapped: () -> Unit = {},
    onSilverPlanButtonTapped: () -> Unit = {},
    onGoldPlanButtonTapped: () -> Unit = {},
    onPlatinumPlanButtonTapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        Background(Modifier
            .requiredWidth(width)
            .requiredHeight(height)
            .scale(2.0F * width.value / 360.0F, 2.0F * height.value / 800.0F)
        )
        SilverPlan(
            onTap = onSilverPlanButtonTapped,
            isSelected = isSilverSelected,
            modifier = Modifier
                .width(width)
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 411.0.dp
                    )
                )
        )
        PlatinumPlan(
            onTap = onPlatinumPlanButtonTapped,
            isSelected = isPlatinumSelected,
            modifier = Modifier
                .width(width)
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 96.0.dp
                    )
                )
        )
        GoldPlan(
            onTap = onGoldPlanButtonTapped,
            isSelected = isGoldSelected,
            modifier = Modifier
                .width(width)
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 248.0.dp
                    )
                )
        )
        BronzePlan(
            onTap = onBronzePlanButtonTapped,
            isSelected = isBronzeSelected,
            modifier = Modifier
                .width(width)
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 564.0.dp
                    )
                )
        )
        BackButton(
            onClick = onBackButtonTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 20.0.dp,
                    y = height - 50.0.dp
                )
            )
        )
        NextButton(
            onClick = onNextButtonTapped,
            hide = !(isBronzeSelected || isSilverSelected || isGoldSelected || isPlatinumSelected),
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = width - 100.0.dp,
                    y = height - 50.0.dp
                )
            )
        )
        ProgressBar {
            Rectangle56(
                Modifier
                .requiredWidth(width)
                .scale(2.0F * width.value / 360.0F, 1.0F)
            )
            PayConfirmCircle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 130.0.dp,
                        y = (-8.0).dp
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
            PackageDetailsCircle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 65.0.dp,
                        y = (-8.0).dp
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
            ChoosePlanCircle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = (-8.0).dp
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
            PickupDateCircle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-130.0).dp,
                        y = (-8.0).dp
                    )
                )
            )
            PickUpDateVector(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-130.0).dp + 2.0.dp,
                        y = (-8.0).dp + 2.0.dp
                    )
                )
            )
            ChoosePlanText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 20.0.dp
                    )
                )
            )
            PackageDetailsText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 65.0.dp,
                        y = 20.0.dp
                    )
                )
            )
            PayConfirmText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 130.0.dp,
                        y = 20.0.dp
                    )
                )
            )
            PickupDetailsCircle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-65.0).dp,
                        y = (-8.0).dp
                    )
                )
            )
            PickupDetailsVector(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-65.0).dp + 2.0.dp,
                        y = (-8.0).dp + 2.0.dp
                    )
                )
            )
            PickupDateText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-130.0).dp,
                        y = 20.0.dp
                    )
                )
            )
            PickupDetailsText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = (-65.0).dp,
                        y = 20.0.dp
                    )
                )
            )
        }
    }
}

//@Preview(widthDp = 360, heightDp = 800)
@Preview(widthDp = 393, heightDp = 808)
@Composable
private fun ChoosePlanPreview() {
    MaterialTheme {
        RelayContainer {
            ChoosePlan(
                isSilverSelected = true,
                width = 393.dp,
                height = 808.dp
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_background),
        modifier = modifier
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
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun SilverPlan(
    onTap: () -> Unit = {},
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            isSelected = isSelected,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        SilverPlanText(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
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
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 0.625.em,
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun PlatinumPlan(
    onTap: () -> Unit = {},
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            isSelected = isSelected,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        PlatinumPlanText(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
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
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun GoldPlan(
    onTap: () -> Unit = {},
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            isSelected = isSelected,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        GoldPlanText(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
}

@Composable
fun PlanButton(
    onTap: () -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    var modifier = modifier
        .size(200.dp, 110.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
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

    Box(modifier)
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
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun BronzePlan(
    onTap: () -> Unit = {},
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            isSelected = isSelected,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        BronzePlanText(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
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
        modifier = modifier
    ) {
        Text(
            text = "Back",
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 22.5.dp,
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
fun NextButton(
    onClick: () -> Unit,
    hide: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (hide)
        return
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Box (Modifier
            .size(85.dp, 40.dp)
            .background(
                color = Color(
                    alpha = 255,
                    red = 0,
                    green = 138,
                    blue = 230
                ),
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
            .tappable(onClick)
        )
        Text(
            text = "Next",
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 18.5.dp,
                    y = 0.0.dp
                )
            ),
            color = Color.White,
            fontSize = 20.0.sp,
            fontWeight = FontWeight(700),
            fontFamily = cairo,
            textAlign = TextAlign.Right,
        )
    }
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_rectangle_56),
        modifier = modifier.requiredHeight(74.dp)
    )
}

@Composable
fun PayConfirmCircle(modifier: Modifier = Modifier) {
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
fun PackageDetailsCircle(modifier: Modifier = Modifier) {
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
fun ChoosePlanCircle(modifier: Modifier = Modifier) {
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
fun PickupDateCircle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_14),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun PickUpDateVector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector1),
        modifier = modifier
            .requiredWidth(18.0.dp)
            .requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun ChoosePlanText(modifier: Modifier = Modifier) {
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
fun PackageDetailsText(modifier: Modifier = Modifier) {
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
fun PayConfirmText(modifier: Modifier = Modifier) {
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
fun PickupDetailsCircle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_15),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun PickupDetailsVector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector2),
        modifier = modifier
            .requiredWidth(18.0.dp)
            .requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun PickupDateText(modifier: Modifier = Modifier) {
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
fun PickupDetailsText(modifier: Modifier = Modifier) {
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
