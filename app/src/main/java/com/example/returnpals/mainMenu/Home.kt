package com.example.returnpals.mainMenu

import MainMenuScaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.R
import com.example.returnpals.composetools.BenefitCards
import com.example.returnpals.composetools.ProcessCards


@Composable
fun Home(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        HomeContent(navController = navController)
    }
}


@Composable
fun HomeContent(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)
    val selectedBlue = Color(0xFF008BE7)
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    val title = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Normal)) {
            append("Return Your Package" + "\n")
        }
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Normal)) {
            append("The")
        }
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)) {
            append(" Easy Way")
        }
    }

    val op = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Normal)) {
            append("Our ")
        }
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)) {
            append("Process")
        }
    }

    val yb = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Normal)) {
            append("Your ")
        }
        withStyle(style = SpanStyle(color = selectedBlue, fontSize = 30.sp, fontWeight = FontWeight.Bold)) {
            append("Benefits")
        }
    }

    val dropoff = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Normal)) {
            append("DROP OFFS MADE ")
        }
        withStyle(style = SpanStyle(color = selectedBlue, fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
            append("EASY")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = title)
        Spacer(modifier = Modifier.height(16.dp))

        // ScheduleNow Button
        Button(
            onClick = {
                // Navigate to the DashboardMenu screen
                navController.navigate(MenuRoutes.HomeDash) {
                    // Clear all the back stack up to the start destination and save state
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when reselecting the same item
                    launchSingleTop = true
                    // Restore state when navigating back to the composable
                    restoreState = true
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectedBlue,
                contentColor = Color.White
            )
        ) {
            Text("Schedule Now") // Replace with your button text
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = op)
        Spacer(modifier = Modifier.height(8.dp))
        ProcessCards()
        Text(text = yb)
        Spacer(modifier = Modifier.height(8.dp))
        BenefitCards()
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(customColor)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = dropoff)
                Text(
                    text = "Your scheduled pickup is retrieved by us right from your door and on its way to our assigned courier",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                        // fontFamily = customFont
                    ),
                    modifier = Modifier.weight(1f)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.back_truck),
                contentDescription = "Van Icon",
                modifier = Modifier
                    .size(100.dp) // Adjust size as needed
                    .align(Alignment.Top)
            )
        }
    }
}

///////////////////////////////////Test///////////////////////////////////////////////////////
