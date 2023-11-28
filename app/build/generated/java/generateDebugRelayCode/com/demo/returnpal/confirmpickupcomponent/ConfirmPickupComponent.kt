package com.demo.returnpal.confirmpickupcomponent

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
 * This composable was generated from the UI Package 'confirm_pickup_component'.
 * Generated code; do not edit directly
 */
@Composable
fun ConfirmPickupComponent(
    modifier: Modifier = Modifier,
    nextButton: () -> Unit = {},
    backButton: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        AndroidLarge2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            Background()
            NextButton(
                nextButton = nextButton,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomEnd,
                    offset = DpOffset(
                        x = -23.0.dp,
                        y = -19.0.dp
                    )
                )
            ) {
                Frame45 {
                    Next()
                    ArrowRight {
                        Vector(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                }
            }
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
                    Vector1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
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
                    Vector2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
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
                    Vector3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
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
                    Vector4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
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
                                x = -2.0.dp,
                                y = -2.0.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
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
            BackButtonBlue(
                backButton = backButton,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomStart,
                    offset = DpOffset(
                        x = 34.0.dp,
                        y = -39.0.dp
                    )
                )
            ) {
                Back(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                ArrowRight1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                    Vector6(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
            }
        }
        ConfirmYourPickup(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        OrderSummaryWindow(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            OrderSummary(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                Rectangle65(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Payment(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                    Class10991001199(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    OneTimeReturnTaxTotal(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    VisaEndingIn4832(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                OrderSummary(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                PickupAddressFullPostalCodeStreetCity(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                TypeOfPickup(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Line10(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -1.0.dp
                        )
                    ).rowWeight(1.0f).columnWeight(1.0f)
                )
                WeekdayMonthDay(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            InputPromo(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                Rectangle40(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = -2.5.dp,
                            y = -2.5.dp
                        )
                    ).rowWeight(1.0f).columnWeight(1.0f)
                )
                PromoCode(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Rectangle66(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Apply(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            PackageSummary(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                OrderSummaryTableRowComponent(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                    Logo(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Group(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            Vector7(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                    Class1PackageWithDigitalLabel(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                OrderSummaryTableRowComponent1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                    Logo1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Group1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            Vector8(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                    Class1PackageWithDigitalLabel1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
                Packages(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ConfirmPickupComponentPreview() {
    MaterialTheme {
        RelayContainer {
            ConfirmPickupComponent(
                nextButton = {},
                backButton = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun Next(modifier: Modifier = Modifier) {
    RelayText(
        content = "Next",
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.171875.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_vector),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 3.0.dp,
                top = 4.5.dp,
                end = 3.0.dp,
                bottom = 4.5.dp
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
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(24.0.dp).requiredHeight(24.0.dp)
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
        modifier = modifier
    )
}

@Composable
fun NextButton(
    nextButton: () -> Unit,
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
        modifier = modifier.tappable(onTap = nextButton).requiredWidth(150.0.dp).requiredHeight(55.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_rectangle_56),
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
        vector = painterResource(R.drawable.confirm_pickup_component_line_3),
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
        vector = painterResource(R.drawable.confirm_pickup_component_ellipse_20),
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
        vector = painterResource(R.drawable.confirm_pickup_component_vector1),
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
        vector = painterResource(R.drawable.confirm_pickup_component_line_4),
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
        vector = painterResource(R.drawable.confirm_pickup_component_ellipse_21),
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
        vector = painterResource(R.drawable.confirm_pickup_component_vector2),
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
        vector = painterResource(R.drawable.confirm_pickup_component_line_5),
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
        vector = painterResource(R.drawable.confirm_pickup_component_ellipse_22),
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
        vector = painterResource(R.drawable.confirm_pickup_component_vector3),
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
        vector = painterResource(R.drawable.confirm_pickup_component_line_6),
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
        vector = painterResource(R.drawable.confirm_pickup_component_ellipse_23),
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
        vector = painterResource(R.drawable.confirm_pickup_component_vector4),
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
        vector = painterResource(R.drawable.confirm_pickup_component_ellipse_24),
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
fun Vector5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_vector5),
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
fun Back(modifier: Modifier = Modifier) {
    RelayText(
        content = "Back",
        fontSize = 20.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.8739999771118163.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 22.4794921875.dp,
                top = 0.0.dp,
                end = 0.0.dp,
                bottom = 2.272705078125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Vector6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_vector6),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 2.75.dp,
                top = 2.8125.dp,
                end = 2.75.dp,
                bottom = 2.8125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun ArrowRight1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 58.0.dp,
                bottom = 0.0.dp
            )
        ).graphicsLayer(rotationZ = 180.0f).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun BackButtonBlue(
    backButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = backButton).requiredWidth(80.0.dp).requiredHeight(15.0.dp)
    )
}

@Composable
fun AndroidLarge2(
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
fun ConfirmYourPickup(modifier: Modifier = Modifier) {
    RelayText(
        content = "Confirm Your Pickup",
        fontSize = 32.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 36.0.dp,
                top = 78.0.dp,
                end = 36.0.dp,
                bottom = 669.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Rectangle65(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_rectangle_65),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Class10991001199(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("\$10.99\n\$1.00\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("\$11.99")
            }
        },
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660001118977865.em,
        textAlign = TextAlign.Right,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 221.0.dp,
                top = 35.0.dp,
                end = 0.0.dp,
                bottom = 24.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OneTimeReturnTaxTotal(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("One-time Return\nTax \n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("Total\n")
            }
        },
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660001118977865.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 39.0.dp,
                end = 125.09619140625.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun VisaEndingIn4832(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 16.0.sp)) {
                append("Visa ending in: ")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("4832")
            }
        },
        fontSize = 16.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 2.0.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 22.91552734375.dp,
                bottom = 99.8466796875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Payment(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.0.dp,
                top = 377.0.dp,
                end = 13.93359375.dp,
                bottom = 58.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OrderSummary(modifier: Modifier = Modifier) {
    RelayText(
        content = "Order Summary",
        fontSize = 32.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 72.0.dp,
                top = 0.0.dp,
                end = 70.72314453125.dp,
                bottom = 523.00830078125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun PickupAddressFullPostalCodeStreetCity(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Address Full Postal Code, street #,city ",
        fontSize = 18.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.7777777099609375.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.0.dp,
                top = 162.0.dp,
                end = 84.0.dp,
                bottom = 335.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TypeOfPickup(modifier: Modifier = Modifier) {
    RelayText(
        content = "Type of pickup",
        fontSize = 24.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.3333332824707032.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 79.0.dp,
                top = 109.0.dp,
                end = 17.0.dp,
                bottom = 424.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Line10(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_line_10),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 54.0.dp,
                top = 51.32470703125.dp,
                end = 61.0.dp,
                bottom = 522.67529296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun WeekdayMonthDay(modifier: Modifier = Modifier) {
    RelayText(
        content = "Weekday, Month, Day",
        fontSize = 24.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.3333332824707032.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 79.0.dp,
                top = 63.0.dp,
                end = 17.0.dp,
                bottom = 465.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OrderSummary(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 25.0,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 0.30712890625.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle40(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_rectangle_40),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun PromoCode(modifier: Modifier = Modifier) {
    RelayText(
        content = "Promo Code",
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.3660001118977865.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 28.251953125.dp,
                top = 11.614013671875.dp,
                end = 21.3515625.dp,
                bottom = 11.002685546875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle66(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_rectangle_66),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 177.4599609375.dp,
                top = 0.0.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Apply(modifier: Modifier = Modifier) {
    RelayText(
        content = "Apply",
        fontSize = 30.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3660001118977865.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 187.27685546875.dp,
                top = 11.614013671875.dp,
                end = 10.572265625.dp,
                bottom = 4.89013671875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun InputPromo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 20.0.dp,
                top = 505.0.dp,
                end = 39.20849609375.dp,
                bottom = 21.9326171875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector7(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_vector7),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Group(
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

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 280.33837890625.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Class1PackageWithDigitalLabel(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = cairo,
                    fontSize = 18.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("1")
            }
            withStyle(style = SpanStyle(fontSize = 18.0.sp)) {
                append(" package with digital label")
            }
        },
        fontSize = 18.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.7777777099609375.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 56.0.dp,
                top = 0.0.dp,
                end = 0.0.dp,
                bottom = 0.06591796875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OrderSummaryTableRowComponent(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 29.0.dp,
                end = 0.0.dp,
                bottom = 45.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector8(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_component_vector8),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Group1(
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

@Composable
fun Logo1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 280.33837890625.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Class1PackageWithDigitalLabel1(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("0")
            withStyle(style = SpanStyle(fontSize = 18.0.sp)) {
                append(" package with ")
            }
            append("physical")
            withStyle(style = SpanStyle(fontSize = 18.0.sp)) {
                append(" label")
            }
        },
        fontSize = 18.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 191,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.7777777099609375.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 56.0.dp,
                top = 0.0.dp,
                end = 0.0.dp,
                bottom = 0.06591796875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OrderSummaryTableRowComponent1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 74.0.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Packages(modifier: Modifier = Modifier) {
    RelayText(
        content = "Packages",
        fontSize = 20.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 0.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 89.0.dp,
                top = 0.0.dp,
                end = 76.599609375.dp,
                bottom = 83.379638671875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun PackageSummary(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 9.0.dp,
                top = 239.0.dp,
                end = 0.0.dp,
                bottom = 227.415771484375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun OrderSummaryWindow(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 15.0.dp,
                top = 141.0.dp,
                end = 14.69287109375.dp,
                bottom = 85.0.dp
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
