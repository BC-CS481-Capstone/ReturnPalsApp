package com.example.returnpals.composetools
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class loginOptions {
    /* This is the login options class used to create the two login UI for guest and user.*/

    @Composable
    fun LoginUISate(isGuest:Boolean) {
        //This will switch between the guest login and user login
        var isGuest = remember { mutableStateOf(isGuest) }
        var email = remember { mutableStateOf("Email") }
        var pass = remember { mutableStateOf("Password") }
        if (isGuest.value) {
            GuestLoginUIContent(
                userSignIn = { isGuest.value = false },
                signin = { /*TODO* login(user,pass)*/ },
                signup = { /*TODO navToSignUp*/ },
                email = { email.value = it},
                emailString = email.value)
        } else {
            LoginUIContent(
                user = {  email.value = it},
                pass = { pass.value = it },
                guest = { isGuest.value  = true },
                reset = { /*TODO*/ },
                signin = { /*TODO*/ },
                signup = { /*TODO*/ },
                emailString = email.value,
                passString = pass.value)
        }
    }

    @Composable
    fun LoginUIContent(user:(String) -> Unit, pass:(String) -> Unit, guest: () -> Unit, reset: () -> Unit, signin:() -> Unit, signup: () -> Unit, emailString:String = "Email",passString:String="Password") {
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

}