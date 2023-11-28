package com.demo.returnpal.thankyoucomponent

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.demo.returnpal.R
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

/**
 * This composable was generated from the UI Package 'thank_you_component'.
 * Generated code; do not edit directly
 */
@Composable
fun ThankYouComponent(
    modifier: Modifier = Modifier,
    dashboardButton: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        AndroidLarge3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            Background()
            ProgressBar(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            ) {
                ProgressBarSynth {
                    Rectangle56()
                }
                CheckCircle(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 3.0.dp,
                            y = 15.0.dp
                        )
                    )
                ) {
                    Line3(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = -2.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Ellipse20(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -1.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    StatusField(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = 13.344970703125.dp
                            )
                        )
                    )
                }
                CheckCircle1(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 78.0.dp,
                            y = 15.0.dp
                        )
                    )
                ) {
                    Line4(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = -2.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Ellipse21(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -1.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    StatusField1(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = 13.344970703125.dp
                            )
                        )
                    )
                }
                CheckCircle2(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 153.0.dp,
                            y = 15.0.dp
                        )
                    )
                ) {
                    Line5(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = -2.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Ellipse22(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -1.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    StatusField2(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = 13.344970703125.dp
                            )
                        )
                    )
                }
                CheckCircle3(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 228.0.dp,
                            y = 15.0.dp
                        )
                    )
                ) {
                    Line6(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = -2.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Ellipse23(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -1.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    StatusField3(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = 13.344970703125.dp
                            )
                        )
                    )
                }
                CheckCircle4(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 303.0.dp,
                            y = 15.0.dp
                        )
                    )
                ) {
                    Ellipse24(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -1.0.dp,
                                y = -1.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    PayConfirm(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = 13.344970703125.dp
                            )
                        )
                    )
                }
            }
            DashboardButton(
                dashboardButton = dashboardButton,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = -25.0.dp
                    )
                )
            ) {
                Button9 {
                    Frame45(modifier = Modifier.rowWeight(1.0f)) {
                        Install()
                    }
                }
            }
        }
        ThankYouText(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            NounDelivery5814870008BE72(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -2.5.dp,
                        y = 0.0.dp
                    )
                )
            ) {
                Vector5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            AConfirmationEmailWillBeSentToJohndoe2394GmailCom(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomCenter,
                    offset = DpOffset(
                        x = -3.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            JohnYourPickupOrderR957394IsConfirmed(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 3.0.dp,
                        y = 46.0.dp
                    )
                )
            )
            ThankYouForSchedulingAReturnWithUs(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 100.0.dp
                    )
                )
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ThankYouComponentPreview() {
    MaterialTheme {
        RelayContainer {
            ThankYouComponent(
                dashboardButton = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_rectangle_56),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(73.6865234375.dp)
    )
}

@Composable
fun ProgressBarSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.alpha(alpha = 100.0f)
    )
}

@Composable
fun Line3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_line_3),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 40.0.dp,
                top = 14.0.dp,
                end = 0.0.dp,
                bottom = 35.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Ellipse20(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_ellipse_20),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 0.0.dp,
                end = 15.0.dp,
                bottom = 24.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 19.0.dp,
                top = 6.0.dp,
                end = 18.0.dp,
                bottom = 30.550048828125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun StatusField(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Date",
        fontSize = 10.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        maxLines = -1,
        modifier = modifier.requiredWidth(70.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CheckCircle(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(49.31005859375.dp)
    )
}

@Composable
fun Line4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_line_4),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 40.0.dp,
                top = 14.0.dp,
                end = 0.0.dp,
                bottom = 35.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Ellipse21(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_ellipse_21),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 0.0.dp,
                end = 15.0.dp,
                bottom = 24.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector1),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 19.0.dp,
                top = 6.0.dp,
                end = 18.0.dp,
                bottom = 30.550048828125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun StatusField1(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Details",
        fontSize = 10.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        maxLines = -1,
        modifier = modifier.requiredWidth(70.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CheckCircle1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(49.31005859375.dp)
    )
}

