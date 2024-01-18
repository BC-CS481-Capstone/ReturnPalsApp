package com.example.returnpals.composetools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

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

}