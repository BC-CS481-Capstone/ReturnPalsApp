package com.returnpal.androidapp.compose.mainMenu

import MainMenuScaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.returnpal.androidapp.R
import com.returnpal.androidapp.compose.CustomTextField
import com.returnpal.androidapp.services.ContactViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun Contact(navController: NavController) {
    MainMenuScaffold(navController = navController) {
        ContactContent(navController = navController)
    }
}

@Composable
fun ContactContent(navController: NavController, viewModel: ContactViewModel = viewModel()) {
    var fullName by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val selectedBlue = Color(0xFF008BE7)
    val customColor = Color(0xFFE1F6FF)
    val submissionSuccessful by viewModel.submissionSuccessful.observeAsState()


    // Use LaunchedEffect to clear fields on submission success
    LaunchedEffect(submissionSuccessful) {
        if (submissionSuccessful == true) {
            fullName = ""
            postalCode = ""
            email = ""
            message = ""
            // Reset the submission success state in the ViewModel to prevent repeated actions
            viewModel.resetSubmissionSuccess()
        }
    }

    Column(
        modifier = Modifier
            .background(customColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Contact Us",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(label = "Full Name*", text = fullName, onValueChange = { fullName = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Postal Code*", text = postalCode, onValueChange = { postalCode = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Email*", text = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Message*", text = message, onValueChange = { message = it })
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.submitData(fullName, postalCode, email, message)
                // Reset state variables after submission
                fullName = ""
                postalCode = ""
                email = ""
                message = ""

            },
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

        Image(
            painter = painterResource(id = R.drawable.returnpal_icon_500x500),
            contentDescription = "Bottom Image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
    }
}




@Preview
@Composable
fun ContactTest() {
    var fullName by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
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
        Text(
            text = "Contact Us",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(label = "Full Name*", text = fullName, onValueChange = { fullName = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Postal Code*", text = postalCode, onValueChange = { postalCode = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Email*", text = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(label = "Message*", text = message, onValueChange = { message = it })
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle the send action here
            },
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

        Image(
            painter = painterResource(id = R.drawable.returnpal_icon_500x500),
            contentDescription = "Bottom Image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
    }
}
