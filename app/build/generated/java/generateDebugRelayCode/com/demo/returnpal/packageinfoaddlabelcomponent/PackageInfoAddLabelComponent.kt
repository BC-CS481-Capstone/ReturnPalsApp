package com.demo.returnpal.packageinfoaddlabelcomponent

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
 * This composable was generated from the UI Package 'package_info_add_label_component'.
 * Generated code; do not edit directly
 */
@Composable
fun PackageInfoAddLabelComponent(
    modifier: Modifier = Modifier,
    describeItemTextBox: String = "",
    xButton: () -> Unit = {},
    dragLabelBoxButton: () -> Unit = {},
    addPackageButton: () -> Unit = {}
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
            DashboardButton(
                addPackageButton = addPackageButton,
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
        AddDigitalLabel(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        XButton(
            xButton = xButton,
            modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
        ) {
            Vector5(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -1.43505859375.dp,
                        y = -1.5625.dp
                    )
                ).rowWeight(1.0f).columnWeight(1.0f)
            )
            Vector6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -1.43505859375.dp,
                        y = -1.5625.dp
                    )
                ).rowWeight(1.0f).columnWeight(1.0f)
            )
        }
        DragLabelBox(
            dragLabelBoxButton = dragLabelBoxButton,
            modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
        ) {
            Rectangle74(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -0.75.dp,
                        y = -0.75.dp
                    )
                ).rowWeight(1.0f).columnWeight(1.0f)
            )
            UploadReturnLabel(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            NounFolder6114711008BE71(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                Vector7(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = -0.5.dp,
                            y = -0.5.dp
                        )
                    ).rowWeight(1.0f).columnWeight(1.0f)
                )
            }
            DragLabelHereOrBrowseFiles(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            Rectangle73(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -0.75.dp,
                        y = -0.75.dp
                    )
                ).rowWeight(1.0f).columnWeight(1.0f)
            )
        }
        FillDescriptionField(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
            Description(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            Rectangle75(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            LabelTheItemSInsideIELaptopCovers(
                describeItemTextBox = describeItemTextBox,
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun PackageInfoAddLabelComponentPreview() {
    MaterialTheme {
        RelayContainer {
            PackageInfoAddLabelComponent(
                xButton = {},
                dragLabelBoxButton = {},
                addPackageButton = {},
                describeItemTextBox = "Label the item(s) inside: i.e. ‘laptop covers’",
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_background),
        modifier = modifier.requiredWidth(360.0.dp).requiredHeight(800.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_rectangle_56),
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
        vector = painterResource(R.drawable.package_info_add_label_component_line_3),
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
        vector = painterResource(R.drawable.package_info_add_label_component_ellipse_20),
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
        vector = painterResource(R.drawable.package_info_add_label_component_vector),
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
        vector = painterResource(R.drawable.package_info_add_label_component_line_4),
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
        vector = painterResource(R.drawable.package_info_add_label_component_ellipse_21),
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
        vector = painterResource(R.drawable.package_info_add_label_component_vector1),
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
        vector = painterResource(R.drawable.package_info_add_label_component_line_5),
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
        vector = painterResource(R.drawable.package_info_add_label_component_ellipse_22),
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
        vector = painterResource(R.drawable.package_info_add_label_component_vector2),
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
        vector = painterResource(R.drawable.package_info_add_label_component_line_6),
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
        vector = painterResource(R.drawable.package_info_add_label_component_ellipse_23),
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
        vector = painterResource(R.drawable.package_info_add_label_component_vector3),
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
        vector = painterResource(R.drawable.package_info_add_label_component_ellipse_24),
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
        vector = painterResource(R.drawable.package_info_add_label_component_vector4),
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
        content = "Add Package",
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
    addPackageButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = addPackageButton)
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
fun AddDigitalLabel(modifier: Modifier = Modifier) {
    RelayText(
        content = "Add Digital Label",
        fontSize = 32.0.sp,
        fontFamily = cairo,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 29.0.dp,
                top = 141.0.dp,
                end = 62.0.dp,
                bottom = 599.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_vector5),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 22.499999905374693.dp,
                top = 10.779278811739118.dp,
                end = 22.500000094625307.dp,
                bottom = 10.779242459012835.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_vector6),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 8.77867403104608.dp,
                top = 24.500006619169085.dp,
                end = 8.779847239705873.dp,
                bottom = 24.499993380830915.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun XButton(
    xButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 291.0.dp,
                top = 130.0.dp,
                end = 24.0.dp,
                bottom = 621.0.dp
            )
        ).tappable(onTap = xButton).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle74(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_rectangle_74),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 38.105712890625.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun UploadReturnLabel(modifier: Modifier = Modifier) {
    RelayText(
        content = "Upload Return Label",
        fontSize = 25.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.3660000610351561.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 146.17138671875.dp,
                bottom = 187.352294921875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Vector7(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_vector7),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 2.24658203125.dp,
                top = 4.93115234375.dp,
                end = 2.24609375.dp,
                bottom = 4.929931640625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun NounFolder6114711008BE71(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 119.33349609375.dp,
                top = 79.38671875.dp,
                end = 118.85400390625.dp,
                bottom = 87.3251953125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun DragLabelHereOrBrowseFiles(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Drag label here or ")
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 138,
                        blue = 230
                    )
                )
            ) {
                append("browse files")
            }
        },
        fontSize = 25.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.3660000610351561.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 48.404296875.dp,
                top = 136.544921875.dp,
                end = 47.9248046875.dp,
                bottom = 48.42578125.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle73(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_rectangle_73),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 38.105712890625.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun DragLabelBox(
    dragLabelBoxButton: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 47.0.dp,
                top = 247.0.dp,
                end = 46.0576171875.dp,
                bottom = 338.65625.dp
            )
        ).tappable(onTap = dragLabelBoxButton).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    RelayText(
        content = "Description",
        fontSize = 25.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.3660000610351561.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 148.08837890625.dp,
                bottom = 105.584228515625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle75(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.package_info_add_label_component_rectangle_75),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 38.105712890625.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LabelTheItemSInsideIELaptopCovers(
    describeItemTextBox: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = describeItemTextBox,
        fontSize = 25.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.3660000610351561.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 12.46044921875.dp,
                top = 53.189208984375.dp,
                end = 12.46044921875.dp,
                bottom = 46.837890625.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun FillDescriptionField(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 47.0.dp,
                top = 529.0.dp,
                end = 44.140625.dp,
                bottom = 138.42431640625.dp
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
