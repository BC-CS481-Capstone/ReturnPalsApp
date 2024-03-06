package com.example.returnpals.composetools.pickup

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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
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
import com.example.returnpals.composetools.ScheduleReturnScaffold

// A view model is necessary here to remember which address option was selected across screens.

@Composable
fun SelectAddressScreen(
    selectedAddressId: Int? = null,
    addresses: Map<Int, String> = mapOf(),
    onSelectAddress: (Int) -> Unit = {},
    onAddAddress: (String) -> Unit = {},
    onClickNext: () -> Unit  = {},
    onClickBack: () -> Unit  = {},
    isGuest: Boolean = false,
) {
    val customBlue = Color(0xFFE1F6FF)

    ScheduleReturnScaffold(
        step = 2,
        onClickBack = onClickBack,
        onClickNext = onClickNext,
        enabledNext = selectedAddressId != null,
    ) { padding ->
        SelectAddressContent(
            selected = selectedAddressId,
            addresses = addresses,
            onAddAddress = onAddAddress,
            onSelectAddress = onSelectAddress,
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
        )
    }
}

@Composable
fun SelectAddressContent(
    modifier: Modifier = Modifier,
    selected: Int? = null,
    addresses: Map<Int, String> = mapOf(),
    onAddAddress: (String) -> Unit = {},
    onSelectAddress: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
    ) {
        item { AddressHeader() }
        item { AddressInfo() }
        item {
            AddressOptions(
                selected = selected,
                addresses = addresses,
                onSelectAddress = onSelectAddress,
//                modifier = Modifier.background(
//                    ReturnPalTheme.colorScheme.secondaryContainer
//                )
            )
        }
        item {
            AddAddressField(
                onAddAddress = onAddAddress
            )
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
private fun AddressItem(
    address: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect)
            .border(
                width = 2.dp,
                color =
                    if (isSelected) ReturnPalTheme.colorScheme.primary
                    else ReturnPalTheme.colorScheme.background
            )
            .background(ReturnPalTheme.colorScheme.secondaryContainer)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = {},
            modifier = Modifier
                .scale(.7f)
                .requiredSize(12.dp)
                .weight(.2f)
        )

        // Circle selector
//        Canvas(modifier = Modifier.size(24.dp), onDraw = {
//            drawCircle(
//                color = if (isSelected) Color.Green else Color.Gray,
//                radius = size.minDimension / 3
//            )
//        })

        // Address text
        Text(
            text = address,
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp).weight(1f)
        )
    }
}

@Composable
private fun AddressOptions(
    modifier: Modifier = Modifier,
    selected: Int? = null,
    addresses: Map<Int, String> = mapOf(),
    onSelectAddress: (Int) -> Unit = {},
) {
    Column(modifier) {
        addresses.forEach { option ->
            AddressItem(
                address = option.value,
                isSelected = option.key == selected,
                onSelect = { onSelectAddress(option.key) }
            )
        }
    }
}

@Composable
private fun AddAddressField(onAddAddress: (String) -> Unit) {
    val selectedBlue = Color(0xFF008BE7)
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter new address") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    onAddAddress(text)
                    text = "" // Clear the text field
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectedBlue,
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

@Preview
@Composable
private fun SelectAddressPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            SelectAddressScreen(
                selectedAddressId = 1,
                addresses = mapOf(
                    1 to "123 Your Address One",
                    2 to "456 Your Address Two",
                )
            )
        }
    }
}



