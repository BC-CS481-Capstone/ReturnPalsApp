package com.example.returnpals.mainMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun FAQ(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)
    Column(
        modifier = Modifier
            .background(customColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Our FAQs",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        // List of questions and answers
        ExpandableCard(question = "Do I have to package my item before returning it?",
            answer = "No, you don't have to worry about packaging. We will do it for you when we collect your item.")
        ExpandableCard(question = "Do I have to print my return label before returning it?",
            answer = "No, you don't have to print anything. Just upload your return label or recent to our app or website and we will print it for you.")
        ExpandableCard(question = "Can I return items on weekends or holidays?",
            answer = "Yes, you can return items anytime you want. We collect returns 24/7, 7 days a week.")
        ExpandableCard(question = "How fast will my item be shipped back to the retailer?",
            answer = "Usually, your item will be delivered to the post office within 12-24 hours of your return request.")
        ExpandableCard(question = "What id I'm returning multiple items to the same place?",
            answer = "You can return unlimited packages with our membership or add on a package for a small fee with the one time return order.")
        ExpandableCard(question = "What if I have more questions or need help?",
            answer = "Please contact us below. We are happy to assist you with any queries or issues.")

        // Add more for each FAQ
    }
}



@Composable
fun ExpandableCard(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Text(
                text = question,
                fontSize = 18.sp,
                color = Color.Black
            )
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = answer,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun FAQTest() {
    val customColor = Color(0xFFE1F6FF)
    Column(
        modifier = Modifier
            .background(customColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Our FAQs",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        // List of questions and answers
        ExpandableCard(question = "Do I have to package my item before returning it?",
            answer = "No, you don't have to worry about packaging. We will do it for you when we collect your item.")
        ExpandableCard(question = "Do I have to print my return label before returning it?",
            answer = "No, you don't have to print anything. Just upload your return label or recent to our app or website and we will print it for you.")
        ExpandableCard(question = "Can I return items on weekends or holidays?",
            answer = "Yes, you can return items anytime you want. We collect returns 24/7, 7 days a week.")
        ExpandableCard(question = "How fast will my item be shipped back to the retailer?",
            answer = "Usually, your item will be delivered to the post office within 12-24 hours of your return request.")
        ExpandableCard(question = "What id I'm returning multiple items to the same place?",
            answer = "You can return unlimited packages with our membership or add on a package for a small fee with the one time return order.")
        ExpandableCard(question = "What if I have more questions or need help?",
            answer = "Please contact us below. We are happy to assist you with any queries or issues.")

        // Add more for each FAQ
    }
}
