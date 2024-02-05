package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.returnpals.PickupInfo
import com.example.returnpals.PricingPlan
import com.example.returnpals.ScheduleReturn

// TODO: guest message "sign up for more pricing options"

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

/**
 * Draws the entire screen of the step "Choose PricingPlan" in the "Schedule a Return" process
 */
@Composable
fun ScheduleReturn.PricingUI(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    onChangePlan: (PricingPlan) -> Unit = {},
    plan: PricingPlan? = null,
    guest: Boolean = false,
) {
    ScheduleReturnScaffold(
        step = 3,
        onClickNext = { /*TODO: navigate to package details */ },
        onClickBack = { /*TODO: navigate to pickup method */ },
        enabledNext = plan != null
    ) { padding ->
        PricingPlans(
            modifier = modifier.padding(padding),
            selected = plan,
            onClickPlan = onChangePlan,
            guest = guest,
        )
    }
}

class PricingViewModel(init: PricingPlan) : ViewModel() {
    private val _plan: MutableLiveData<PricingPlan>
    val plan: LiveData<PricingPlan>

    init {
        _plan = MutableLiveData(init)
        plan = _plan
    }

    fun onChangePlan(value: PricingPlan) {
        _plan.value = value
    }
}

@Composable
fun PricingUI(
    onChangePlan: (PricingPlan) -> Unit,
    modifier: Modifier = Modifier,
    plan: PricingPlan? = null,
    guest: Boolean = false,
) {
    PricingPlans(
        modifier = modifier,
        selected = plan,
        onClickPlan = onChangePlan,
        guest = guest,
    )
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun ChoosePlanPreview() {
    val viewmodel = remember { PricingViewModel(PricingPlan.BRONZE) }
    ScheduleReturn.PricingUI(
        plan = viewmodel.plan.value,
        onChangePlan = { viewmodel.onChangePlan(it) }
    )
}

@Composable
private fun PricingPlans(
    modifier: Modifier = Modifier,
    onClickPlan: (PricingPlan) -> Unit,
    selected: PricingPlan? = null,
    guest: Boolean = false,
    padding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        contentPadding = padding,
        modifier = modifier
            .fillMaxSize()
            .scale(1.25f)
    ) {
        item {
            BronzePlanButton(
                onClick = { onClickPlan(PricingPlan.BRONZE) },
                selected = selected == PricingPlan.BRONZE,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            SilverPlanButton(
                onClick = { onClickPlan(PricingPlan.SILVER) },
                selected = selected == PricingPlan.SILVER,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            GoldPlanButton(
                onClick = { onClickPlan(PricingPlan.GOLD) },
                selected = selected == PricingPlan.GOLD,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
        item {
            PlatinumPlanButton(
                onClick = { onClickPlan(PricingPlan.PLATINUM) },
                selected = selected == PricingPlan.PLATINUM,
                enabled = !guest,
                modifier = Modifier.padding(vertical=6.dp),
            )
        }
    }
}

@Composable
private fun BronzePlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PricingPlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        BronzePlanText()
    }
}

@Composable
private fun SilverPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PricingPlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        SilverPlanText()
    }
}

@Composable
private fun GoldPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PricingPlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        GoldPlanText()
    }
}

@Composable
private fun PlatinumPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    PricingPlanButton(
        modifier = modifier,
        onClick = onClick,
        selected = selected,
        enabled = enabled
    ) {
        PlatinumPlanText()
    }
}

@Composable
private fun PricingPlanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    enabled: Boolean = true,
    content: @Composable (BoxScope.() -> Unit)
) {
    var modifier = modifier
        .requiredSize(135.dp, 65.dp)
        .background(
            color = Color.White,
            shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
        )

    modifier =
        if (selected) {
            modifier.border(
                width = 6.dp,
                color = Color(0,180,250),
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
        } else {
            modifier.border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(22.dp,22.dp,22.dp,22.dp)
            )
        }
    ButtonManager.Button(
        onClick = onClick,
        enabled = enabled,
        color = Color.White,
        contentAlignment = Alignment.CenterStart,
        modifier = modifier,
        content = content
    )
}

@Composable
private fun SilverPlanText(modifier: Modifier = Modifier) {
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "SILVER",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(150, 170, 170),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
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
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "PLATINUM",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(125, 175, 175),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
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
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "GOLD",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(red = 230, green = 190, blue = 100),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
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
    Column(
        Modifier.offset(x=25.dp)
    ) {
        Text(
            text = "Bronze",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800),
            lineHeight = 10.sp,
            color = Color(200, 150, 100),
            fontSize = 16.0.sp,
            modifier = Modifier
                .padding(0.dp)
                .height(18.0.dp)
        )
        Text(
            text = buildAnnotatedString {
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