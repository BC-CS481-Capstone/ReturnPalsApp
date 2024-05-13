package com.returnpal.androidapp.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import java.time.LocalDate

/**
 * This is the button manager class. Use this class to call buttons.
 */
object ButtonManager {

    @Deprecated(
        message = "A better alternative exists",
        replaceWith = ReplaceWith("Button", "androidx.compose.material3.Button"),
        level = DeprecationLevel.WARNING)
    @Composable
    fun Button(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        enabled: Boolean = true,
        color: Color = Color(0, 138, 230),
        border: BorderStroke? = null,
        shape: Shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp),
        contentAlignment: Alignment = Alignment.Center,
        content: @Composable() (BoxScope.() -> Unit)
    ) {
        var modifier = modifier
            .clickable(enabled = true, onClick = onClick)
            .background(
                color = color,
                shape = shape
            )

        if (border != null) {
            modifier = modifier
                .border(
                    border = border,
                    shape = shape
                )
        }

        Box(
            modifier = modifier,
            contentAlignment = contentAlignment,
            content = content
        )
    }

    @Composable
    fun NextButton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        text: String = "Next",
        enabled: Boolean = true,
    ) {
        androidx.compose.material3.Button(
            modifier = modifier,
            onClick = onClick,
            enabled = enabled,
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun BackButton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        text: String = "Back",
        enabled: Boolean = true,
    ) {
        OutlinedButton(
            modifier = modifier,
            onClick = onClick,
            enabled = enabled,
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun WheelSelector(
        selectedText: String,
        previousText: String,
        nextText: String,
        onClickPrevious: () -> Unit,
        onClickNext: () -> Unit,
        modifier: Modifier = Modifier,
        onClickSelected: () -> Unit = {},
        horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                text = previousText,
                onClick = onClickPrevious,
                textColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f),
                border = null
            )
            OutlinedButton(
                text = selectedText,
                onClick = onClickSelected,
                fontWeight= FontWeight.Bold,
            )
            OutlinedButton(
                text = nextText,
                onClick = onClickNext,
                textColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f),
                border = null
            )
        }
    }

    @Composable
    fun OutlinedButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        textColor: Color = MaterialTheme.colorScheme.primary,
        fontWeight: FontWeight = FontWeight.Normal,
        border: BorderStroke? = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary,
        ),
        shape: Shape = RectangleShape,
    ) {
        OutlinedButton(
            modifier = modifier,
            onClick = onClick,
            border = border,
            shape = shape,
        ) {
            Text(
                text = text,
                fontWeight = fontWeight,
                color = textColor
            )
        }
    }

    @SuppressLint("NewApi")
    @Composable
    fun DateSelector(
        modifier: Modifier = Modifier,
        date: LocalDate,
        onChangeDate: (LocalDate) -> Unit,
        verticalAlignment: Alignment.Vertical = Alignment.Top,
        horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = verticalAlignment,
            horizontalArrangement = horizontalArrangement,
        ) {
            WheelSelector(
                onClickPrevious = { onChangeDate(date.minusMonths(1)) },
                onClickNext = { onChangeDate(date.plusMonths(1)) },
                previousText = date.minusMonths(1).month.toString(),
                selectedText = date.month.toString(),
                nextText = date.plusMonths(1).month.toString(),
                horizontalAlignment = Alignment.End
            )
            Spacer(Modifier.width(5.dp))
            WheelSelector(
                onClickPrevious = { onChangeDate(date.minusDays(1)) },
                onClickNext = { onChangeDate(date.plusDays(1)) },
                previousText = date.minusDays(1).dayOfMonth.toString(),
                selectedText = date.dayOfMonth.toString(),
                nextText = date.plusDays(1).dayOfMonth.toString(),
            )
            Spacer(Modifier.width(5.dp))
            WheelSelector(
                onClickPrevious = { onChangeDate(date.minusYears(1)) },
                onClickNext = { onChangeDate(date.plusYears(1)) },
                previousText = date.minusYears(1).year.toString(),
                selectedText = date.year.toString(),
                nextText = date.plusYears(1).year.toString(),
                horizontalAlignment = Alignment.Start
            )
        }
    }

}