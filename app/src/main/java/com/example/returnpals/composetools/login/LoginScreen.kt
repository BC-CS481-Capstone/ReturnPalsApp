package com.example.returnpals.composetools.login

import SettingsViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.ReturnPalTheme
import com.example.returnpals.composetools.IconManager
import com.example.returnpals.composetools.dashboard.ConfirmResetPasswordDialog
import com.example.returnpals.composetools.dashboard.ResetPasswordDialog
import com.example.returnpals.composetools.getConfig
import com.example.returnpals.navigation.MenuRoutes
import com.example.returnpals.navigation.goto
import com.example.returnpals.services.LoginViewModel

/* This is the login options class used to create the two login UI for guest and user.*/

@Composable
fun LoginScreen(
    loginVM: LoginViewModel,
    settingsVM: SettingsViewModel,
    navController: NavController,
) {
    var failMessage by remember { mutableStateOf("") }
    var isGuestMode by remember { mutableStateOf(false) }
    var loginSuccess by remember { mutableStateOf(false) }
    //if (loginSuccess) navController.goto(MenuRoutes.HomeDash)
    Box(modifier = Modifier
        .background(ReturnPalTheme.colorScheme.background)
        .fillMaxSize()) {
        //This will switch between the guest login and user login
        if (isGuestMode) {
            GuestLoginContent(
                email = loginVM.email,
                onSignIn = { loginVM.logInAsGuest { loginSuccess = true } },
                onSignUp = { navController.goto(MenuRoutes.Register) },
                onChangeEmail = { loginVM.email = it },
                onToggleGuest = { isGuestMode = false }
            )
        } else {
            LoginContent(
                email = loginVM.email,
                password = loginVM.password,
                failMessage = failMessage,
                onChangeEmail = {  loginVM.email = it },
                onChangePassword = { loginVM.password = it },
                onToggleGuest = { isGuestMode = true },
                onSignIn = {
                    loginVM.logIn(
                        onFailure = { failMessage = it.message + '\n' + it.recoverySuggestion },
                        onSuccess = { loginSuccess = true }
                    ) },
                onSignUp = { navController.goto(MenuRoutes.Register) },
                onResetPassword = settingsVM::resetPassword,
                onConfirmResetPassword = settingsVM::confirmResetPassword
            )
        }
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

@Preview(showBackground = true)
@Composable
fun LoginContent(
    email: String = "",
    password: String = "",
    failMessage: String = "",
    onChangeEmail: (String) -> Unit = {},
    onChangePassword: (String) -> Unit = {},
    onToggleGuest: () -> Unit = {},
    onSignIn:() -> Unit = {},
    onSignUp: () -> Unit = {},
    onResetPassword: (String) -> Unit = {},
    onConfirmResetPassword: (String, String) -> Unit = { _,_ -> }
) {
    val config = getConfig()

    var showResetDialog by remember { mutableStateOf(false) }
    var showConfirmResetDialog by remember { mutableStateOf(false) }

    // get screen size for image size
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        //Column center top
        IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

        //Set User or Guest options
        GuestModeToggle(isGuest = false, onGuest = onToggleGuest)

        //set text fields for users
        OutlinedTextField(
            value = email,
            onValueChange = onChangeEmail,
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = onChangePassword,
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Password") }
        )
        Text(failMessage, textAlign=TextAlign.Center, color=ReturnPalTheme.colorScheme.error)
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
                    onResetPassword(newPassword)
                    showResetDialog = false
                    showConfirmResetDialog = true
                }
            )
        }

        if (showConfirmResetDialog) {
            ConfirmResetPasswordDialog(
                onDismiss = { showConfirmResetDialog = false },
                onConfirm = { newPassword, confirmationCode ->
                    onConfirmResetPassword(newPassword, confirmationCode)
                    showConfirmResetDialog = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuestLoginContent(
    email: String = "",
    onSignIn: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onChangeEmail: (String) -> Unit = {},
    onToggleGuest: () -> Unit = {}
) {
    val config = getConfig()
    // get screen size for image size
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        //Column center top
        IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

        //Set User or Guest options
        GuestModeToggle(isGuest = true, onSignIn = onToggleGuest)

        //set text fields for users
        OutlinedTextField(
            value = email,
            onValueChange = onChangeEmail,
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(10.dp))

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

@Preview(showBackground = true)
@Composable
fun GuestModeToggle(
    isGuest: Boolean = false,
    onSignIn: () -> Unit = {},
    onGuest: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(6.dp, 1.dp)
            .border(6.dp, ReturnPalTheme.colorScheme.secondaryContainer)
            .height(IntrinsicSize.Min)
    ) {
        TextButton(
            enabled = isGuest, onClick = onSignIn,
            modifier = Modifier.background(
                if (isGuest) ReturnPalTheme.colorScheme.background
                else ReturnPalTheme.colorScheme.secondaryContainer
            )
        ) {
            Text(text = "Sign In",
                color = if (isGuest) ReturnPalTheme.colorScheme.primary
                    else ReturnPalTheme.colorScheme.secondary,
                modifier = Modifier.padding(4.dp,0.dp)
            )
        }
        TextButton(
            enabled = !isGuest, onClick = onGuest,
            shape = RectangleShape,
            modifier = Modifier.background(
                if (!isGuest) ReturnPalTheme.colorScheme.background
                else ReturnPalTheme.colorScheme.secondaryContainer
            )
        ) {
            Text(text = "Guest",
                color = if (!isGuest) ReturnPalTheme.colorScheme.primary
                    else ReturnPalTheme.colorScheme.secondary,
                modifier = Modifier.padding(4.dp,0.dp)
            )
        }
    }
}