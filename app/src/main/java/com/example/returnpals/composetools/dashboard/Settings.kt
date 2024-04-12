package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import SettingsViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.returnpals.R

@Composable
fun Settings(navController: NavController) {
    val settingsViewModel: SettingsViewModel = viewModel()
    val operationStatus by settingsViewModel.operationStatus.collectAsState()
    var showResetPasswordDialog by remember { mutableStateOf(false) }
    var showConfirmResetPasswordDialog by remember { mutableStateOf(false) }

    // If operation status contains a message about sending a confirmation code, show the confirm dialog
    LaunchedEffect(operationStatus) {
        if (operationStatus?.contains("check your email for the confirmation code") == true) {
            showConfirmResetPasswordDialog = true
        }
    }

    DashboardMenuScaffold(navController = navController) {
        if (showResetPasswordDialog) {
            // Presumably, you already have logic here to handle the reset password request
            ResetPasswordDialog(
                onDismiss = { showResetPasswordDialog = false },
                onConfirm = { newPassword ->
                    settingsViewModel.resetPassword(newPassword)
                    showResetPasswordDialog = false
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

        PasswordField(
            onResetPasswordClick = { showResetPasswordDialog = true },
            onAddRemoveAddressesClick = { /* Logic for adding/removing addresses */ },
            onBillingInfoClick = { /* Logic for billing information */ }
        )

        // Optionally display operation status
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
            iconResourceId = R.mipmap.payment,
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
                    label = { Text("New Password") }
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


