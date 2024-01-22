package com.example.returnpals.mainMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.returnpals.R

@Composable
fun About(navController: NavController) {
    //val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    LazyColumn(
        modifier = Modifier
            //.background(Brush.verticalGradient(colors = gradientColors))
            .background(Color.White)
            .fillMaxSize()
        //.padding(16.dp),
    ) {
        item {MissionStatement()}
        item { SocialImpact() }
        item {GTA()}
        item { ChooseRP()}
    }
}

@Composable
fun MissionStatement() {
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){
        Text(
            text = "Mission Statement",
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
                text = "Our mission at ReturnPal is to revolutionize the way returns are done by providing a hassle-free and convenient solution for online shoppers.\n" +
                        "\n" +
                        "We aim to take the stress out of the return process by handling the entire repackaging and delivery process, allowing customers to sit back and relax.",
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
                painter = painterResource(id = R.drawable.loading),
                contentDescription = "Van Icon",
                modifier = Modifier
                    .size(100.dp) // Adjust size as needed
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun SocialImpact(){
    val customColor = Color(0xFFE1F6FF)
    Column ( modifier = Modifier
        .background(customColor)
        .fillMaxSize()
        .padding(16.dp)
    ){
        Text(
            text = "Social Impact",
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
                text = "ReturnPal focuses on sustainability and community empowerment, that is why we’re minimizing waste by partnering with companies and agencies like Play Forever to redistribute unsold or unused returns. The returns are sorted, refurbished if needed, and redistributed to various communities in need.",
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
                painter = painterResource(id = R.drawable.globe),
                contentDescription = "Van Icon",
                modifier = Modifier
                    .size(100.dp) // Adjust size as needed
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun GTA(){
    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Row {
            Image(
                painter = painterResource(id = R.drawable.hand_off),
                contentDescription = "Hand Off Icon",
                modifier = Modifier
                    .size(130.dp) // Adjust size as needed
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "As a convenient one-stop service, We're bringing couriers to your location, repackaging, and delivering your return to a predefined location.\n" +
                        "\n" +
                        "Our goal is to save you from having to repackage items, print shipping labels, and take that long drive to the not so local post office.",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    // fontFamily = customFont
                ),
                modifier = Modifier.weight(1f)
            )


        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.returnpal_gta),
                contentDescription = "GTA Icon",
                modifier = Modifier
                    .size(130.dp) // Adjust size as needed
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "We are all over the GTA, with a local facility in Toronto designed to ensure shipping labels are printed and the repackaging of items can meet same-day return needs.\n" +
                        "\n" +
                        "Returning your online shopping purchases has never been easier.",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    // fontFamily = customFont
                ),
                modifier = Modifier.weight(1f)
            )

        }
    }
}

@Composable
fun ChooseRP(){
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors))
            .padding(16.dp)

    ){

        Text(
            text = "Why Choose ReturnPal?",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                // fontFamily = customFont
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Our service allows everyday shoppers to return items with just a click of a button, all without leaving home. We also integrate seamlessly with existing business operations, making it easier for companies to offer hassle-free returns while maintaining customer satisfaction. What sets ReturnPal apart is our collaboration with brands to repurpose unsold or returned goods. We achieve this by partnering with various nonprofits and charities.",
            style = TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                // fontFamily = customFont
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Choosing ReturnPal is a win-win for everyone involved. It simplifies the return process, promotes a more sustainable way of doing business, and ultimately improves the quality of life for our customers. Our focus on simplifying returns, fostering sustainability, and improving quality of life has resonated with both consumers and businesses, making a real difference in the way online shopping returns are handled.",
            style = TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                // fontFamily = customFont
            )
        )
    }

}

@Preview
@Composable
fun AboutTest() {
    //val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    LazyColumn(
        modifier = Modifier
            //.background(Brush.verticalGradient(colors = gradientColors))
            .background(Color.White)
            .fillMaxSize()
            //.padding(16.dp),
    ) {
        item {MissionStatement()}
        item {SocialImpact()}
        item {GTA()}
        item { ChooseRP()}
    }
}