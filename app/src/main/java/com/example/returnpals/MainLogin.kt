package com.example.returnpals

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.returnpals.choosepickup.avenirNext
import com.example.returnpals.choosepickup.inter
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector


@Composable
fun MainLogin(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        MemberNav(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 32.0.dp,
                    y = 192.0.dp
                )
            )
        ) {
            ForgotYourPassword(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 261.0.dp
                    )
                )
            )
            SignInGuest(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 8.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            DonTHaveAnAccountYetSignUp(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 8.0.dp,
                        y = 408.0.dp
                    )
                )
            )
        }
        InputPassword(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 55.0.dp,
                    y = 363.0.dp
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
            Password(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 17.97040557861328.dp,
                        y = 10.519481658935547.dp
                    )
                )
            )
        }
        InputEmail(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 55.0.dp,
                    y = 273.0.dp
                )
            )
        ) {
            Rectangle41(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -2.5.dp,
                        y = -2.5.dp
                    )
                )
            )
            Email(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 17.97040557861328.dp,
                        y = 10.928581237792969.dp
                    )
                )
            )
        }
        SignIn(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 105.0.dp,
                    y = 509.0.dp
                )
            )
        ) {
            Rectangle80()
            SignIn1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 26.0.dp,
                        y = 5.0.dp
                    )
                )
            )
        }
        ReturnpalfinalLogosWMKBlackBlueTransparent1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 13.0.dp,
                    y = 43.0.dp
                )
            )
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun MainLoginPreview() {
    MaterialTheme {
        RelayContainer {
            MainLogin(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun ForgotYourPassword(modifier: Modifier = Modifier) {
    RelayText(
        content = "Forgot your password?",
        fontSize = 16.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.2102272510528564.em,
        fontWeight = FontWeight(600.0.toInt()),
        underline = true,
        maxLines = -1,
        modifier = modifier.requiredWidth(288.0.dp).requiredHeight(20.0.dp)
    )
}

@Composable
fun SignInGuest(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = inter,
                    fontSize = 22.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append("Sign In ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 139,
                        blue = 230
                    ),
                    fontFamily = inter,
                    fontSize = 22.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append("|")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = inter,
                    fontSize = 22.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append(" ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 127,
                        red = 5,
                        green = 42,
                        blue = 66
                    ),
                    fontFamily = inter,
                    fontSize = 22.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append("Guest")
            }
        },
        fontSize = 22.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 5,
            green = 42,
            blue = 66
        ),
        height = 1.3660000887784092.em,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(49.0.dp)
    )
}

@Composable
fun DonTHaveAnAccountYetSignUp(modifier: Modifier = Modifier) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = inter,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append("Don’t have an account yet? ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 0,
                        green = 138,
                        blue = 230
                    ),
                    fontFamily = inter,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(600.0.toInt())
                )
            ) {
                append("Sign up")
            }
        },
        fontSize = 16.0.sp,
        fontFamily = avenirNext,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.3660000562667847.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(280.0.dp).requiredHeight(85.0.dp)
    )
}

@Composable
fun MemberNav(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(288.0.dp).requiredHeight(493.0.dp)
    )
}

@Composable
fun Rectangle40(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.main_login_rectangle_40),
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(45.0.dp)
    )
}

@Composable
fun Password(modifier: Modifier = Modifier) {
    RelayText(
        content = "Password",
        fontSize = 16.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.requiredWidth(161.20506286621094.dp).requiredHeight(23.546512603759766.dp)
    )
}

@Composable
fun InputPassword(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 20.0,
        content = content,
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(45.0.dp)
    )
}

@Composable
fun Rectangle41(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.main_login_rectangle_41),
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(45.0.dp)
    )
}

@Composable
fun Email(modifier: Modifier = Modifier) {
    RelayText(
        content = "Email",
        fontSize = 16.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 111,
            green = 117,
            blue = 123
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(161.20506286621094.dp).requiredHeight(23.5465087890625.dp)
    )
}

@Composable
fun InputEmail(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 20.0,
        content = content,
        modifier = modifier.requiredWidth(250.0.dp).requiredHeight(45.0.dp)
    )
}

@Composable
fun Rectangle80(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.main_login_rectangle_80),
        modifier = modifier.requiredWidth(150.0.dp).requiredHeight(50.0.dp)
    )
}

@Composable
fun SignIn1(modifier: Modifier = Modifier) {
    RelayText(
        content = "Sign In",
        fontSize = 30.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.requiredWidth(97.0.dp).requiredHeight(40.0.dp)
    )
}

@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 30.0,
        content = content,
        modifier = modifier.requiredWidth(150.0.dp).requiredHeight(50.0.dp)
    )
}

@Composable
fun ReturnpalfinalLogosWMKBlackBlueTransparent1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.main_login_returnpalfinal_logos_wmk_black_blue_transparent_1),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(333.0.dp).requiredHeight(130.0.dp)
    )
}

@Composable
fun TopLevel(
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
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
