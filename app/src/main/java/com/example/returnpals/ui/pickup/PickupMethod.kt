package com.example.returnpals.ui.pickup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.ui.theme.ReturnPalTheme
import com.example.returnpals.PickupMethod
import com.example.returnpals.R
import com.example.returnpals.ui.getFontFamily

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

@Composable
fun PickupMethodScreen(
    method: PickupMethod?,
    onChangeMethod: (PickupMethod) -> Unit,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ScheduleReturnScaffold(
        step = 2,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enabledNext = method != null
    ) { padding ->
        Column(
            modifier = modifier
                .background(Color(210, 240, 245))
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PickupMethodContent(
                onClickMethod = onChangeMethod,
                modifier = modifier,
                selected = method,
            )
        }
    }
}

@Composable
fun PickupMethodContent(
    onClickMethod: (PickupMethod) -> Unit,
    modifier: Modifier = Modifier,
    selected: PickupMethod? = null
) {
    Column(
        modifier = modifier
            .background(Color(210, 240, 245))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.DOORSTEP) },
            selected = selected == PickupMethod.DOORSTEP,
            modifier = Modifier.testTag(PickupMethod.DOORSTEP.toString())
        ) {
            DoorstepMethodContent()
        }
        Spacer(Modifier.height(15.dp))
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.HANDOFF) },
            selected = selected == PickupMethod.HANDOFF,
            modifier = Modifier.testTag(PickupMethod.HANDOFF.toString())
        ) {
            HandOffTMethodContent()
        }
    }
}



/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun PickupMethodPreview() {
    ReturnPalTheme {
        PickupMethodScreen(
            method = PickupMethod.DOORSTEP,
            onChangeMethod = {},
            onClickNext = {},
            onClickBack = {}
        )
    }
}

@Composable
private fun PickupMethodButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean = false,
    content: @Composable() (RowScope.() -> Unit)
) {
    OutlinedButton(
        modifier = modifier.requiredWidth(250.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = ReturnPalTheme.colorScheme.primaryContainer),
        border =
            if (selected) {
                BorderStroke(
                    width = 6.dp,
                    color = ReturnPalTheme.colorScheme.primary,
                )
            } else {
                BorderStroke(
                    width = 4.dp,
                    color = ReturnPalTheme.colorScheme.inversePrimary,
                )
            },
        shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp),
        content = content
    )
}

@Composable
private fun HandOffTMethodContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Direct Handoff",
            fontFamily = getFontFamily(),
            fontSize = 18.0.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(4.dp)
        )
        Row {
            Icon(
                painter = painterResource(R.drawable.handoff_500x500),
                contentDescription = null,
                tint = ReturnPalTheme.colorScheme.primary,
                modifier = Modifier
                    .scale(0.6f)
                    .size(100.dp)
            )
            Text(
                text = "Hand the package directly to our specialist at your door",
                fontFamily = getFontFamily(),
                fontSize = 14.0.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Left,
                modifier = Modifier.requiredWidth(110.dp)
            )
        }
    }
}

@Composable
private fun DoorstepMethodContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Leave on Doorstep",
            fontFamily = getFontFamily(),
            fontSize = 18.0.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(4.dp)
        )
        Row {
            Icon(
                painter = painterResource(R.drawable.doorstep_500x440),
                contentDescription = null,
                tint = ReturnPalTheme.colorScheme.primary,
                modifier = Modifier
                    .scale(0.6f)
                    .size(100.dp)
            )
            Text(
                text = "Place items outside your door ahead of your pick up window",
                fontFamily = getFontFamily(),
                fontSize = 14.0.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Left,
                modifier = Modifier.requiredWidth(110.dp)
            )
        }
    }
}