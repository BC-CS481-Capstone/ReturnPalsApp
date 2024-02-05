package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.returnpals.PickupMethod
import com.example.returnpals.ScheduleReturn

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

@Composable
fun ScheduleReturn.PickupMethodUI(
    navController: NavController,
    modifier: Modifier = Modifier,
    method: PickupMethod = PickupMethod.NONE
) {
    val selected = remember { mutableStateOf(method) }

    ScheduleReturnScaffold(
        step = 2,
        onClickNext = { /*TODO: navigate to choose plan */ },
        onClickBack = { /*TODO: navigate to pickup address or pickup date */ },
        enabledNext = selected.value != PickupMethod.NONE
    ) { padding ->
        Column(
            modifier = modifier
                .background(Color(210,240,245))
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PickupMethods(
                onClickMethod = {
                    selected.value = it
                    // TODO: send selected method to data layer
                },
                modifier = modifier,
                selected = selected.value,
            )
        }
    }
}

@Composable
fun PickupMethodUI(
    modifier: Modifier = Modifier,
    method: PickupMethod = PickupMethod.NONE
) {
    val selected = remember { mutableStateOf(method) }

    PickupMethods(
        onClickMethod = {
            selected.value = it
            // TODO: send selected method to data layer
        },
        modifier = modifier,
        selected = selected.value,
    )
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun PickupMethodPreview() {
    PickupMethodUI(
        method = PickupMethod.DOORSTEP
    )
}

@Composable
private fun PickupMethods(
    onClickMethod: (PickupMethod) -> Unit,
    modifier: Modifier = Modifier,
    selected: PickupMethod = PickupMethod.NONE
) {
    Column(
        modifier = modifier
            .background(Color(210,240,245))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.DOORSTEP) },
            isSelected = selected == PickupMethod.HANDOFF
        ) {
            DoorstepDescription()
        }
        Spacer(Modifier.height(15.dp))
        PickupMethodButton(
            onClick = { onClickMethod(PickupMethod.HANDOFF) },
            isSelected = selected == PickupMethod.DOORSTEP
        ) {
            HandOffDescription()
        }
    }
}

@Composable
private fun PickupMethodButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    content: @Composable() (BoxScope.() -> Unit)
) {
    var modifier = modifier
        .requiredSize(200.dp, 100.dp)
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

    ButtonManager.Button(
        modifier = modifier,
        onClick = onClick,
        color = Color.White,
        content = content
    )
}

@Composable
private fun HandOffDescription(
    modifier: Modifier = Modifier
) {
//    RelayVector(
//        vector = painterResource(R.drawable.pickup_details_method_vector1),
//        modifier = modifier
//            .offset(0.dp, 20.dp)
//    )
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = getFontFamily(),
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700),
                )
            ) {
                append("Direct Handoff\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = getFontFamily(),
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("Hand the package directly to our specialist at your door\n")
            }
        },
        modifier = modifier
            .requiredWidth(180.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun DoorstepDescription(
    modifier: Modifier = Modifier
) {
//    RelayVector(
//        vector = painterResource(R.drawable.pickup_details_method_vector7),
//        modifier = modifier
//            .offset(0.dp, 20.dp)
//    )
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = getFontFamily(),
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight(700),
                )
            ) {
                append("Leave on Doorstep\n")
            }
            withStyle(
                style = SpanStyle(
                    fontFamily = getFontFamily(),
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight(500)
                )
            ) {
                append("Place items outside your door ahead of your pick up window\n")
            }
        },
        modifier = modifier
            .requiredWidth(180.dp),
        textAlign = TextAlign.Center
    )
}