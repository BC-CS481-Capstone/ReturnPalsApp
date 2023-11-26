package com.example.returnpals.confirmpickup

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
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'confirm_pickup'.
 * Generated code; do not edit directly
 */
@Composable
fun ConfirmPickup(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        Background()
        Confirm(
            modifier = Modifier.boxAlign(
                alignment = Alignment.BottomStart,
                offset = DpOffset(
                    x = 174.0.dp,
                    y = -19.0.dp
                )
            )
        ) {
            Frame45 {
                Install()
                ArrowRight {
                    Vector(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
            }
        }
        BackButtonBlue(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 5.0.dp,
                    y = 746.0.dp
                )
            )
        ) {
            Back(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomStart,
                    offset = DpOffset(
                        x = 22.4794921875.dp,
                        y = -2.272705078125.dp
                    )
                )
            )
            ArrowRight1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.BottomStart,
                    offset = DpOffset(
                        x = -8.881784197001252e-16.dp,
                        y = 0.00003337860107421875.dp
                    )
                )
            ) {
                Vector1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
        }
        OrderSummary(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 13.0.dp,
                    y = 133.0.dp
                )
            )
        ) {
            Rectangle65()
            InputPromo(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 29.0.dp,
                        y = 504.86865234375.dp
                    )
                )
            ) {
                Rectangle40(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = -2.5.dp,
                            y = -2.5.dp
                        )
                    )
                )
                PromoCode(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 28.251953125.dp,
                            y = 11.6138916015625.dp
                        )
                    )
                )
                Rectangle66(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 177.4599609375.dp,
                            y = 0.0.dp
                        )
                    )
                )
                Apply(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 187.27685546875.dp,
                            y = 11.6138916015625.dp
                        )
                    )
                )
            }
            Packages(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 7.0.dp,
                        y = 264.0.dp
                    )
                )
            ) {
                Packages1(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 50.53466796875.dp,
                            y = 0.0.dp
                        )
                    )
                )
                Class1PackageWithDigitalLabel(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 53.69287109375.dp,
                            y = 19.90142822265625.dp
                        )
                    )
                )
                Logo(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 17.80657958984375.dp
                        )
                    )
                ) {
                    Group(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Vector2()
                    }
                }
            }
            Payment(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 12.0.dp,
                        y = 377.0.dp
                    )
                )
            ) {
                Class10991001199(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 221.0.dp,
                            y = 35.0.dp
                        )
                    )
                )
                OneTimeReturnTaxTotal(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 39.0.dp
                        )
                    )
                )
                VisaEndingIn4832()
            }
            OrderSummary(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 72.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            Class6500BoulevardDeRomeBrossardQCJ4Y0B6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 12.0.dp,
                        y = 162.0.dp
                    )
                )
            )
            DirectHandoff(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 79.0.dp,
                        y = 109.0.dp
                    )
                )
            )
            Line10(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 54.0.dp,
                        y = 50.3248291015625.dp
                    )
                )
            )
            MonSep25th(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 79.0.dp,
                        y = 63.0.dp
                    )
                )
            )
        }
        ConfirmYourPickup(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 74.0.dp
                )
            )
        )
        ProgressBar {
            Rectangle56()
            Ellipse18(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 315.5.dp,
                        y = 16.5.dp
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
            Ellipse19(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 240.5.dp,
                        y = 16.5.dp
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
                        x = 224.0.dp,
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
            Ellipse20(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 165.5.dp,
                        y = 16.5.dp
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
            Vector3(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 21.0.dp,
                        y = 25.0.dp
                    )
                )
            )
            Vector4(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 96.0.dp,
                        y = 25.0.dp
                    )
                )
            )
            Vector5(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 171.0.dp,
                        y = 25.0.dp
                    )
                )
            )
            Vector6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 246.0.dp,
                        y = 25.0.dp
                    )
                )
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ConfirmPickupPreview() {
    MaterialTheme {
        RelayContainer {
            ConfirmPickup(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun Install(modifier: Modifier = Modifier) {
    RelayText(
        content = "Confirm",
        fontSize = 30.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.8739999135335283.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector),
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
fun Confirm(
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
        modifier = modifier.requiredWidth(174.0.dp).requiredHeight(55.0.dp)
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
        modifier = modifier.requiredWidth(57.5205078125.dp).requiredHeight(12.727294921875.dp)
    )
}

@Composable
fun Vector1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector1),
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
fun ArrowRight1(
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
fun BackButtonBlue(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(80.0.dp).requiredHeight(15.0.dp)
    )
}

@Composable
fun Rectangle65(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_rectangle_65),
        modifier = modifier.requiredWidth(330.0.dp).requiredHeight(574.0.dp)
    )
}

@Composable
fun Rectangle40(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_rectangle_40),
        modifier = modifier.requiredWidth(271.0986328125.dp).requiredHeight(47.0675048828125.dp)
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
        modifier = modifier.requiredWidth(221.4951171875.dp).requiredHeight(24.45068359375.dp)
    )
}

