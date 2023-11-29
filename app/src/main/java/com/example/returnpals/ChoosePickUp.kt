package com.example.returnpals

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.activity.ComponentActivity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.returnpals.choosepickup.avenirNext
import com.example.returnpals.choosepickup.inter
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable

class ChoosePickUp : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            ChoosePickUp();
        }
    }
}
@Composable
fun ChoosePickUp(
    modifier: Modifier = Modifier,
    onGroup9883Tapped: () -> Unit = {},
    onGroup9884Tapped: () -> Unit = {},
    onGroup9885Tapped: () -> Unit = {},
    onGroup9886Tapped: () -> Unit = {},
    onGroup9887Tapped: () -> Unit = {},
    onDate2Tapped: () -> Unit = {},
    onDate1Tapped: () -> Unit = {},
    onNextButtonTapped: () -> Unit = {}
) {
    TopLevelPickup(modifier = modifier) {
        Group9883(
            onGroup9883Tapped = onGroup9883Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 23.0.dp,
                    y = 289.0.dp
                )
            )
        ) {
            Rectangle58()
            Sep22Fri(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.5294189453125.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        Group9884(
            onGroup9884Tapped = onGroup9884Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 136.0.dp,
                    y = 289.0.dp
                )
            )
        ) {
            Rectangle59()
            Sep23Sat(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.5294189453125.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        Group9885(
            onGroup9885Tapped = onGroup9885Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 249.0.dp,
                    y = 289.0.dp
                )
            )
        ) {
            Rectangle60()
            Sep24Sun(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 17.7882080078125.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        Group9886(
            onGroup9886Tapped = onGroup9886Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 23.0.dp,
                    y = 419.0.dp
                )
            )
        ) {
            Rectangle61()
            Sep25Mon(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.529296875.dp,
                        y = 6.16522216796875.dp
                    )
                )
            )
        }
        Group9887(
            onGroup9887Tapped = onGroup9887Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 136.0.dp,
                    y = 419.0.dp
                )
            )
        ) {
            Rectangle62()
            Sep26Tue(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.529296875.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        Date2(
            onDate2Tapped = onDate2Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 249.0.dp,
                    y = 419.0.dp
                )
            )
        ) {
            Rectangle63()
            Sep27Wed(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 17.7882080078125.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        Date1(
            onDate1Tapped = onDate1Tapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 23.0.dp,
                    y = 542.0.dp
                )
            )
        ) {
            Rectangle64()
            Sep28Thu(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 18.529296875.dp,
                        y = 6.1651611328125.dp
                    )
                )
            )
        }
        NounArrowBack47584431(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 144.0.dp,
                    y = 551.0.dp
                )
            )
        ) {
            Group(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f)) {
                Vector(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
        }
        NextWeek(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 146.0.dp,
                    y = 592.0.dp
                )
            )
        )
        Plus1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 250.0.dp,
                    y = 532.0.dp
                )
            )
        ) {
            FrontslashVector(
                modifier = Modifier
                    .boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = -1.5.dp,
                            y = -1.5.dp
                        )
                    )
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
            BackslashVector(
                modifier = Modifier
                    .boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = -1.5.dp,
                            y = -1.5.dp
                        )
                    )
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
        Cancel(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 232.0.dp,
                    y = 595.0.dp
                )
            )
        )
        ChooseAPickupDate(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 8.0.dp,
                    y = 129.0.dp
                )
            )
        )
        NextButton(
            onNextButtonTapped = onNextButtonTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 69.0.dp,
                    y = 692.0.dp
                )
            )
        ) {
            ButtonNext {
                Install()
                ArrowRight {
                    NextArrow(modifier = Modifier
                        .rowWeight(1.0f)
                        .columnWeight(1.0f))
                }
            }
        }
        Process {
            Rectangle56()
            Ellipse18(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 316.5.dp,
                        y = 20.5.dp
                    )
                )
            )
            Line6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 267.0.dp,
                        y = 33.0.dp
                    )
                )
            )
            Ellipse17(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 241.5.dp,
                        y = 20.5.dp
                    )
                )
            )
            Line5(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 192.0.dp,
                        y = 33.0.dp
                    )
                )
            )
            Ellipse16(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 166.5.dp,
                        y = 20.5.dp
                    )
                )
            )
            Line4(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 117.0.dp,
                        y = 33.0.dp
                    )
                )
            )
            Line3(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 42.0.dp,
                        y = 33.0.dp
                    )
                )
            )
            Ellipse14(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 15.5.dp,
                        y = 19.5.dp
                    )
                )
            )
            PickupDate(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 11.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PickupDetails(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 82.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            ChoosePlan(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 157.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PackageDetails(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 230.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            PayConfirm(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 305.0.dp,
                        y = 48.0.dp
                    )
                )
            )
            Ellipse15(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 91.5.dp,
                        y = 20.5.dp
                    )
                )
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ChoosePickUpPreview() {
    MaterialTheme {
        RelayContainer {
            ChoosePickUp(
                onGroup9883Tapped = {},
                onGroup9884Tapped = {},
                onGroup9885Tapped = {},
                onGroup9886Tapped = {},
                onGroup9887Tapped = {},
                onDate2Tapped = {},
                onDate1Tapped = {},
                onNextButtonTapped = {},
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Rectangle58(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_58),
        modifier = modifier
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep22Fri(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("22\n")
            }
            append("Fri")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(37.5.dp)
            .requiredHeight(71.66973876953125.dp)
    )
}

@Composable
fun Group9883(
    onGroup9883Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGroup9883Tapped)
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle59(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_59),
        modifier = modifier
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep23Sat(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("23\n")
            }
            append("Sat")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(37.5.dp)
            .requiredHeight(71.66973876953125.dp)
    )
}

@Composable
fun Group9884(
    onGroup9884Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGroup9884Tapped)
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle60(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_60),
        modifier = modifier
            .requiredWidth(72.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep24Sun(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 4,
                        green = 41,
                        blue = 65
                    )
                )
            ) {
                append("Sep\n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 4,
                        green = 41,
                        blue = 65
                    ),
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("24\n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 4,
                        green = 41,
                        blue = 65
                    )
                )
            ) {
                append("Sun")
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
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(36.0.dp)
            .requiredHeight(71.66973876953125.dp)
    )
}

