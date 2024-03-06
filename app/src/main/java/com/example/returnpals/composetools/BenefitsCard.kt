package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex



@Composable
fun BenefitCard1(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
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

                Column {
                    Text(
                        text = "Save time and energy by letting us handle all the repackaging and label printing for you",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                            // fontFamily = customFont
                        )
                    )
                }
            }
        }
}


@Composable
fun BenefitCard2(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
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

            Column {
                Text(
                    text = "No more waiting in long post office lines or dealing with confusing return processes",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                        // fontFamily = customFont
                    )
                )
            }
        }
    }
}


@Composable
fun BenefitCard3(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
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

            Column {
                Text(
                    text = "Convenient pickup service from your location, no need to leave the house",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                        // fontFamily = customFont
                    )
                )
            }
        }
    }
}

@Composable
fun BenefitCard4(modifier: Modifier = Modifier, onCardTap: () -> Unit) {
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

            Column {
                Text(
                    text = "Hassle-free returns for online purchases, making the whole process a breeze",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                        // fontFamily = customFont
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun BenefitCards() {
    val customColor = Color(0xFFE1F6FF)
    var currentCard by remember { mutableStateOf(1) } // State to track the current visible card
    val cardOffsets = listOf(0.dp, 20.dp, 40.dp, 60.dp) // Define the offset for each card

    Box(
        modifier = Modifier

    ) {

        if (currentCard >= 1) {
            BenefitCard1(
                modifier = Modifier
                    .offset(x = cardOffsets[0], y = cardOffsets[0])
                    .zIndex(if (currentCard == 1) 3f else 1f),
                onCardTap = { currentCard = 2 }
            )
        }
        if (currentCard >= 2) {
            BenefitCard2(
                modifier = Modifier
                    .offset(x = cardOffsets[1], y = cardOffsets[1])
                    .zIndex(if (currentCard == 2) 3f else 1f),
                onCardTap = { currentCard = 3 }
            )
        }
        if (currentCard >= 3) {
            BenefitCard3(
                modifier = Modifier
                    .offset(x = cardOffsets[2], y = cardOffsets[2])
                    .zIndex(if (currentCard == 3) 3f else 1f),
                onCardTap = { currentCard = 4 }
            )
        }
        if (currentCard >= 4) {
            BenefitCard4(
                modifier = Modifier
                    .offset(x = cardOffsets[3], y = cardOffsets[3])
                    .zIndex(if (currentCard == 4) 3f else 1f),
                onCardTap = { currentCard = 1 }
            )
        }
    }
}