@Composable
fun Rectangle66(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_rectangle_66),
        modifier = modifier.requiredWidth(93.638671875.dp).requiredHeight(47.0675048828125.dp)
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
        modifier = modifier.requiredWidth(73.24951171875.dp).requiredHeight(30.5633544921875.dp)
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
        modifier = modifier.requiredWidth(271.0986328125.dp).requiredHeight(47.0675048828125.dp)
    )
}

@Composable
fun Packages1(modifier: Modifier = Modifier) {
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
        modifier = modifier.requiredWidth(155.70751953125.dp).requiredHeight(24.2044677734375.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
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
        modifier = modifier.requiredWidth(265.30712890625.dp).requiredHeight(33.51824951171875.dp)
    )
}

@Composable
fun Vector2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector2),
        modifier = modifier.requiredWidth(40.96875.dp).requiredHeight(33.58428955078125.dp)
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
        modifier = modifier.requiredWidth(40.96875.dp).requiredHeight(33.58428955078125.dp)
    )
}

@Composable
fun Packages(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(319.0.dp).requiredHeight(53.419677734375.dp)
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
        modifier = modifier.requiredWidth(83.06640625.dp).requiredHeight(80.0.dp)
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
        modifier = modifier.requiredWidth(178.97021484375.dp).requiredHeight(100.0.dp)
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
        modifier = modifier.requiredWidth(281.15087890625.dp).requiredHeight(39.1531982421875.dp)
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
        modifier = modifier.requiredWidth(304.06640625.dp).requiredHeight(139.0.dp)
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
        modifier = modifier.requiredWidth(187.27685546875.dp).requiredHeight(50.9915771484375.dp)
    )
}

@Composable
fun Class6500BoulevardDeRomeBrossardQCJ4Y0B6(modifier: Modifier = Modifier) {
    RelayText(
        content = "6500 Boulevard de Rome, Brossard, QC, J4Y 0B6",
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
        modifier = modifier.requiredWidth(234.0.dp).requiredHeight(77.0.dp)
    )
}

@Composable
fun DirectHandoff(modifier: Modifier = Modifier) {
    RelayText(
        content = "Direct Handoff",
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
        modifier = modifier.requiredWidth(234.0.dp).requiredHeight(41.0.dp)
    )
}

@Composable
fun Line10(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_line_10),
        modifier = modifier.requiredWidth(215.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun MonSep25th(modifier: Modifier = Modifier) {
    RelayText(
        content = "Mon, Sep 25th",
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
        modifier = modifier.requiredWidth(234.0.dp).requiredHeight(46.0.dp)
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
        content = content,
        modifier = modifier.requiredWidth(330.0.dp).requiredHeight(574.0.dp)
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
        modifier = modifier.requiredWidth(288.0.dp).requiredHeight(53.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_rectangle_56),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(73.68646240234375.dp)
    )
}

@Composable
fun Ellipse18(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_ellipse_18),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Line6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_line_6),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse19(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_ellipse_19),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Line5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_line_5),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Line4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_line_4),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Line3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_line_3),
        modifier = modifier.requiredWidth(50.0.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse14(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_ellipse_14),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
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
        modifier = modifier.requiredWidth(62.0.dp).requiredHeight(20.0.dp).wrapContentHeight(
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
        fontWeight = FontWeight(700.0.toInt()),
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
        vector = painterResource(R.drawable.confirm_pickup_ellipse_15),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
    )
}

@Composable
fun Ellipse20(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_ellipse_20),
        modifier = modifier.requiredWidth(25.0.dp).requiredHeight(25.0.dp)
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
fun Vector3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector3),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun Vector4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector4),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun Vector5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector5),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
    )
}

@Composable
fun Vector6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.confirm_pickup_vector6),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(12.760009765625.dp)
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