@Composable
fun Group9885(
    onGroup9885Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGroup9885Tapped)
            .requiredWidth(72.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle61(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_61),
        modifier = modifier
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep25Mon(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("25\n")
            }
            append("Mon")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(37.5.dp)
            .requiredHeight(71.66973876953125.dp)
    )
}

@Composable
fun Group9886(
    onGroup9886Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGroup9886Tapped)
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle62(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_62),
        modifier = modifier
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep26Tue(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("26\n")
            }
            append("Tue")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(37.5.dp)
            .requiredHeight(71.669677734375.dp)
    )
}

@Composable
fun Group9887(
    onGroup9887Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGroup9887Tapped)
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle63(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_63),
        modifier = modifier
            .requiredWidth(72.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep27Wed(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("27\n")
            }
            append("Wed")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(36.0.dp)
            .requiredHeight(71.669677734375.dp)
    )
}

@Composable
fun Date2(
    onDate2Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 15.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onDate2Tapped)
            .requiredWidth(72.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Rectangle64(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_64),
        modifier = modifier
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Sep28Thu(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            append("Sep\n")
            withStyle(
                style = SpanStyle(
                    fontFamily = avenirNext,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700.0.toInt())
                )
            ) {
                append("28\n")
            }
            append("Thu")
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(37.5.dp)
            .requiredHeight(71.669677734375.dp)
    )
}

@Composable
fun Date1(
    onDate1Tapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .tappable(onTap = onDate1Tapped)
            .requiredWidth(75.0.dp)
            .requiredHeight(84.0.dp)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_vector),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
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
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 19.0.dp,
                    top = 5.0.dp,
                    end = 5.9547119140625.dp,
                    bottom = 3.048828125.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun NounArrowBack47584431(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .graphicsLayer(rotationZ = 0f)
            .requiredWidth(42.0.dp)
            .requiredHeight(41.0.dp)
    )
}

@Composable
fun NextWeek(modifier: Modifier = Modifier) {
    RelayText(
        content = "Next Week",
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        height = 1.3660000165303545.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(55.0.dp)
            .requiredHeight(20.0.dp)
    )
}

