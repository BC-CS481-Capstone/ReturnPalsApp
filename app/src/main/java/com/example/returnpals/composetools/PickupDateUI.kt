package com.example.returnpals.composetools

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

// TODO: suspected weird behavior with leap years

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickupDateUI(
    date: LocalDate,
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onChangeDate: (LocalDate) -> Unit,
) {
    val dateMin = LocalDate.now()
    // you can schedule up to 30 days ahead of time
    val dateMax = dateMin.plusDays(30)

    ScheduleReturnScaffold(
        step = 1,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enabledNext = date > dateMin && date < dateMax
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

            DatePickerUI(
                modifier = modifier
                    .fillMaxSize(),
                date = date,
                onChangeDate = onChangeDate
            )
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun DatePickerUI(
    modifier: Modifier = Modifier,
    date: LocalDate,
    onChangeDate: (LocalDate) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // PREVIOUS DATE
        DateUI(
            date=date
                .minusYears(0) // bug in java.time.LocalDate?????
                .minusMonths(1)
                .minusDays(1),
            textColor=MaterialTheme.colorScheme.primary.copy(alpha=0.75f),
            border=null,
            onClickMonth = { onChangeDate(date.minusMonths(1)) },
            onClickDay = { onChangeDate(date.minusDays(1)) },
            onClickYear = { onChangeDate(date.minusYears(1)) },
        )
        // SELECTED DATE
        DateUI(
            date=date,
            fontWeight=FontWeight.Bold,
        )
        // NEXT DATE
        DateUI(
            date=date
                .plusYears(1)
                .plusMonths(1)
                .plusDays(1),
            textColor=MaterialTheme.colorScheme.primary.copy(alpha=0.75f),
            border=null,
            onClickMonth = { onChangeDate(date.plusMonths(1)) },
            onClickDay = { onChangeDate(date.plusDays(1)) },
            onClickYear = { onChangeDate(date.plusYears(1)) },
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateUI(
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

@SuppressLint("NewApi")
@Preview(showBackground = true)
@Composable
private fun ChoosePlanPreview() {
    PickupDateUI(
        date = LocalDate.now(),
        onClickNext = {},
        onClickBack = {},
        onChangeDate = {}
    )
}