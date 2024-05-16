package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
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
//Defines TABLECELL
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
fun RowScope.ClickableTableCell(
    text: Int,
    weight: Float,
    openDialog: MutableIntState

){
    ClickableText(
        text = AnnotatedString(text.toString()),
        modifier = Modifier
            .border(.5.dp, Color.Black)
            .weight(weight)
            .padding(10.dp),
        style = TextStyle(
            color = Color.Blue,
            textDecoration = TextDecoration.Underline
        )
        ) { openDialog.intValue = text

    }
}

@Composable
//This function creates the OrderTable that will be displayed, listing the information of the order. Ideally, there will be a click option to show the uploaded image.
fun OrderTable(){
    val openDialog = remember {mutableIntStateOf(-1)}
    val orderList = Backend.orderList
    val column1Weight = .10f
    val column2Weight = .25f
    val column3Weight = .35f
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    when {
        openDialog.intValue >= 0 ->{
            OrderDialog({ openDialog.intValue = -1 }, orderList, openDialog.intValue)
        }
    }
    //This column contains the 
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
            Row(
                Modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp))
                    .clip(shape = RoundedCornerShape(topEnd = 15.dp))
                    .background(Color(0xFF084066))) {
                TableCell(text = "#", weight = column1Weight)
                TableCell(text = "Date", weight = column2Weight)
                TableCell(text = "Status", weight = column3Weight)
            }
            }


        items(1) {
            Log.i("Order", orderList.toString())
            var i = 0
            orderList.forEach{
                Log.i("Order", "Loading Item")
                Row(){
                    ClickableTableCell(text = i, column1Weight, openDialog)
                    TableCell(text = it.getDate().format(), column2Weight)
                    TableCell(text = it.getStatus(), column3Weight)
                }
                i++

            }

        }
    }
}
//This controls the dialog box that holds and displays the user data.
@Composable
fun OrderDialog(onDismissRequest: ()->Unit, orderList : MutableSet<OrderRepository>, index : Int) {
    val order = orderList.elementAt(index)
    Dialog(onDismissRequest = {onDismissRequest()}){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(16.dp)
        ){
            //This column dictates the internals of the dialog card
            Column(
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Spacer(Modifier.height(5.dp))
                Text("Return Info", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                Spacer(Modifier.height(5.dp))
                Row {
                    Text("Address: ")
                    Text(order.getAddress())

                }
                Row{
                    Text("Date: ")
                    Text(order.getDate().format())
                }
                Row{
                    Text("Method: ")
                    Text(order.getMethod())
                }
                Text("Confirmation Number: ")
                Text(order.getConfirmation())
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = onDismissRequest ) {Text("Cancel")

                }
            }
        }
    }
}
//This function gets orders, needs to be updated to account for the Order