@Composable
fun FrontslashVector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_frontslash_vector),
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 14.582421245626279.dp,
                    top = 35.000002227771574.dp,
                    end = 14.584246692606143.dp,
                    bottom = 34.999997772228426.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun BackslashVector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_backslash_vector),
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 14.582421245626279.dp,
                    top = 35.000002227771574.dp,
                    end = 14.584246692606143.dp,
                    bottom = 34.999997772228426.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
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
        modifier = modifier
            .requiredWidth(70.0.dp)
            .requiredHeight(70.0.dp)
    )
}

@Composable
fun Cancel(modifier: Modifier = Modifier) {
    RelayText(
        content = "Cancel",
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 0,
            green = 139,
            blue = 230
        ),
        height = 1.3660000165303545.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(105.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun ChooseAPickupDate(modifier: Modifier = Modifier) {
    RelayText(
        content = "Choose a pickup date",
        fontSize = 30.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272033691406.em,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(334.0.dp)
            .requiredHeight(31.0.dp)
    )
}

@Composable
fun Install(modifier: Modifier = Modifier) {
    RelayText(
        content = "Next",
        fontSize = 32.0.sp,
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
fun NextArrow(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_next_arrow),
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 3.0.dp,
                    top = 4.5.dp,
                    end = 3.0.dp,
                    bottom = 4.5.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
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
        modifier = modifier
            .requiredWidth(24.0.dp)
            .requiredHeight(24.0.dp)
    )
}

@Composable
fun ButtonNext(
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
    onNextButtonTapped: () -> Unit,
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
        modifier = modifier
            .tappable(onTap = onNextButtonTapped)
            .requiredWidth(210.0.dp)
            .requiredHeight(70.0.dp)
    )
}

@Composable
fun Rectangle56(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_rectangle_56),
        modifier = modifier
            .requiredWidth(360.0.dp)
            .requiredHeight(73.68646240234375.dp)
    )
}

@Composable
fun Ellipse18(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_ellipse_18),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_line_6),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse17(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_ellipse_17),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line5(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_line_5),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse16(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_ellipse_16),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Line4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_line_4),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Line3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_line_3),
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(0.0.dp)
    )
}

@Composable
fun Ellipse14(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_ellipse_14),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun PickupDate(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Date",
        fontSize = 10.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3660001118977865.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(38.9583740234375.dp)
            .requiredHeight(20.31353759765625.dp)
    )
}

@Composable
fun PickupDetails(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pickup Details",
        fontSize = 10.0.sp,
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
        modifier = modifier
            .requiredWidth(45.0.dp)
            .requiredHeight(20.31353759765625.dp)
    )
}

@Composable
fun ChoosePlan(modifier: Modifier = Modifier) {
    RelayText(
        content = "Choose Plan",
        fontSize = 10.0.sp,
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
        modifier = modifier
            .requiredWidth(45.0.dp)
            .requiredHeight(20.31353759765625.dp)
    )
}

@Composable
fun PackageDetails(modifier: Modifier = Modifier) {
    RelayText(
        content = "Package Details",
        fontSize = 10.0.sp,
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
        modifier = modifier
            .requiredWidth(49.5833740234375.dp)
            .requiredHeight(20.31353759765625.dp)
    )
}

@Composable
fun PayConfirm(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pay & Confirm",
        fontSize = 10.0.sp,
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
        modifier = modifier
            .requiredWidth(49.5833740234375.dp)
            .requiredHeight(20.31353759765625.dp)
    )
}

@Composable
fun Ellipse15(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.choose_pick_up_ellipse_15),
        modifier = modifier
            .requiredWidth(25.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun Process(
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
            .relayDropShadow(
                color = Color(
                    alpha = 102,
                    red = 4,
                    green = 41,
                    blue = 65
                ),
                borderRadius = 0.0.dp,
                blur = 30.0.dp,
                offsetX = 0.0.dp,
                offsetY = 4.0.dp,
                spread = 0.0.dp
            )
    )
}

@Composable
fun TopLevelPickup(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 225,
            green = 246,
            blue = 255
        ),
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}
