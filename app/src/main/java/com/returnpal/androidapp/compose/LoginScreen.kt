package com.returnpal.androidapp.compose

import SettingsViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.returnpal.androidapp.compose.dashboard.ConfirmResetPasswordDialog
import com.returnpal.androidapp.compose.dashboard.ResetPasswordDialog
import com.returnpal.androidapp.compose.nav.go2
import com.returnpal.androidapp.mainMenu.MenuRoutes
import com.returnpal.androidapp.mainMenu.viewModelLogin
import com.returnpal.androidapp.services.ConfirmEmailViewModel
import com.returnpal.androidapp.services.LoginViewModel

/* This is the login options class used to create the two login UI for guest and user.*/

@Composable
fun ConfirmEmailScreen(navController: NavController, confirmVM: ConfirmEmailViewModel) {
    val confirmSuccessful by confirmVM.confirmSuccessful.observeAsState()
    Box(modifier = Modifier
        .background(getBackGroundColor())
        .fillMaxSize()) {
        ConfirmEmailContent(
            emailToConfirm = confirmVM.email,
            message = confirmVM.message.value,
            submitNumber = confirmVM.code.value,
            onSubmitNumberChange = { confirmVM.code.value = it },
            verifyButton = confirmVM::confirm
        )
    }
    if (confirmSuccessful == true) {
        viewModelLogin.logIn()
        navController.navigate(MenuRoutes.Register) {
            popUpTo(MenuRoutes.Home) {
               // saveState = true
            }
            launchSingleTop = true
            //restoreState = true
        }
    }
}

@Composable
fun LoginScreen(viewModel:LoginViewModel, settingsViewModel: SettingsViewModel, navController: NavController) {
    // Condition variables
    val signUpSuccessful by viewModel.signUpSuccessful.observeAsState()
    val logInSuccessful by viewModel.logInSuccessful.observeAsState()
    var isGuestMode by remember { mutableStateOf(false) }
//    viewModel.checkUser()
    Box(modifier = Modifier
        .background(getBackGroundColor())
        .fillMaxSize()) {
        //This will switch between the guest login and user login
        if (isGuestMode) {
            GuestLoginContent(
                email = viewModel.email,
                onSignIn = viewModel::logInAsGuest,
                onSignUp = { go2(navController, MenuRoutes.Register) },
                onChangeEmail = { viewModel.email = it })
        } else {
            LoginContent(
                email = viewModel.email,
                password = viewModel.password,
                failMessage = viewModel.failMessage,
                onChangeEmail = {  viewModel.email = it },
                onChangePassword = { viewModel.password = it },
                onGuest = { isGuestMode = true },
                onSignIn = viewModel::logIn,
                onSignUp = viewModel::register,
                settingsViewModel = settingsViewModel)
        }
        if (signUpSuccessful == true) {
            viewModel.reset()
            navController.navigate(MenuRoutes.ConfirmNumber) {
                popUpTo(MenuRoutes.SignIn)
                launchSingleTop = true
                restoreState = true
            }
        }
        if (logInSuccessful == true) {
            viewModel.reset()
            go2(navController,MenuRoutes.HomeDash)
        }
    }
}

@Composable
private fun ConfirmEmailContent(emailToConfirm:String, message:String, submitNumber:String, onSubmitNumberChange:(String)->Unit, verifyButton:()->Unit) {
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
@Composable
private fun LoginContent(
    email: String = "Email",
    password: String = "Password",
    failMessage: String = "",
    onChangeEmail: (String) -> Unit,
    onChangePassword: (String) -> Unit,
    onGuest: () -> Unit,
    onSignIn:() -> Unit,
    onSignUp: () -> Unit,
    settingsViewModel: SettingsViewModel
) {
    val config = getConfig()

    var showResetDialog by remember { mutableStateOf(false) }
    var showConfirmResetDialog by remember { mutableStateOf(false) }

    // get screen size for image size
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        //Column center top
        IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

        //Set User or Guest options
        Row() {
            Text(text = "Sign In |", Modifier.align(Alignment.CenterVertically))
            TextButton(onClick = onGuest) {
                Text("Guest", color = Color(0xFF008BE7))
            }
        }

        //create temp vars for holding user inputs


        //set text fields for users
        OutlinedTextField(
            value = email,
            onValueChange = onChangeEmail
        )
        OutlinedTextField(
            value = password, onValueChange = onChangePassword,
            visualTransformation = PasswordVisualTransformation()
        )
        Text(failMessage)
        //Forgot your password button
        TextButton(onClick = {showResetDialog = true}) {
            Text("Forgot your password?", color = Color(0xFF008BE7))
        }
        // Big Sign in button
        Button(
            onClick = onSignIn,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF008BE7),
                contentColor = Color.White
            )
        ) {
            Text("Sign In")
        }
        // Sign up options
        Row() {
            Text(
                text = "Don't have an account yet?",
                Modifier.align(Alignment.CenterVertically)
            )
            TextButton(onClick = onSignUp) {
                Text("Sign up", color = Color(0xFF008BE7))
            }
        }

        if (showResetDialog) {
            ResetPasswordDialog(
                onDismiss = { showResetDialog = false },
                onConfirm = { newPassword ->
                    settingsViewModel.resetPassword(newPassword)
                    showResetDialog = false
                    showConfirmResetDialog = true
                }
            )
        }

        if (showConfirmResetDialog) {
            ConfirmResetPasswordDialog(
                onDismiss = { showConfirmResetDialog = false },
                onConfirm = { newPassword, confirmationCode ->
                    settingsViewModel.confirmResetPassword(newPassword, confirmationCode)
                    showConfirmResetDialog = false
                }
            )
        }
    }
}

@Composable
private fun GuestLoginContent(
    email: String = "",
    onSignIn: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onChangeEmail: (String) -> Unit,
) {
    val config = getConfig()
    // get screen size for image size
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        //Column center top
        IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

        //Set User or Guest options
        Row {
            TextButton(onClick = onSignIn) {
                Text("Sign In ", color = Color(0xFF008BE7))
            }
            Text(text = "| Guest", Modifier.align(Alignment.CenterVertically))
        }

        //create temp vars for holding user inputs

        //set text fields for users
        OutlinedTextField(value = email, onValueChange = onChangeEmail)

        // Big Sign in button
        Button(onClick = onSignIn,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008BE7), contentColor = Color.White)) {
            Text("Sign In as Guest")
        }
        // Sign up options
        Row() {
            Text(text = "Don't have an account yet?",Modifier.align(Alignment.CenterVertically))
            TextButton(onClick = onSignUp) {
                Text("Sign up",color = Color(0xFF008BE7))
            }
        }
    }
}
