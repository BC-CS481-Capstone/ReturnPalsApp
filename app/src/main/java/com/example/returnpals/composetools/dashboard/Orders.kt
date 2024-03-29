package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.returnpals.composetools.OrderRepository
import com.example.returnpals.services.Backend

@Composable
//Deviates from needing to pass NavController.
fun Orders(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        OrdersContent()
    }
}

@Preview
//Gets the content
@Composable
fun OrdersContent(){
    OrderTable()

}

@Composable
//Defines TableCell
fun RowScope.TableCell(
    text: String,
    weight: Float,
){
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
//This function creates the OrderTable that will be displayed, listing the information of the order. Ideally, there will be a click option to show the uploaded image.
fun OrderTable(){
    val orderList = Backend.orderList
    val column1Weight = .2f
    val column2Weight = .25f
    val column3Weight = .4f
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors))
            .padding(16.dp),
    ){
        item{
            Text(
                text = "Order History:",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                    )
            )
        }
        item {
            Row(Modifier.background(Color.Gray)) {
                TableCell(text = "Status", weight = column1Weight)
                TableCell(text = "Date", weight = column2Weight)
                TableCell(text = "Address", weight = column3Weight)
            }
            }


        items(1) {
            Log.i("Order", orderList.toString())
            orderList.forEach{
                Log.i("Order", "Loading Item")
                Row(){
                    TableCell(text = it.getStatus(), column1Weight)
                    TableCell(text = it.getDate().substring(0, 10), column2Weight)
                    TableCell(text = it.getAddress(), column3Weight)

                }

            }

        }
    }
}
//This function gets orders, needs to be updated to account for the Order

