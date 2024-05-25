package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.ReturnPalTheme
import com.example.returnpals.services.LoginViewModel

@Composable
fun ConfirmEmailScreen(loginVM: LoginViewModel) {
    var code by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .background(ReturnPalTheme.colorScheme.background)
        .fillMaxSize()
    ) {
        ConfirmEmailContent(
            emailToConfirm = loginVM.email,
            message = message,
            submitNumber = code,
            onSubmitNumberChange = { code = it },
            verifyButton = { loginVM.confirmEmail(code) { message = it } }
        )
    }
}

@Composable
fun ConfirmEmailContent(emailToConfirm:String, message:String, submitNumber:String, onSubmitNumberChange:(String)->Unit, verifyButton:()->Unit) {
    //Promt a user for confirm number with space to enter and button to confirm
    val config = getConfig()
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween
        //,modifier = Modifier.fillMaxSize()

    ) {
        IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))
        Text("Please enter the confirmation number sent to,\n")
        Text(emailToConfirm)
        OutlinedTextField(value=submitNumber, onValueChange = onSubmitNumberChange)
        Text(message)
        Button(onClick = verifyButton,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008BE7),
                contentColor = Color.White)
            //,modifier = Modifier.padding(bottom=300.dp)
        ) {
            Text("Verify")
        }
    }
}