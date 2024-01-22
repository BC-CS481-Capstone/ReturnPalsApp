package com.example.returnpals.composetools

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.returnpals.R



@Composable
fun ProcessCard1(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onCardTap() }
            .padding(8.dp)
            .size(width = 210.dp, height = 140.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp

    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.blue_circle), // Replace with your actual image resource
                    contentDescription = "Card Icon",
                    modifier = Modifier.size(30.dp) // Adjust size as needed
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = "Schedule A Return",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Step-by-step guide to entering pickup details.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
            }
            }
        }
    }
}

@Composable
fun ProcessCard2(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onCardTap() }
            .padding(8.dp)
            .size(width = 210.dp, height = 140.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp

    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.blue_circle), // Replace with your actual image resource
                    contentDescription = "Card Icon",
                    modifier = Modifier.size(30.dp) // Adjust size as needed
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Select A Pickup Method",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Leave your package on your doorstep or hand it off to one of our specialists.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
            }
            }
        }
    }
}

@Composable
fun ProcessCard3(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onCardTap() }
            .padding(8.dp)
            .size(width = 210.dp, height = 140.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp

    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.blue_circle), // Replace with your actual image resource
                    contentDescription = "Card Icon",
                    modifier = Modifier.size(30.dp) // Adjust size as needed
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "We're On Our Way",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "We'll send you an email with your tracking number once it ships.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                        // fontFamily = customFont
                    )
                )
            }
            }
        }
    }
}

@Preview
@Composable
fun ProcessCards() {
    val customColor = Color(0xFFE1F6FF)
    var currentCard by remember { mutableStateOf(1) } // State to track the current visible card
    val cardOffsets = listOf(0.dp, 20.dp, 40.dp) // Define the offset for each card

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // Ensure the Box can lay its children out overlapping each other
        if (currentCard >= 1) {
            ProcessCard1(
                modifier = Modifier
                    .offset(x = cardOffsets[0], y = cardOffsets[0])
                    .zIndex(if (currentCard == 1) 3f else 1f), // Use zIndex to stack cards
                onCardTap = { currentCard = 2 }
            )
        }
        if (currentCard >= 2) {
            ProcessCard2(
                modifier = Modifier
                    .offset(x = cardOffsets[1], y = cardOffsets[1])
                    .zIndex(if (currentCard == 2) 3f else 1f), // Use zIndex to stack cards
                onCardTap = { currentCard = 3 }
            )
        }
        if (currentCard >= 3) {
            ProcessCard3(
                modifier = Modifier
                    .offset(x = cardOffsets[2], y = cardOffsets[2])
                    .zIndex(if (currentCard == 3) 3f else 1f), // Use zIndex to stack cards
                onCardTap = { currentCard = 1 }
            )
        }
    }
}
