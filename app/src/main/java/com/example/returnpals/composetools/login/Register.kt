package com.example.returnpals.composetools.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.returnpals.composetools.CustomTextField
import com.example.returnpals.composetools.CustomTextPasswordFields
import com.example.returnpals.composetools.CustomTextRowFields
import com.example.returnpals.viewmodel.RegisterViewModel

@Composable
fun Register(navController: NavController) {
    RegisterScreen(viewModel())
}


@Composable
fun RegisterScreen(viewModel:RegisterViewModel){
    val customColor = Color(0xFFE1F6FF)


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(customColor)
            .padding(16.dp)

    ){
        item { RegisterTitle() }
        item { Form(
            registerViewModel = viewModel,
            onCancel = viewModel::onCancel,
            onSubmit = viewModel::onSubmit)
        }
    }
}

@Composable
fun RegisterTitle() {
    val selectedBlue = Color(0xFF008BE7)

    Text(
        text = "Registration Form",
        fontSize = 32.sp,
        color = Color.Blue,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun Form(onCancel:()->Unit,
         onSubmit:()->Unit,
         registerViewModel:RegisterViewModel) {

    //Collect data from view model
    val uiState by registerViewModel.uiState.collectAsState()
    //Set data from view model
    val firstName = uiState.firstName
    val lastName = uiState.lastName
    val city = uiState.city
    val suiteNumber = uiState.suiteNumber
    val password1 = uiState.password1
    val password2 = uiState.password2
    val postalCode = uiState.postalCode
    val address = uiState.address
    val email = uiState.email
    val phoneNumber = uiState.phoneNumber
    val failMessage = uiState.failMessage

    //Select collors
    val selectedBlue = Color(0xFF008BE7)
    val customColor = Color(0xFFE1F6FF)

    Column(
        modifier = Modifier
            .background(customColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(label = "First Name*", text = firstName, onValueChange = registerViewModel::onFistName)
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Last Name*", text = lastName, onValueChange = registerViewModel::onLastName)
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Email*", text = email, onValueChange = registerViewModel::onEmail)
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Phone Number*", text = phoneNumber, onValueChange = registerViewModel::onPhoneNumber)
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Billing Address*", text = address, onValueChange = registerViewModel::onAddress)
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomTextRowFields(modifier = Modifier.weight(1f),label = "(Apt)", text = suiteNumber, onValueChange = registerViewModel::onSuiteNumber)
            CustomTextRowFields(modifier = Modifier.weight(1f),label = "City*", text = city, onValueChange = registerViewModel::onCity)
            CustomTextRowFields(modifier = Modifier.weight(1f),label = "Postal*", text = postalCode, onValueChange = registerViewModel::onPostalCode)
        }
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextPasswordFields(label = "Password*", text = password1, onValueChange = registerViewModel::onPassword1)
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextPasswordFields(label = "Confirm Password*", text = password2, onValueChange = registerViewModel::onPassword2)
        Spacer(modifier = Modifier.height(8.dp))

        Text(failMessage)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onSubmit,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectedBlue,
                contentColor = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                "Submit",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.padding(24.dp))
        Button(
            onClick = onCancel,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectedBlue,
                contentColor = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                "Cancel",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.padding(24.dp))

    }
}






