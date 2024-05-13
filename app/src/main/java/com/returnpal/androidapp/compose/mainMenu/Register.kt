package com.returnpal.androidapp.compose.mainMenu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.returnpal.androidapp.compose.CustomTextField
import com.returnpal.androidapp.compose.nav.MenuRoutes
import com.returnpal.androidapp.services.AmplifyOperations
import com.returnpal.androidapp.services.Backend
import com.returnpal.androidapp.services.RegisterViewModel

@Composable
fun RegistrationScreen(navController: NavController) {
    val customColor = Color(0xFFE1F6FF)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(customColor)
            .padding(16.dp)
    ) {
        item { Title() }
        item { RegistrationForm(navController = navController) }
    }
}

@Composable
private fun Title() {
    val selectedBlue = Color(0xFF008BE7)

    Text(
        text = "Registration Form",
        fontSize = 32.sp,
        color = Color.Blue,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun RegistrationForm(navController: NavController, viewModel: RegisterViewModel = viewModel()) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val selectedBlue = Color(0xFF008BE7)
    val customColor = Color(0xFFE1F6FF)
    val submissionSuccessful by viewModel.submissionSuccessful.observeAsState()

    // Use LaunchedEffect to clear fields on submission success
   LaunchedEffect(submissionSuccessful) {
        if (submissionSuccessful == true) {
            firstName = ""
            lastName = ""
            address = ""
            email = ""
            phoneNumber = ""
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

        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(label = "First Name*", text = firstName, onValueChange = { firstName = it })
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            label = "Last Name*",
            text = lastName,
            onValueChange = { lastName = it })
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            label = "Address*",
            text = address,
            onValueChange = { address = it })
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Email*", text = email, onValueChange = { /* Stop Email From Changing email = it*/ })
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(label = "Phone Number*", text = phoneNumber, onValueChange = { phoneNumber = it })
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.submitRegistration(firstName, lastName, email,
                    address, phoneNumber)
                // Reset state variables after submission


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
        Button(
            onClick = {
                //Logout and sends back to login screen
                AmplifyOperations.signOut {
                    Log.i("signOut", it.toString())
                    Backend.resetEmail()
                }
                navController.navigate(MenuRoutes.Home) {
                    // Clear all the back stack up to the start destination and save state
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
            },
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
        Text(viewModel.failMessage)
        if (submissionSuccessful == true) {
            firstName = ""
            lastName = ""
            address = ""
            email = ""
            phoneNumber = ""

            navController.navigate(MenuRoutes.HomeDash)
        }
    }
}

