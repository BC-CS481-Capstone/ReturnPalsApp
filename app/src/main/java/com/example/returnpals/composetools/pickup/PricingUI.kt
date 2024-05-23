package com.example.returnpals.composetools.pickup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.example.compose.ReturnPalTheme
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
fun PricingScreen(
    modifier: Modifier = Modifier,
    onChangePlan: (PricingPlan) -> Unit,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onClickSignUp: () -> Unit,
    plan: PricingPlan?,
    isGuest: Boolean = false,
) {
    ScheduleReturnScaffold(
        step = 3,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enabledNext = plan != null
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize().padding(padding),
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .offset(0.dp, 10.dp),
                text = "Select a Pricing Plan",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = ReturnPalTheme.colorScheme.secondary,
            )
            if (isGuest)
                GuestSignUpButton(
                    onClick = onClickSignUp,
                    modifier = Modifier.padding(0.dp,12.dp)
                )
            Spacer(modifier.weight(0.5f))
            PricingOptions(
                modifier = Modifier
                    .fillMaxSize(),
                selected = plan,
                onClickPlan = onChangePlan,
                isGuest = isGuest,
            )
            Spacer(modifier.weight(1f))
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
    isGuest: Boolean = false,
    padding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = padding,
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
                enabled = !isGuest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PricingPlanButton(
                plan = PricingPlan.GOLD,
                onClick = { onClickPlan(PricingPlan.GOLD) },
                selected = selected == PricingPlan.GOLD,
                enabled = !isGuest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PricingPlanButton(
                plan = PricingPlan.PLATINUM,
                onClick = { onClickPlan(PricingPlan.PLATINUM) },
                selected = selected == PricingPlan.PLATINUM,
                enabled = !isGuest,
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

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

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
        colors = buttonColors(
            containerColor = ReturnPalTheme.colorScheme.background,
        ),
        border =
            if (selected) {
                BorderStroke(
                    width = 6.dp,
                    color = Color(40,150,255),
                )
            } else if (enabled) {
                BorderStroke(
                    width = 2.dp,
                    color = ReturnPalTheme.colorScheme.onPrimaryContainer,
                )
            } else {
                BorderStroke(
                    width = 2.dp,
                    color = ReturnPalTheme.colorScheme.outline,
                )
            },
        shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp),
        modifier = modifier.requiredSize(175.dp, 85.dp)
    ) {
        PricingPlanText(
            plan,
            Modifier
                .offset(x = 5.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChoosePlanPreview() {
    ReturnPalTheme {
        PricingScreen(
            plan = PricingPlan.BRONZE,
            onChangePlan = {},
            onClickNext = {},
            onClickBack = {},
            onClickSignUp = {},
            isGuest = true
        )
    }
}

@Composable
private fun SilverPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color(150, 170, 170),
                    baselineShift = BaselineShift(0.25F)
                )
            ) {
                append("SILVER\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 15.0.sp
                )
            ) {
                append("\$20.99")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.0.sp,
                )
            ) {
                append("/month\nbilled monthly")
            }
        },
        fontFamily = FontFamily.SansSerif,
        lineHeight = 13.0.sp,
        fontWeight = FontWeight(700),
        color = Color(4, 41, 65),
        modifier = modifier.testTag(PricingPlan.SILVER.toString())
    )
}

@Composable
private fun PlatinumPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color(125, 175, 175),
                    baselineShift = BaselineShift(0.25F)
                )
            ) {
                append("PLATINUM\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 15.sp
                )
            ) {
                append("\$14.79")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.0.sp,
                )
            ) {
                append("/month\nbilled yearly")
            }
        },
        fontFamily = FontFamily.SansSerif,
        lineHeight = 13.0.sp,
        fontWeight = FontWeight(700),
        color = Color(4, 41, 65),
        modifier = modifier.testTag(PricingPlan.PLATINUM.toString())
    )
}

@Composable
private fun GoldPlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color(230, 190, 100),
                    baselineShift = BaselineShift(0.25F)
                )
            ) {
                append("GOLD\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 15.0.sp
                )
            ) {
                append("\$18.99")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.0.sp,
                )
            ) {
                append("/month\nbilled quarterly")
            }
        },
        fontFamily = FontFamily.SansSerif,
        lineHeight = 13.0.sp,
        fontWeight = FontWeight(700),
        color = Color(4, 41, 65),
        modifier = modifier.testTag(PricingPlan.GOLD.toString())
    )
}

@Composable
private fun BronzePlanText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color(200, 150, 100),
                    baselineShift = BaselineShift(0.25F)
                )
            ) {
                append("BRONZE\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 15.0.sp
                )
            ) {
                append("\$10.99\n")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.0.sp,
                )
            ) {
                append("+\$3.99 per additional box")
            }
        },
        fontFamily = FontFamily.SansSerif,
        lineHeight = 13.0.sp,
        fontWeight = FontWeight(700),
        color = Color(4, 41, 65),
        modifier = modifier.testTag(PricingPlan.BRONZE.toString())
    )
}

@Preview(showBackground = true)
@Composable
private fun GuestSignUpButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedButton(
            onClick = onClick,
            shape = RectangleShape,
            border = BorderStroke(2.dp, ReturnPalTheme.colorScheme.primary),
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.0.sp,
                fontWeight = FontWeight(800),
                color = ReturnPalTheme.colorScheme.primary,
            )
        }
        Text(
            text = "for more pricing options",
            fontSize = 16.0.sp,
            fontWeight = FontWeight(500),
            color = ReturnPalTheme.colorScheme.secondary,
        )
    }
}