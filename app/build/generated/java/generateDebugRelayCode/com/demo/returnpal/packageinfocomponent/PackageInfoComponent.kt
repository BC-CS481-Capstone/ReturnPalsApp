package com.demo.returnpal.packageinfocomponent

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
import com.google.relay.compose.BorderAlignment
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

/**
 * This composable was generated from the UI Package 'package_info_component'.
 * Generated code; do not edit directly
 */
@Composable
fun PackageInfoComponent(
    modifier: Modifier = Modifier,
    backButton: () -> Unit = {},
    physicalLabelButton: () -> Unit = {},
    digitalLabelButton: () -> Unit = {},
    amazonQRCode: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        AndroidLarge2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
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
                                x = -2.0.dp,
                                y = -2.0.dp
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
                ArrowRight(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                    Vector5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                }
            }
        }
        SelectLabelTypeAndWeLlHandleTheLabelPrintingAndRepackagingYouCanAddMultiplePackages(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 1.0.dp,
                    y = 80.0.dp
                )
            )
        )
        LabelChoices(
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = -15.0.dp,
                    y = -155.0.dp
                )
            )
        ) {
            Group9902(physicalLabelButton = physicalLabelButton) {
                Rectangle70(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                TypeOfLabel(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = -1.0.dp,
                            y = 11.5.dp
                        )
                    )
                )
                Plus1(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomCenter,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -7.615478515625.dp
                        )
                    )
                ) {
                    Vector6(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector7(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                }
                NounPaper5571925052A421(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 24.040382385253906.dp,
                            y = 6.9596710205078125.dp
                        )
                    )
                ) {
                    Group(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Vector8(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                    NounBarcode5504918008BE71(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Group1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            Vector9(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector10(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector11(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector12(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector13(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector14(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector15(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector16(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector17(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                }
            }
            Group9901(digitalLabelButton = digitalLabelButton) {
                Rectangle71(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                TypeOfLabel1(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = -1.0.dp,
                            y = 11.5.dp
                        )
                    )
                )
                Plus2(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomCenter,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -7.615478515625.dp
                        )
                    )
                ) {
                    Vector18(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector19(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                }
                NounWeb5850602008BE71(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 26.0.dp,
                            y = 14.0.dp
                        )
                    )
                ) {
                    Group2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Vector20(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                    }
                    NounBarcode5504918008BE72(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Group3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            Vector21(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector22(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector23(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector24(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector25(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector26(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector27(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector28(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                            Vector29(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                }
            }
            Group9900(amazonQRCode = amazonQRCode) {
                Rectangle72(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                TypeOfLabel2(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = -1.0.dp,
                            y = 11.5.dp
                        )
                    )
                )
                Plus3(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.BottomCenter,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -7.615478515625.dp
                        )
                    )
                ) {
                    Vector31(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                    Vector32(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = -2.5.dp,
                                y = -2.5.dp
                            )
                        ).rowWeight(1.0f).columnWeight(1.0f)
                    )
                }
                Vector30(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = -1.260009765625.dp,
                            y = 11.0.dp
                        )
                    )
                )
            }
        }
        Table(
            modifier = Modifier.boxAlign(
                alignment = Alignment.BottomCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = -89.0.dp
                )
            )
        ) {
            Rectangle63(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = -1.5.dp
                    )
                ).rowWeight(1.0f).columnWeight(1.0f)
            )
            HeaderRow(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                Line11(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = -3.0.dp
                        )
                    ).rowWeight(1.0f).columnWeight(1.0f)
                )
                Rectangle73(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Attachment(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                LabelType(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Description(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            MyPackages(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun PackageInfoComponentPreview() {
    MaterialTheme {
        RelayContainer {
            PackageInfoComponent(
                backButton = {},
                physicalLabelButton = {},
                digitalLabelButton = {},
                amazonQRCode = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_56),
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
        vector = painterResource(R.drawable.package_info_component_line_3),
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
        vector = painterResource(R.drawable.package_info_component_ellipse_20),
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
        vector = painterResource(R.drawable.package_info_component_vector),
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
        vector = painterResource(R.drawable.package_info_component_line_4),
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
        vector = painterResource(R.drawable.package_info_component_ellipse_21),
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
        vector = painterResource(R.drawable.package_info_component_vector1),
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
        vector = painterResource(R.drawable.package_info_component_line_5),
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
        vector = painterResource(R.drawable.package_info_component_ellipse_22),
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
        vector = painterResource(R.drawable.package_info_component_vector2),
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
        vector = painterResource(R.drawable.package_info_component_line_6),
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
        vector = painterResource(R.drawable.package_info_component_ellipse_23),
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
        vector = painterResource(R.drawable.package_info_component_vector3),
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
        vector = painterResource(R.drawable.package_info_component_ellipse_24),
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
        vector = painterResource(R.drawable.package_info_component_vector4),
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
                start = 22.479248046875.dp,
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
fun Vector5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector5),
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
fun ArrowRight(
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
fun SelectLabelTypeAndWeLlHandleTheLabelPrintingAndRepackagingYouCanAddMultiplePackages(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 178,
                        red = 4,
                        green = 41,
                        blue = 65
                    ),
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500.0.toInt())
                )
            ) {
                append("Select label type")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 178,
                        red = 4,
                        green = 41,
                        blue = 65
                    ),
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append(" and we’ll handle the label printing and repackaging. \n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 178,
                        red = 4,
                        green = 41,
                        blue = 65
                    ),
                    fontFamily = cairo,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(400.0.toInt())
                )
            ) {
                append("You can add multiple packages.")
            }
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.171875.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(312.0.dp)
    )
}

@Composable
fun Rectangle70(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_70),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TypeOfLabel(modifier: Modifier = Modifier) {
    RelayText(
        content = "Physical Label",
        fontSize = 15.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(800.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(64.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun Vector6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector6),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 11.25.dp,
                top = 4.406982421875.dp,
                end = 11.25.dp,
                bottom = 4.406982421875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector7(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector7),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 4.6875.dp,
                top = 10.576904296875.dp,
                end = 4.6875.dp,
                bottom = 10.576904296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Plus1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(22.5.dp).requiredHeight(21.15380859375.dp)
    )
}

@Composable
fun Vector8(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector8),
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
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 3.26953125.dp,
                top = 6.835205078125.dp,
                end = 1.1886672973632812.dp,
                bottom = 8.916160583496094.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector9(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector9),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 12.4931640625.dp,
                bottom = 7.7802734375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector10(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector10),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.4931640625.dp,
                top = 0.000244140625.dp,
                end = 0.0.dp,
                bottom = 7.780029296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector11(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector11),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 7.780029296875.dp,
                end = 12.4931640625.dp,
                bottom = 0.000244140625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector12(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector12),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.4931640625.dp,
                top = 7.7802734375.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector13(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector13),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 1.943359375.dp,
                top = 1.837158203125.dp,
                end = 14.28125.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector14(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector14),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 6.05615234375.dp,
                top = 1.837158203125.dp,
                end = 10.169189453125.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector15(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector15),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 10.16845703125.dp,
                top = 1.837158203125.dp,
                end = 8.11279296875.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector16(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector16),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.225341796875.dp,
                top = 1.837158203125.dp,
                end = 4.0.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector17(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector17),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 16.337890625.dp,
                top = 1.837158203125.dp,
                end = 1.943359375.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
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
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 1.800048828125.dp,
                top = 4.65380859375.dp,
                end = 1.715576171875.dp,
                bottom = 4.453895568847656.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounBarcode5504918008BE71(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 5.73919677734375.dp,
                top = 10.573076248168945.dp,
                end = 11.530036926269531.dp,
                bottom = 10.123075485229492.dp
            )
        ).graphicsLayer(rotationZ = 90.0f).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounPaper5571925052A421(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.graphicsLayer(rotationZ = -90.0f).requiredWidth(39.76923370361328.dp).requiredHeight(41.849998474121094.dp)
    )
}

@Composable
fun Group9902(
    physicalLabelButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = physicalLabelButton).requiredWidth(90.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Rectangle71(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_71),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TypeOfLabel1(modifier: Modifier = Modifier) {
    RelayText(
        content = "Digital Label",
        fontSize = 15.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(800.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(64.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun Vector18(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector18),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 11.25.dp,
                top = 4.406982421875.dp,
                end = 11.25.dp,
                bottom = 4.406982421875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector19(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector19),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 4.6875.dp,
                top = 10.576904296875.dp,
                end = 4.6875.dp,
                bottom = 10.576904296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Plus2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(22.5.dp).requiredHeight(21.15380859375.dp)
    )
}

@Composable
fun Vector20(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector20),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Group2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 2.812744140625.dp,
                top = 3.701904296875.dp,
                end = 2.813232421875.dp,
                bottom = 3.70068359375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector21(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector21),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 12.4931640625.dp,
                bottom = 7.7802734375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector22(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector22),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.4931640625.dp,
                top = 0.000244140625.dp,
                end = 0.0.dp,
                bottom = 7.780029296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector23(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector23),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 7.780029296875.dp,
                end = 12.4931640625.dp,
                bottom = 0.000244140625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector24(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector24),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.4931640625.dp,
                top = 7.7802734375.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector25(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector25),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 1.943359375.dp,
                top = 1.837158203125.dp,
                end = 14.28125.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector26(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector26),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 6.05615234375.dp,
                top = 1.837158203125.dp,
                end = 10.169189453125.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector27(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector27),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 10.16845703125.dp,
                top = 1.837158203125.dp,
                end = 8.11279296875.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector28(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector28),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.225341796875.dp,
                top = 1.837158203125.dp,
                end = 4.0.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector29(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector29),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 16.337890625.dp,
                top = 1.837158203125.dp,
                end = 1.943359375.dp,
                bottom = 1.83740234375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Group3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 1.7578125.dp,
                top = 4.553955078125.dp,
                end = 1.7578125.dp,
                bottom = 4.5537109375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounBarcode5504918008BE72(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        borderAlignment = BorderAlignment.Center,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 6.75.dp,
                top = 3.8076171875.dp,
                end = 6.75.dp,
                bottom = 8.884765625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounWeb5850602008BE71(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(36.0.dp).requiredHeight(33.84619140625.dp)
    )
}

@Composable
fun Group9901(
    digitalLabelButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = digitalLabelButton).requiredWidth(90.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Rectangle72(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_72),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TypeOfLabel2(modifier: Modifier = Modifier) {
    RelayText(
        content = "Amazon QR Code",
        fontSize = 15.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(800.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(64.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun Vector31(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector31),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 11.25.dp,
                top = 4.406982421875.dp,
                end = 11.25.dp,
                bottom = 4.406982421875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector32(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector32),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 4.6875.dp,
                top = 10.576904296875.dp,
                end = 4.6875.dp,
                bottom = 10.576904296875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Plus3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(22.5.dp).requiredHeight(21.15380859375.dp)
    )
}

@Composable
fun Vector30(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_vector30),
        modifier = modifier.requiredWidth(33.47998046875.dp).requiredHeight(32.99609375.dp)
    )
}

@Composable
fun Group9900(
    amazonQRCode: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = amazonQRCode).requiredWidth(90.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun LabelChoices(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 20.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(286.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun Rectangle63(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_63),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 39.5341796875.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Line11(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_line_11),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.3994140625.dp,
                top = 51.923828125.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle73(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_component_rectangle_73),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 0.0.dp,
                bottom = 0.880126953125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Attachment(modifier: Modifier = Modifier) {
    RelayText(
        content = "Attachment",
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.874000004359654.em,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 28.0.dp,
                top = 13.3330078125.dp,
                end = 196.0.dp,
                bottom = 9.626708984375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun LabelType(modifier: Modifier = Modifier) {
    RelayText(
        content = "Label Type",
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.874000004359654.em,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 128.0.dp,
                top = 13.3330078125.dp,
                end = 95.0.dp,
                bottom = 9.626708984375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    RelayText(
        content = "Description",
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 138,
            blue = 230
        ),
        height = 1.874000004359654.em,
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 221.0.dp,
                top = 13.3330078125.dp,
                end = 3.0.dp,
                bottom = 9.626708984375.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun HeaderRow(
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
                top = 39.5341796875.dp,
                end = 0.0.dp,
                bottom = 298.5419921875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun MyPackages(modifier: Modifier = Modifier) {
    RelayText(
        content = "My Packages",
        fontSize = 20.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.8739999771118163.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 84.0.dp,
                top = 0.0.dp,
                end = 83.0.dp,
                bottom = 350.705322265625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Table(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(312.0.dp).requiredHeight(390.0.dp)
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
