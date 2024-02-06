package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
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
import com.example.returnpals.composetools.OrderInfo

@Composable
fun Orders(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        OrdersContent()
    }
}

@Preview
@Composable
fun OrdersContent(){
    OrderTable()

}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
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
fun OrderTable(){
    val orderList = getOrders()
    val column1Weight = .4f
    val column2Weight = .7f
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
            }
            }
        items(orderList.size){ index ->
            Row(){
                TableCell(text = orderList[index].status, column1Weight)
                TableCell(text = orderList[index].date, column2Weight)
            }
        }
    }
}

fun getOrders(): ArrayList<OrderInfo>{
    //Access database for each order with this client's details, pass them to OrderInfo class
    var orders = ArrayList<OrderInfo>()
    for(i in 1..10 ){
        orders.add(OrderInfo("TBD", "2/1/24"))
    }
    return orders;
}