@Composable
fun Line5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_line_5),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 40.0.dp,
                top = 14.0.dp,
                end = 0.0.dp,
                bottom = 35.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Ellipse22(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_ellipse_22),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 0.0.dp,
                end = 15.0.dp,
                bottom = 24.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector2),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 19.0.dp,
                top = 6.0.dp,
                end = 18.0.dp,
                bottom = 30.550048828125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun StatusField2(modifier: Modifier = Modifier) {
    RelayText(
        content = "Choose Date",
        fontSize = 10.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        maxLines = -1,
        modifier = modifier.requiredWidth(70.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CheckCircle2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(49.31005859375.dp)
    )
}

@Composable
fun Line6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_line_6),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 40.0.dp,
                top = 14.0.dp,
                end = 0.0.dp,
                bottom = 35.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Ellipse23(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_ellipse_23),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 0.0.dp,
                end = 15.0.dp,
                bottom = 24.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector3),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 19.0.dp,
                top = 6.0.dp,
                end = 18.0.dp,
                bottom = 30.550048828125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun StatusField3(modifier: Modifier = Modifier) {
    RelayText(
        content = "Package Details",
        fontSize = 10.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        maxLines = -1,
        modifier = modifier.requiredWidth(70.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CheckCircle3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(49.31005859375.dp)
    )
}

@Composable
fun Ellipse24(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_ellipse_24),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 0.0.dp,
                end = 15.0.dp,
                bottom = 24.31005859375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector4),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 19.0.dp,
                top = 6.0.dp,
                end = 18.0.dp,
                bottom = 30.550048828125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun PayConfirm(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pay & Confirm",
        fontSize = 10.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        maxLines = -1,
        modifier = modifier.requiredWidth(70.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CheckCircle4(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(55.0.dp).requiredHeight(49.31005859375.dp)
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
fun Install(modifier: Modifier = Modifier) {
    RelayText(
        content = "Return to Dashboard",
        fontSize = 24.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.25.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Frame45(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun Button9(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 29.0.dp,
            top = 16.0.dp,
            end = 29.0.dp,
            bottom = 16.0.dp
        ),
        itemSpacing = 8.0,
        clipToParent = false,
        radius = 50.0,
        content = content,
        modifier = modifier.requiredWidth(261.0.dp).requiredHeight(60.0.dp)
    )
}

@Composable
fun DashboardButton(
    dashboardButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = dashboardButton)
    )
}

@Composable
fun AndroidLarge3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.thank_you_component_vector5),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 6.81640625.dp,
                top = 24.9609375.dp,
                end = 7.0302734375.dp,
                bottom = 24.961181640625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounDelivery5814870008BE72(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(100.0.dp).requiredHeight(100.0.dp)
    )
}

@Composable
fun AConfirmationEmailWillBeSentToJohndoe2394GmailCom(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("A confirmation email will be sent to:\n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 138,
                        blue = 230
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("johndoe2394@gmail.com\n")
            }
        },
        fontSize = 24.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.171875.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(325.0.dp).requiredHeight(134.0.dp)
    )
}

@Composable
fun JohnYourPickupOrderR957394IsConfirmed(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("John, your pickup order ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 138,
                        blue = 230
                    ),
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("#R957394")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append(" is confirmed.")
            }
        },
        fontSize = 24.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.171875.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(325.0.dp).requiredHeight(89.0.dp)
    )
}

@Composable
fun ThankYouForSchedulingAReturnWithUs(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 138,
                        blue = 230
                    ),
                    fontFamily = cairo,
                    fontSize = 32.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("Thank you")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 32.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append(" for scheduling a return with us!\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append(" \n")
            }
        },
        fontSize = 24.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.171875.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(325.0.dp).requiredHeight(186.0.dp)
    )
}

@Composable
fun ThankYouText(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 14.0.dp,
                top = 80.0.dp,
                end = 15.0.dp,
                bottom = 131.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
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
