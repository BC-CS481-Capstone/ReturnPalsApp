package com.example.returnpals.composetools.pickup

import SettingsViewModel
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ReturnPalTheme

// A view model is necessary here to remember which address option was selected across screens.


@Composable
fun SelectAddressScreen(
    addresses: List<SettingsViewModel.SimpleAddress> = listOf(),
    selectedAddressId: String? = null,
    onClickNext: () -> Unit = {},
    onClickBack: () -> Unit = {},
    onSelectAddress: (String) -> Unit = {},
    onAddAddress: (String) -> Unit = {},
    isGuest: Boolean = false,
) {

    if (addresses.isEmpty()) {
        Log.d("SelectAddressScreen", "No addresses available")
    } else {
        Log.d("SelectAddressScreen", "Addresses loaded: ${addresses.size}")
    }

    ScheduleReturnScaffold(
        step = 2,
        onClickBack = onClickBack,
        onClickNext = onClickNext,
        enabledNext = selectedAddressId != null,
    ) { padding ->
        SelectAddressContent(
            selected = selectedAddressId,
            userAddresses = addresses,
            onSelectAddress = onSelectAddress,
            onAddAddress = onAddAddress,
            onClickNext = onClickNext,
            onClickBack = onClickBack,
            isGuest = false,
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
        )
    }
}



@Composable
fun SelectAddressContent(
    selected: String?,
    userAddresses: List<SettingsViewModel.SimpleAddress>,
    onSelectAddress: (String) -> Unit,
    onAddAddress: (String) -> Unit,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    isGuest: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        AddressHeader()

        Spacer(modifier = Modifier.height(16.dp))
        AddressInfo()

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(userAddresses) { address ->
                AddressItem(
                    address = address.address,
                    isSelected = selected == address.id,
                    onSelect = { onSelectAddress(address.id) }
                )
            }

            item {AddAddressField(onAddAddress)}
        }


    }
}


@Composable
private fun AddressHeader() {
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
private fun AddressInfo(){
    Column {
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
fun AddAddressField(onAddAddress: (String) -> Unit) {
    var address by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Enter new address") },
            modifier = Modifier.fillMaxWidth()
        )


        Button(
            onClick = {
                if (address.isNotBlank()) {
                    onAddAddress(address)
                    address = ""

                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF008BE7),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.End)
        ) {
            Text("Add Address")
        }
    }
}

@Composable
private fun AddressItem(
    address: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect)
            .border(
                width = 2.dp,
                color = if (isSelected) ReturnPalTheme.colorScheme.primary
                else ReturnPalTheme.colorScheme.background
            )
            .background(ReturnPalTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null, // Disable RadioButton's default clickable behavior
            modifier = Modifier.scale(0.8f)
        )
        Spacer(modifier = Modifier.width(8.dp)) // Space between radio button and text
        Text(
            text = address,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.weight(1f)
        )
    }
}