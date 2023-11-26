package com.example.returnpals.chooseplan

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.returnpals.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

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
            SilverPlanButton(
                onSilverPlanButtonTapped = onSilverPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            Silver2099PerMonthBilledMonthly(
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
            PlatinumPlanButton(
                onPlatinumPlanButtonTapped = onPlatinumPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 10.0.dp
                    )
                )
            )
            Platinum1479PerMonthBilledYearly(
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
            GoldPlanButton(
                onGoldPlanButtonTapped = onGoldPlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 9.0.dp
                    )
                )
            )
            Gold1899PerMonthBilledQuarterly(
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
            BronzePlanButton(
                onBronzePlanButtonTapped = onBronzePlanButtonTapped,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 50.0.dp,
                        y = 8.0.dp
                    )
                )
            )
            Bronze1099399PerAdditionalBoxBilledOnce(
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
            onBackButtonTapped = onBackButtonTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 15.0.dp,
                    y = 728.0.dp
                )
            )
        ) {
            Back(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 22.479248046875.dp,
                        y = 0.0.dp
                    )
                )
            )
            ArrowRight(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -8.881784197001252e-16.dp,
                        y = 4.0909423828125.dp
                    )
                )
            ) {
                Vector(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
        }
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
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun SilverPlanButton(
    onSilverPlanButtonTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_silver_plan_button),
        modifier = modifier.tappable(onTap = onSilverPlanButtonTapped).requiredWidth(200.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Silver2099PerMonthBilledMonthly(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 0,
                        red = 0,
                        green = 0,
                        blue = 0
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("Silver\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 30.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("\$20.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append("per month\n\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append("billed monthly")
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
        modifier = modifier.requiredWidth(301.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun PlatinumPlanButton(
    onPlatinumPlanButtonTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_platinum_plan_button),
        modifier = modifier.tappable(onTap = onPlatinumPlanButtonTapped).requiredWidth(200.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Platinum1479PerMonthBilledYearly(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 0,
                        red = 0,
                        green = 0,
                        blue = 0
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("Platinum\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 30.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("\$14.79\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append("per month\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append(" \n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append("billed yearly")
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
        modifier = modifier.requiredWidth(301.0.dp).requiredHeight(95.0.dp)
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
        modifier = modifier.requiredWidth(301.0.dp).requiredHeight(129.0.dp)
    )
}

@Composable
fun GoldPlanButton(
    onGoldPlanButtonTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_gold_plan_button),
        modifier = modifier.tappable(onTap = onGoldPlanButtonTapped).requiredWidth(200.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Gold1899PerMonthBilledQuarterly(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 0,
                        red = 0,
                        green = 0,
                        blue = 0
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("Gold\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 30.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("\$18.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append("per month\n\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append("billed quarterly")
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
        modifier = modifier.requiredWidth(301.0.dp).requiredHeight(109.0.dp)
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
        modifier = modifier.requiredWidth(301.0.dp).requiredHeight(120.0.dp)
    )
}

@Composable
fun BronzePlanButton(
    onBronzePlanButtonTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_bronze_plan_button),
        modifier = modifier.tappable(onTap = onBronzePlanButtonTapped).requiredWidth(200.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Bronze1099399PerAdditionalBoxBilledOnce(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 0,
                        red = 0,
                        green = 0,
                        blue = 0
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("Bronze\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 30.0.sp,
                    fontWeight = FontWeight(800.0.toInt())
                )
            ) {
                append("\$10.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 10.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append(" \n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append("+\$3.99 per additional box\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append(" \n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(300.0.toInt())
                )
            ) {
                append("billed once")
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
fun Back(modifier: Modifier = Modifier) {
    RelayText(
        content = "Back",
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.3660001118977865.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(57.520751953125.dp).requiredHeight(12.727294921875.dp)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 1.9833984375.dp,
                top = 2.04541015625.dp,
                end = 1.9834918975830078.dp,
                bottom = 2.045443534851074.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun ArrowRight(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.graphicsLayer(rotationZ = 180.0f).requiredWidth(15.867769241333008.dp).requiredHeight(10.909090995788574.dp)
    )
}

@Composable
fun BackButton(
    onBackButtonTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onBackButtonTapped).requiredWidth(80.0.dp).requiredHeight(15.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_rectangle_56),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(73.68646240234375.dp)
    )
}

@Composable
fun Ellipse18(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_18),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Line6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_6),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse17(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_17),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Line5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_5),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse16(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_16),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Line4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_4),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Line3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_line_3),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse14(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_14),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Vector1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector1),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
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
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(20.31353759765625.dp).wrapContentHeight(
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
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(20.31353759765625.dp).wrapContentHeight(
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
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(20.31353759765625.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Ellipse15(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_ellipse_15),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Vector2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_plan_vector2),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
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
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(20.30999755859375.dp).wrapContentHeight(
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
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(20.30999755859375.dp).wrapContentHeight(
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
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(73.68646240234375.dp)
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
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
