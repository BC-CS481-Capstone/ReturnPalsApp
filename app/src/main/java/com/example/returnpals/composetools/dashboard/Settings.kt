package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController




@Composable
fun Settings(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        SettingsContent(navController = navController)
    }
}
@Composable
fun SettingsContent(navController: NavController){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item { AccountCard()}

        item { NotificationsCard()}


    }
}


@Preview
@Composable
fun AccountCard() {
    val selectedBlue = Color(0xFF008BE7)
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    val cardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,   // Default elevation
        pressedElevation = 12.dp,  // Elevation when the card is pressed
        focusedElevation = 10.dp,  // Elevation when the card is focused
        hoveredElevation = 10.dp,  // Elevation when the card is hovered
        draggedElevation = 16.dp   // Elevation when the card is dragged
    )


    Card (
        modifier = Modifier
            .height(300.dp)
            .width(400.dp)
            .padding(16.dp),
            elevation = cardElevation

    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colors = gradientColors))
                .padding(16.dp)

        ){
            Text(text = "Account",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))



            Text(text = "Password",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = selectedBlue,
                    )
                ){
                Text(text = "Change Password",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Addresses",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(160.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = selectedBlue,
                )
            ){
                Text(text = "Update/Delete",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))


        }
    }
}

@Preview
@Composable
fun NotificationsCard() {
    val selectedBlue = Color(0xFF008BE7)
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    val cardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,   // Default elevation
        pressedElevation = 12.dp,  // Elevation when the card is pressed
        focusedElevation = 10.dp,  // Elevation when the card is focused
        hoveredElevation = 10.dp,  // Elevation when the card is hovered
        draggedElevation = 16.dp   // Elevation when the card is dragged
    )

    Card (
        modifier = Modifier
            .height(300.dp)
            .width(400.dp)
            .padding(16.dp),
            elevation = cardElevation
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colors = gradientColors))
                .padding(16.dp)
        ){
            Text(text = "Notifications",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(text = "Alerts",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Location",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}



