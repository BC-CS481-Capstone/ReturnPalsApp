package com.example.returnpals.dashboard

import DashboardMenuScaffold
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.mainMenu.MenuRoutes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickupProcess(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        PickupProcessContent(navController = navController)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickupProcessContent(navController: NavController) {
    WeekPickupCard(navController = navController)
}


@Composable
fun PickupCard(
    month: String,
    date: Int,
    day: String,
    onCardClick: () -> Unit,
    isClicked: Boolean // Accept isClicked as a parameter
) {
    val borderColor = if (isClicked) Color(0xFF008BE7) else Color.Black
    val borderWidth = if (isClicked) 4.dp else 2.dp

    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(width = 80.dp, height = 100.dp)
            .clickable(onClick = onCardClick)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(15.dp)
            ),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = if (isClicked) Color.White else Color.Transparent
    ){
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = month, color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = date.toString(), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = day, color = Color.Gray, fontSize = 14.sp)
        }
    }
}




@Composable
fun NextButton(isEnabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = isEnabled, // The button is enabled based on the isEnabled parameter
        modifier = Modifier
            .fillMaxWidth() // You can adjust the width as per your design
            .padding(16.dp) // Add padding around the button
    ) {
        Text("Next")
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun getWeekData(startingDate: LocalDate): List<Triple<String, Int, String>> {
    return (0..6).map { offset ->
        val currentDate = startingDate.plusDays(offset.toLong())
        val month = currentDate.format(DateTimeFormatter.ofPattern("MMM"))
        val date = currentDate.dayOfMonth
        val dayOfWeek = currentDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
        Triple(month, date, dayOfWeek)
    }
}

@SuppressLint("PrivateResource")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekPickupCard(navController: NavController) {
    // State to keep track of the starting date of the displayed week
    var currentWeekStartDate by remember { mutableStateOf(LocalDate.now()) }
    val today = LocalDate.now()

    // Function to update the week
    fun updateWeek(daysToAdd: Long) {
        currentWeekStartDate = currentWeekStartDate.plusDays(daysToAdd)
    }

    // Generate data for the current week
    val weekData = getWeekData(currentWeekStartDate)


    var selectedDay by remember { mutableStateOf<LocalDate?>(null) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display cards for the week in a 3x3 grid
        for (i in 0..2) {
            Row {
                for (j in 0..2) {
                    val index = i * 3 + j
                    if (index < weekData.size) {
                        val (month, date, day) = weekData[index]
                        val fullDate = LocalDate.of(currentWeekStartDate.year, currentWeekStartDate.month, date)
                        val isCardSelected = selectedDay == fullDate
                        PickupCard(
                            month = month,
                            date = date,
                            day = day,
                            onCardClick = {
                                if (fullDate >= today) {
                                    selectedDay = if (isCardSelected) null else fullDate // Unselect if already selected, else select new
                                }
                            },
                            isClicked = isCardSelected // Pass the selection state to the card
                        )
                    }
                }
            }
        }

        // Buttons for previous and next week
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = { if (currentWeekStartDate.minusDays(7) >= today) updateWeek(-7) }) {
                Icon(imageVector = ImageVector.vectorResource(id = com.google.android.material.R.drawable.material_ic_keyboard_arrow_left_black_24dp), contentDescription = "Previous Week")
            }
            IconButton(onClick = { updateWeek(7) }) {
                Icon(imageVector = ImageVector.vectorResource(id = com.google.android.material.R.drawable.material_ic_keyboard_arrow_right_black_24dp), contentDescription = "Next Week")
            }
        }

        NextButton(
            isEnabled = selectedDay != null && selectedDay!! >= today, // Button is enabled based on the selected day
            onClick = {
                navController.navigate(MenuRoutes.SelectAddress) {
                    // Clear all the back stack up to the start destination and save state
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when reselecting the same item
                    launchSingleTop = true
                    // Restore state when navigating back to the composable
                    restoreState = true
                }

            }
        )
    }
}