package com.example.returnpals.composetools
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.returnpals.mainMenu.MenuRoutes
import com.example.returnpals.services.LoginViewModel


    /* This is the login options class used to create the two login UI for guest and user.*/


@Composable
fun SignUp(navController: NavController) {
    navController.navigate(MenuRoutes.Video)
}

    @Composable
    fun LoginUISate(viewModel:LoginViewModel) {
        //This will switch between the guest login and user login
        if (viewModel.isGuest.value) {
            GuestLoginUIContent(
                userSignIn = { viewModel.switchGuestUser() },
                signin = { /*TODO* login(user,pass)*/ },
                signup = { viewModel.isGuest.value = false },
                email = { viewModel.email.value = it},
                emailString = viewModel.email.value)
        } else {
            LoginUIContent(
                failMessage = viewModel.failLogInMessage.value,
                user = {  viewModel.changeEmail(it)},
                pass = { viewModel.changePass(it) },
                guest = { viewModel.switchGuestUser() },
                reset = { /*TODO*/ },
                signin = {viewModel.logIn() },
                signup = { viewModel.singUp() },
                emailString = viewModel.email.value,
                passString =  viewModel.password.value)
        }
    }

    @Composable
    fun ConfirmNumberContent() {
        //Promt a user for confirm number with space to enter and button to confirm

    }
    @Composable
    fun LoginUIContent(failMessage:String,user:(String) -> Unit, pass:(String) -> Unit, guest: () -> Unit, reset: () -> Unit, signin:() -> Unit, signup: () -> Unit, emailString:String = "Email",passString:String="Password") {
        val config = getConfig()
        // get screen size for image size
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                //Column center top
                IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

                //Set User or Guest options
                Row() {
                    Text(text = "Sign In |",Modifier.align(Alignment.CenterVertically))
                    TextButton(onClick = guest){
                        Text("Guest",color = Color(0xFF008BE7))
                    }
                }

                //create temp vars for holding user inputs


                //set text fields for users
                OutlinedTextField(value = emailString,
                    onValueChange = user
                )
                OutlinedTextField(value = passString, onValueChange = pass,
                    visualTransformation = PasswordVisualTransformation()
                )
                Text(failMessage)
                //Forgot your password button
                TextButton(onClick = reset){
                    Text("Forgot your password?",color = Color(0xFF008BE7))
                }
                // Big Sign in button
                Button(onClick = signin,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008BE7), contentColor = Color.White)) {
                    Text("Sign In")
                }
                // Sign up options
                Row() {
                    Text(text = "Don't have an account yet?",Modifier.align(Alignment.CenterVertically))
                    TextButton(onClick = signup) {
                        Text("Sign up",color = Color(0xFF008BE7))
                    }
                }
            }
    }
    @Composable
    fun GuestLoginUIContent(userSignIn: () -> Unit, signin:() -> Unit, signup: () -> Unit,emailString:String="Email",email:(String)->Unit) {
        val config = getConfig()
        // get screen size for image size
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            //Column center top
            IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))

            //Set User or Guest options
            Row() {
                TextButton(onClick = userSignIn){
                Text("Sign In ",color = Color(0xFF008BE7))
            }
                Text(text = "| Guest",Modifier.align(Alignment.CenterVertically))

            }

            //create temp vars for holding user inputs

            //set text fields for users
            OutlinedTextField(value = emailString,
                onValueChange = email
            )

            // Big Sign in button
            Button(onClick = signin,colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008BE7), contentColor = Color.White)) {
                Text("Sign In as Guest")
            }
            // Sign up options
            Row() {
                Text(text = "Don't have an account yet?",Modifier.align(Alignment.CenterVertically))
                TextButton(onClick = signup) {
                    Text("Sign up",color = Color(0xFF008BE7))
                }
            }
        }
    }
