package com.example.returnpals.mainMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.returnpals.R
import com.example.returnpals.composetools.BenefitCards
import com.example.returnpals.composetools.ProcessCards



@Composable
fun Home(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)
    val selectedBlue = Color(0xFF008BE7)
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    // val customFont = FontFamily(Font(R.font.you_font_file))

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(customColor),
            .background(Brush.verticalGradient(colors = gradientColors)),
            horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Return Your Package",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            )
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
                .padding(8.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = selectedBlue,
                    contentColor = Color.White
                ),

            ) {
                Text(
                    text = "Schedule Now",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,

                    )
                )

            }

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Our Process",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                //fontFamily = customFont
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        ProcessCards()


        Text(
            text = "Your Benefits",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            ),
            modifier = Modifier
                .padding(8.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        BenefitCards()


        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(customColor)
                .padding(16.dp)
        ){
            Text(
                text = "DROP OFFS MADE EASY",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    // fontFamily = customFont
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Your scheduled pickup is retrieved by us right from your door and on its way to our assigned courier",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        // fontFamily = customFont
                    ),
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.back_truck),
                    contentDescription = "Van Icon",
                    modifier = Modifier
                        .size(100.dp) // Adjust size as needed
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun HomeTest() {
    val customColor = Color(0xFFE1F6FF)
    var currentCard by remember { mutableStateOf(1) }
    // val customFont = FontFamily(Font(R.font.you_font_file))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(customColor),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
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
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Button(onClick = { /*TODO*/ }) {

            }
            Spacer(modifier = Modifier.width(25.dp))

            Button(onClick = { /*TODO*/ }) {

            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Our Process",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                //fontFamily = customFont
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProcessCards()

    }
}