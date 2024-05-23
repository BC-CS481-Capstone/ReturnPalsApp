package com.example.returnpals.composetools.pickup

import SettingsViewModel
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.window.Dialog
import com.example.compose.ReturnPalTheme
import com.example.returnpals.AddressInfo
import com.example.returnpals.composetools.ScheduleReturnScaffold
import java.util.Locale

// A view model is necessary here to remember which address option was selected across screens.

fun getCountries(): List<String> {
    return Locale.getISOCountries().map { countryCode ->
        Locale("", countryCode).displayCountry
    }
}

@Composable
fun SelectAddressScreen(
    addresses: List<SettingsViewModel.SimpleAddress> = listOf(),
    selectedAddressId: Int? = null,
    onClickNext: () -> Unit = {},
    onClickBack: () -> Unit = {},
    onSelectAddress: (Int) -> Unit = {},
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
        if (isGuest)
            SelectAddressGuestContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            )
        else
            SelectAddressContent(
                selected = selectedAddressId,
                userAddresses = addresses,
                onSelectAddress = onSelectAddress,
                onAddAddress = onAddAddress,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            )
    }
}



@Composable
fun SelectAddressContent(
    selected: Int?,
    userAddresses: List<SettingsViewModel.SimpleAddress>,
    onSelectAddress: (Int) -> Unit,
    onAddAddress: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
    Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Your Addresses:",
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(userAddresses) { address ->
                val index = userAddresses.indexOf(address) + 1  // Assuming index as ID
                AddressItem(
                    address = address.address,
                    isSelected = selected == index,
                    onSelect = { onSelectAddress(index) }
                )
            }
        }
        AddAddressField(onAddAddress)
    }
}

@Composable
fun SelectAddressGuestContent(
    modifier: Modifier = Modifier
) {
    var address by remember { mutableStateOf(AddressInfo()) }
    Column(modifier) {
        AddressHeader()
        AddressFields(address, modifier.padding(20.dp)) { address = it }
    }
}

@Preview
@Composable
private fun SelectAddressPreview() {
    ReturnPalTheme {
        SelectAddressScreen(
            addresses = listOf(
                SettingsViewModel.SimpleAddress("1", "one"),
                SettingsViewModel.SimpleAddress("2", "two"),
                SettingsViewModel.SimpleAddress("3", "three"),
                SettingsViewModel.SimpleAddress("4", "four"),
                SettingsViewModel.SimpleAddress("5", "five"),
                SettingsViewModel.SimpleAddress("6", "six"),
                SettingsViewModel.SimpleAddress("7", "seven"),
                SettingsViewModel.SimpleAddress("8", "eight"),
                SettingsViewModel.SimpleAddress("9", "nine"),
                SettingsViewModel.SimpleAddress("10", "ten"),
            ),
            isGuest = true
        )
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
                fontWeight = FontWeight.Normal
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
}

@Composable
private fun AddAddressField(
    onAddAddress: (String) -> Unit,
    isGuest: Boolean = false,
) {
    var address by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(if (isGuest) "Enter your address" else "Enter new address") },
            modifier = Modifier.fillMaxWidth()
        )

        if (!isGuest) {
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

@Preview(showBackground = true)
@Composable
fun AddressDialogue(
    modifier: Modifier = Modifier,
    init: AddressInfo = AddressInfo(),
    title: String = "Add a new address",
    buttonText: String = "Add Address",
    onCancel: () -> Unit = {},
    onConfirm: (AddressInfo) -> Unit = {}
) {
    var address by remember { mutableStateOf(init) }
    Dialog(onDismissRequest = onCancel) {
        Column(modifier) {
            Text(
                text = title,
                color = ReturnPalTheme.colorScheme.secondary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(30.dp)
            )
            AddressFields(address) { address = it }
            Row {
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = { onConfirm(address) },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF008BE7),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                ) {
                    Text(buttonText)
                }
            }
        }
    }
}

@Composable
private fun AddressFields(
    address: AddressInfo,
    modifier: Modifier = Modifier,
    onChange: (AddressInfo) -> Unit = {},
) {
    val spacing = 20.dp
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        item {
            TextField(
                value = address.country,
                onValueChange = { onChange(address.copy(country=it)) },
                label = { Text(text = "Country") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(spacing))
        }
        item {
            TextField(
                value = address.street,
                onValueChange = { onChange(address.copy(street = it)) },
                label = { Text(text = "Street Address") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(spacing))
        }
        item {
            TextField(
                value = address.unit,
                onValueChange = { onChange(address.copy(unit = it)) },
                label = { Text(text = "Apt, Suite, Building, Floor, ect") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(spacing))
        }
        item {
            TextField(
                value = address.city,
                onValueChange = { onChange(address.copy(city = it)) },
                label = { Text(text = "City") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(spacing))
        }
        item {
            TextField(
                value = address.state,
                onValueChange = { onChange(address.copy(state = it)) },
                label = { Text(text = "Province or State") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(spacing))
        }
        item {
            TextField(
                value = address.zipcode,
                onValueChange = { onChange(address.copy(zipcode = it)) },
                label = { Text(text = "ZIP Code") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

