package com.example.returnpals.composetools.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.composetools.AddressItem
import com.example.returnpals.composetools.ScheduleReturnScaffold
import com.example.returnpals.mainMenu.MenuRoutes

@Composable
fun SelectAddress(navController: NavController) {

    ScheduleReturnScaffold(
        step = 2,
        onClickNext = {navController.navigate(MenuRoutes.PickupDetails) {
            // Clear all the back stack up to the start destination and save state
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when reselecting the same item
            launchSingleTop = true
            // Restore state when navigating back to the composable
            restoreState = true
        }},
        onClickBack = {navController.navigate(MenuRoutes.PickupProcess) {
            // Clear all the back stack up to the start destination and save state
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when reselecting the same item
            launchSingleTop = true
            // Restore state when navigating back to the composable
            restoreState = true
        }},
        enabledNext = true
    ){
        SelectAddressContent(navController = navController)
    }
}


@Composable
fun SelectAddressContent(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)
    var selectedAddress by remember { mutableStateOf<AddressItem?>(null) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(customColor)
            .padding(16.dp)
    ){
        item { AddressHeader() }

        item { AddressInfo() }

        item {
            AddressSelectionScreen(onAddressSelected = { address ->
                selectedAddress = address
            })
        }

    }
}

@Composable
fun AddressHeader(){
    Column {
        Text(
            text = "Pickup Details",
            style = TextStyle(
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,

            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Select or add your pickup address",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        )
    }
    Spacer(modifier = Modifier.height(88.dp))
}

@Composable
fun AddressInfo(){

    Column (

    ){
        Text(
            text = "Your Addresses:",
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )
        )

    }
}
@Composable
fun AddressItemComposable(addressItem: AddressItem, isSelected: Boolean, onSelect: (AddressItem) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(addressItem) }
            .padding(16.dp)
    ) {
        // Circle selector
        Canvas(modifier = Modifier.size(24.dp), onDraw = {
            drawCircle(
                color = if (isSelected) Color.Green else Color.Gray,
                radius = size.minDimension / 3
            )
        })

        Spacer(Modifier.width(16.dp))

        // Address text
        Text(text = addressItem.address, style = MaterialTheme.typography.body1)
    }
}

@Composable
fun AddressSelectionScreen(onAddressSelected: (AddressItem?) -> Unit) {
    val addresses = remember { mutableStateListOf(
        AddressItem(1, "123 Your Address One"),
        AddressItem(2, "456 Your Address Two")
        // ... existing addresses
    )}
    var selectedAddress by remember { mutableStateOf<AddressItem?>(null) }

    // Function to add a new address
    val addNewAddress: (String) -> Unit = { newAddress: String ->
        val newId = (addresses.maxOfOrNull { it.id } ?: 0) + 1
        val newAddressItem = AddressItem(newId, newAddress)
        addresses.add(newAddressItem)
        selectedAddress = newAddressItem  // Optionally auto-select the new address
        onAddressSelected(newAddressItem) // Notify the parent composable
    }

    Column {
        addresses.forEach { addressItem ->
            AddressItemComposable(
                addressItem = addressItem,
                isSelected = addressItem == selectedAddress,
                onSelect = {
                    selectedAddress = it
                    onAddressSelected(it)
                }
            )
        }

        AddAddress(onAddAddress = addNewAddress)
    }
}

@Composable
fun AddAddress(onAddAddress: (String) -> Unit) {
    val selectedBlue = Color(0xFF008BE7)
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter new address") }
        )

        Button(

            onClick = {
                if (text.isNotBlank()) {
                    onAddAddress(text)
                    text = "" // Clear the text field
                }
            },
            modifier = Modifier.padding(top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectedBlue,
                contentColor = Color.White
            )

        ) {
            Text("Add Address")
        }
    }
}



