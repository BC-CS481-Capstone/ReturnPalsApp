package com.example.returnpals.composetools

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.ScheduleReturn
import com.example.returnpals.composetools.ButtonManager.DateSelector
import com.example.returnpals.mainMenu.MenuRoutes
import java.time.LocalDate

// TODO: set position so that date selector doesn't move when month changes

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleReturn.PickupDateUI(
    modifier: Modifier = Modifier,
    navController: NavController,
    onChangeDate: (LocalDate) -> Unit = {},
    minDate: LocalDate = LocalDate.now(),
    maxDate: LocalDate = LocalDate.now().plusMonths(1),
    date: LocalDate = LocalDate.now().plusDays(2),
) {
    ScheduleReturnScaffold(
        step = 1,
        onClickNext = {
            navController?.navigate(MenuRoutes.SelectAddress) {
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

        onClickBack = { /*TODO: navigate to dashboard or pickup address */ },
        enabledNext = date > minDate && date < maxDate
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .offset(0.dp, 10.dp),
                text = "Schedule a Return",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                modifier = Modifier.padding(20.dp, 0.dp),
                text = "When should we pickup your package?",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            DateSelector(
                date = date,
                onChangeDate = onChangeDate,
                modifier = modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            )
        }
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@SuppressLint("NewApi")

@Composable
private fun ChoosePlanPreview(navController : NavController) {
    ScheduleReturn.PickupDateUI(navController = navController)
}

// currently not used, but may be useful in future
@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun DateUI(
    modifier: Modifier = Modifier,
    date: LocalDate,
    onClickMonth: () -> Unit = {},
    onClickDay: () -> Unit = {},
    onClickYear: () -> Unit = {},
    textColor: Color = MaterialTheme.colorScheme.primary,
    fontWeight: FontWeight = FontWeight.Normal,
    border: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary,
        ),
    shape: Shape = RectangleShape
) {
    Row(
        modifier = modifier
    ) {
        OutlinedButton(
            modifier = Modifier.padding(4.dp),
            onClick = onClickMonth,
            border = border,
            shape = shape,
        ) {
            Text(
                text=date.month.toString(),
                fontWeight = fontWeight,
                color=textColor
            )
        }
        OutlinedButton(
            modifier = Modifier.padding(4.dp),
            onClick = onClickDay,
            border = border,
            shape = shape,
        ) {
            Text(
                text=date.dayOfMonth.toString(),
                fontWeight = fontWeight,
                color=textColor
            )
        }
        OutlinedButton(
            modifier = Modifier.padding(4.dp),
            onClick = onClickYear,
            border = border,
            shape = shape,
        ) {
            Text(
                text=date.year.toString(),
                fontWeight = fontWeight,
                color=textColor
            )
        }
    }
}