package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import SettingsViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.returnpals.R
import com.example.returnpals.services.LoginViewModel

@Composable
fun Settings(navController: NavController, loginVM: LoginViewModel) {
    val settingsViewModel: SettingsViewModel = viewModel()
    val operationStatus by settingsViewModel.operationStatus.collectAsState()
    val userAddresses by settingsViewModel.userAddresses.collectAsState()
    var showResetPasswordDialog by remember { mutableStateOf(false) }
    var showConfirmResetPasswordDialog by remember { mutableStateOf(false) }
    var showAddressesDialog by remember { mutableStateOf(false) }
    var showAddAddressDialog by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = true) {
        settingsViewModel.fetchAddresses()
    }

    DashboardMenuScaffold(navController, loginVM.isLoggedIn, loginVM::logOut) {
        if (showResetPasswordDialog) {
            ResetPasswordDialog(
                onDismiss = { showResetPasswordDialog = false },
                onConfirm = { newPassword ->
                    // Assuming you want to confirm reset immediately after setting a new password
                    settingsViewModel.resetPassword(newPassword)
                    showResetPasswordDialog = false
                    showConfirmResetPasswordDialog = true // Set this to true to show the next dialog
                }
            )
        }

        if (showConfirmResetPasswordDialog) {
            ConfirmResetPasswordDialog(
                onDismiss = { showConfirmResetPasswordDialog = false },
                onConfirm = { newPassword, confirmationCode ->
                    settingsViewModel.confirmResetPassword(newPassword, confirmationCode)
                    showConfirmResetPasswordDialog = false
                }
            )
        }

        if (showAddressesDialog) {
            AddressesDialog(
                addresses = userAddresses,
                onDismiss = { showAddressesDialog = false },
                onAddAddress = { showAddressesDialog = false; showAddAddressDialog = true },
                onDeleteAddress = { address -> settingsViewModel.deleteAddress(address) } // Callback for address deletion
            )
        }

        if (showAddAddressDialog) {
            AddAddressDialog(
                settingsViewModel = settingsViewModel,
                onDismiss = { showAddAddressDialog = false }
            )
        }


        PasswordField(
            onResetPasswordClick = { showResetPasswordDialog = true },
            onAddRemoveAddressesClick = { showAddressesDialog = true },
            onBillingInfoClick = { /* Logic for billing information */ }
        )

        operationStatus?.let { status ->
            if (status.isNotEmpty()) {
                Text(text = status)
            }
        }


    }
}

@Composable
fun PasswordField(
    onResetPasswordClick: () -> Unit,
    onAddRemoveAddressesClick: () -> Unit,
    onBillingInfoClick: () -> Unit
) {
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors))
            .padding(16.dp)
    ) {
        OptionItem(
            label = "Reset Password",
            iconResourceId = R.mipmap.lock,
            onClick = onResetPasswordClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        OptionItem(
            label = "Add/Remove Addresses",
            iconResourceId = R.mipmap.address,
            onClick = onAddRemoveAddressesClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        OptionItem(
            label = "Billing Information",
            iconResourceId = R.mipmap.address,
            onClick = onBillingInfoClick
        )
    }
}

@Composable
fun OptionItem(
    label: String,
    iconResourceId: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = iconResourceId),
            contentDescription = label,
            modifier = Modifier.size(30.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun ResetPasswordDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var newPassword by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Reset Password") },
        text = {
            Column {
                TextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = { Text("New Password") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(newPassword)
                    onDismiss()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun ConfirmResetPasswordDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmationCode by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Confirm Reset Password") },
        text = {
            Column {
                TextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = { Text("Confirm Password") }
                )
                TextField(
                    value = confirmationCode,
                    onValueChange = { confirmationCode = it },
                    label = { Text("Confirmation Code") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(newPassword, confirmationCode)
                    onDismiss()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun AddressesDialog(
    addresses: List<SettingsViewModel.SimpleAddress>,
    onDismiss: () -> Unit,
    onAddAddress: () -> Unit, // Adding a callback to trigger the address addition form
    onDeleteAddress: (SettingsViewModel.SimpleAddress) -> Unit // Callback to delete an address
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Manage Addresses") },
        text = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                if (addresses.isEmpty()) {
                    Text("No addresses available.")
                } else {
                    addresses.forEach { address ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = address.address,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "Delete",
                                modifier = Modifier
                                    .clickable { onDeleteAddress(address) },
                                color = Color.Red,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onAddAddress() }, // This button will trigger the addition form
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add New Address")
                }
            }
        },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("Close")
            }
        }
    )
}


@Composable
fun AddAddressDialog(settingsViewModel: SettingsViewModel, onDismiss: () -> Unit) {
    var address by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Add New Address") },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Address") },
                    singleLine = true,
                    keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
                )
                Spacer(modifier = Modifier.height(8.dp))

            }
        },
        confirmButton = {
            Button(
                onClick = {
                    settingsViewModel.addNewAddress(address)
                    onDismiss()
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}

