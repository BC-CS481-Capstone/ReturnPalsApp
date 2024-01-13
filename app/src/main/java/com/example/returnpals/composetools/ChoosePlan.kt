package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.composetools.BackButton
import com.example.returnpals.composetools.NextButton
import com.example.returnpals.composetools.ProgressBar
import com.example.returnpals.composetools.cairoFontFamily
import kotlinx.coroutines.selects.select

// TODO: ChoosePlanGuestUI

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

enum class Plan {
    NONE, BRONZE, SILVER, GOLD, PLATINUM
}

@Composable
fun ChoosePlanUI(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onClickPlan: (Plan) -> Unit,
    selectedPlan: Plan = Plan.NONE
) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        PlanButton(
            onClick = { onClickPlan(Plan.BRONZE) },
            isSelected = selectedPlan == Plan.BRONZE,
        ) {
         //   BronzePlanText()
        }
        PlanButton(
            onClick = { onClickPlan(Plan.SILVER) },
            isSelected = selectedPlan == Plan.SILVER,
        ) {
           // SilverPlanText()
        }
        PlanButton(
            onClick = { onClickPlan(Plan.GOLD) },
            isSelected = selectedPlan == Plan.GOLD,
        ) {
           // GoldPlanText()
        }
        PlanButton(
            onClick = { onClickPlan(Plan.PLATINUM) },
            isSelected = selectedPlan == Plan.PLATINUM,
        ) {
          //  PlatinumPlanText()
        }
    }
    ProgressBar(step = 3)
    BackButton(
        onClick = onClickBack,
        modifier = Modifier
            .offset(8.dp,(-8).dp)
    )
    if (selectedPlan != Plan.NONE) {
        NextButton(
            onClick = onClickNext,
            modifier = Modifier
                .offset((-8).dp,(-8).dp)
        )
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(widthDp = 393, heightDp = 808)
@Composable
private fun ChoosePlanPreview() {
    ChoosePlanUI(
        onClickNext = {},
        onClickBack = {},
        onClickPlan = {},
        selectedPlan = Plan.BRONZE
    )
}

@Composable
private fun PlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    content: @Composable() (RowScope.() -> Unit)
) {
    var modifier = modifier
        .size(200.dp, 110.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
        )

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

    Button(
        onClick = onClick,
        modifier = modifier,
        content = content
    )
}

@Composable
private fun SilverPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 150,
                        green = 170,
                        blue = 170
                    ),
                    fontFamily = cairoFontFamily,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("SILVER\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$20.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled monthly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = cairoFontFamily,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
private fun PlatinumPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 125,
                        green = 175,
                        blue = 175
                    ),
                    fontFamily = cairoFontFamily,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("PLATINUM\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$14.79\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled yearly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = cairoFontFamily,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
private fun GoldPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 230,
                        green = 190,
                        blue = 100
                    ),
                    fontFamily = cairoFontFamily,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("GOLD\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$18.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("per month\nbilled quarterly")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = cairoFontFamily,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
private fun BronzePlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 200,
                        green = 150,
                        blue = 100
                    ),
                    fontFamily = cairoFontFamily,
                    fontSize = 24.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("BRONZE\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(800)
                )
            ) {
                append("\$10.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = cairoFontFamily,
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("+\$3.99 per additional box\nbilled once")
            }
        },
        fontSize = 32.0.sp,
        fontFamily = cairoFontFamily,
        color = Color(
            alpha = 255,
            red = 4,
            green = 41,
            blue = 65
        ),
        fontWeight = FontWeight(700),
        maxLines = -1,
        modifier = modifier
    )
}

/*
@Composable
private fun GuestSignUpButton(
    onTap: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    RelayContainer(
        isStructured = false,
        modifier = modifier
    ) {
        PlanButton(
            onTap = onTap,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
        RelayText(
            content = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color.Blue
                    )
                ) {
                    append("Sign up\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = cairo,
                        fontSize = 18.0.sp,
                        fontWeight = FontWeight(500)
                    )
                ) {
                    append("for more plan options")
                }
            },
            fontSize = 32.0.sp,
            fontFamily = avenirNext,
            height = 0.625.em,
            fontWeight = FontWeight(700),
            maxLines = -1,
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
}
*/