package com.example.returnpals.composetools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.returnpals.PricingPlan
import com.example.returnpals.ScheduleReturn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// TODO: guest message "sign up for more pricing options"

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

/**
 * Draws the entire screen of the step "Choose PricingPlan" in the "Schedule a Return" process
 */
@Composable
fun PricingUI(
    modifier: Modifier = Modifier,
    onChangePlan: (PricingPlan) -> Unit,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    plan: PricingPlan?,
    guest: Boolean = false,
) {
    ScheduleReturnScaffold(
        step = 3,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enabledNext = plan != null
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize(),
        ) {
            PricingOptions(
                modifier = Modifier
                    .padding(padding)
                    .scale(1.25F),
                selected = plan,
                onClickPlan = onChangePlan,
                guest = guest,
            )
        }
    }
}

class PricingViewModel(init: PricingPlan) : ViewModel() {
    private val _plan: MutableStateFlow<PricingPlan>
    val plan: StateFlow<PricingPlan>

    init {
        _plan = MutableStateFlow(init)
        plan = _plan.asStateFlow()
    }

    fun onChangePlan(value: PricingPlan) {
        _plan.update { value }
    }
}

@Composable
fun PricingOptions(
    onClickPlan: (PricingPlan) -> Unit,
    selected: PricingPlan?,
    modifier: Modifier = Modifier,
    guest: Boolean = false,
    padding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        contentPadding = padding,
        modifier = modifier
    ) {
        item {
            PricingPlanButton(
                plan = PricingPlan.BRONZE,
                onClick = { onClickPlan(PricingPlan.BRONZE) },
                selected = selected == PricingPlan.BRONZE,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PricingPlanButton(
                plan = PricingPlan.SILVER,
                onClick = { onClickPlan(PricingPlan.SILVER) },
                selected = selected == PricingPlan.SILVER,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PricingPlanButton(
                plan = PricingPlan.GOLD,
                onClick = { onClickPlan(PricingPlan.GOLD) },
                selected = selected == PricingPlan.GOLD,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PricingPlanButton(
                plan = PricingPlan.PLATINUM,
                onClick = { onClickPlan(PricingPlan.PLATINUM) },
                selected = selected == PricingPlan.PLATINUM,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
    }
}

@Composable
fun PricingPlanText(
    plan: PricingPlan,
    modifier: Modifier = Modifier
) {
    when (plan) {
        PricingPlan.BRONZE -> BronzePlanText(modifier)
        PricingPlan.SILVER -> SilverPlanText(modifier)
        PricingPlan.GOLD -> GoldPlanText(modifier)
        PricingPlan.PLATINUM -> PlatinumPlanText(modifier)
    }
}

@Composable
private fun PricingPlanButton(
    plan: PricingPlan,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        border =
            if (selected) {
                BorderStroke(
                    width = 6.dp,
                    color = Color(0,180,250),
                )
            } else {
                BorderStroke(
                    width = 2.dp,
                    color = Color.Black,
                )
            },
        shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp),
        modifier = modifier.requiredSize(145.dp, 70.dp)
    ) {
        PricingPlanText(
            plan,
            Modifier
                .offset(x = 5.dp)
                .fillMaxWidth()
        )
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun ChoosePlanPreview() {
    PricingUI(
        plan = PricingPlan.BRONZE,
        onChangePlan = {},
        onClickNext = {},
        onClickBack = {}
    )
}

@Composable
private fun SilverPlanText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color(150, 170, 170),
                        baselineShift = BaselineShift(0.25F)
                    )
                ) {
                    append("SILVER\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$20.99")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled monthly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun PlatinumPlanText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color(125, 175, 175),
                        baselineShift = BaselineShift(0.25F)
                    )
                ) {
                    append("PLATINUM\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$14.79")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled yearly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun GoldPlanText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color(230, 190, 100),
                        baselineShift = BaselineShift(0.25F)
                    )
                ) {
                    append("GOLD\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$18.99")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("/month\nbilled quarterly")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
}

@Composable
private fun BronzePlanText(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.0.sp,
                        fontWeight = FontWeight(800),
                        color = Color(200, 150, 100),
                        baselineShift = BaselineShift(0.25F)
                    )
                ) {
                    append("Bronze\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.0.sp
                    )
                ) {
                    append("\$10.99\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.0.sp,
                    )
                ) {
                    append("+\$3.99 per additional box")
                }
            },
            fontFamily = FontFamily.SansSerif,
            lineHeight = 10.sp,
            fontWeight = FontWeight(700),
            color = Color(4, 41, 65),
            modifier = modifier
        )
    }
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
        PricingPlanButton(
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
            modifier = Modifier.boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(0.0.dp, 0.0.dp)
            )
        )
    }
}
*/