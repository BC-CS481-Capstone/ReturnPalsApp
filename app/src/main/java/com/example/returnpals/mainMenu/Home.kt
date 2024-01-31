package com.example.returnpals.mainMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Home(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)
    // val customFont = FontFamily(Font(R.font.you_font_file))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(customColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Align the content to the top
    ) {
        Text(
            text = "Return Your Package",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            ),
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = "The Easy Way",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                // fontFamily = customFont
            ),
            modifier = Modifier
                .padding(8.dp)
        )
    }
}


@Preview
@Composable
fun HomeTest() {
    val customColor = Color(0xFFE1F6FF)
    // val customFont = FontFamily(Font(R.font.you_font_file))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(customColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Align the content to the top
    ) {
        Text(
            text = "Return Your Package",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            ),
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = "The Easy Way",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                // fontFamily = customFont
            ),
            modifier = Modifier
                .padding(8.dp)
        )
    }
}