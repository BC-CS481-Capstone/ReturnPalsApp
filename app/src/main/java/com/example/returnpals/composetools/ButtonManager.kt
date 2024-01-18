package com.example.returnpals.composetools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ButtonManager {
    /*
    This is the button manager class. Use this class to call buttons.
    * */
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
        text: String = "Next"
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = modifier
        ) {
            Text(
                text = text,
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Color(0, 138, 230),
                        shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 22.dp)
                    )
                    .padding(12.dp, 6.dp)
                    .clickable(enabled = true, onClick = onClick)
            )
        }
    }

    @Composable
    fun BackButton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        text: String = "Back"
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
        ) {
            Text(
                text = text,
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily.SansSerif,
                color = Color(0, 138, 230),
                modifier = Modifier
                    .clickable(enabled = true, onClick = onClick)
                    .padding(12.dp, 6.dp)
            )
        }
    }
}