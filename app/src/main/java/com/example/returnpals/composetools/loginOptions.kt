package com.example.returnpals.composetools
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.amplifyframework.auth.result.AuthSignUpResult
import com.amplifyframework.core.Amplify
import com.example.returnpals.mainMenu.MenuRoutes
import com.example.returnpals.services.Backend
import com.example.returnpals.services.LoginViewModel
import com.example.returnpals.services.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/* This is the login options class used to create the two login UI for guest and user.*/



private var confirmviewMd = ConfirmNumberViewModel()
@Composable
fun ConfirmNumber(navController: NavController) {
    Box(modifier = Modifier.background(getBackGroundColor()).fillMaxSize()) {
        ConfirmNumberContent(
            emailToConfirm = confirmviewMd.getEmail(),
            message = confirmviewMd.getMessage(),
            submitNumber = confirmviewMd.code.value,
            onSubmitNumberChange = { confirmviewMd.setCode(it) }) {
            confirmviewMd.confirmNumber {
                GlobalScope.launch(Dispatchers.Main) { go2(navController, MenuRoutes.Register) }
            }
        }
    }
}

    @Composable
    fun LoginScreen(viewModel:LoginViewModel, navController: NavController) {

        Box(modifier = Modifier.background(getBackGroundColor()).fillMaxSize()) {
            //This will switch between the guest login and user login
            if (viewModel.isGuest.value) {
                GuestLoginUIContent(
                    userSignIn = { viewModel.switchGuestUser() },
                    signin = { /*TODO* login(user,pass)*/ },
                    signup = { viewModel.isGuest.value = false },
                    email = { viewModel.changeEmail(it) },
                    emailString = viewModel.getEmail())
            } else {
                LoginUIContent(
                    failMessage = viewModel.failLogInMessage.value,
                    user = {  viewModel.changeEmail(it)},
                    pass = { viewModel.changePass(it) },
                    guest = { viewModel.switchGuestUser() },
                    reset = { /*TODO*/ },
                    signin = {viewModel.logIn({ GlobalScope.launch(Dispatchers.Main) { go2(navController, MenuRoutes.HomeDash) }
                    Backend.accessEmail()
                    }) {
                        viewModel.setFailLogInMessage(it.message!!)
                        if (it.message!!.contains("User not confirmed in the system."))
                            GlobalScope.launch(Dispatchers.Main) { go2(navController, MenuRoutes.ConfirmNumber) }
                    } },
                    signup = {viewModel.signUp({ GlobalScope.launch(Dispatchers.Main) {go2(navController, MenuRoutes.ConfirmNumber) } })
                    },
                    emailString = viewModel.getEmail(),
                    passString =  viewModel.password.value)
            }

        }
    }

    @Composable
    fun ConfirmNumberContent(emailToConfirm:String,message:String,submitNumber:String,onSubmitNumberChange:(String)->Unit,verifyButton:()->Unit) {
        //Promt a user for confirm number with space to enter and button to confirm
        val config = getConfig()
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween
            //,modifier = Modifier.fillMaxSize()

        ) {
            IconManager().getReturnPalNameIcon(Modifier.requiredWidth(config.screenWidthDp.dp))
            Text("Please enter the confirmation number sent to,\n"+emailToConfirm)
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

private class ConfirmNumberViewModel(): ViewModel() {
    private var repository = UserRepository
    var code =  mutableStateOf<String>("")
        private set
    var message = mutableStateOf<String>("")
    fun getEmail():String {
        return repository.getEmail()
    }
    fun getMessage():String {
        return message.value
    }

    fun setMessage(value:String){
        message.value = value
    }

    fun confirmNumber(onSuccess:(AuthSignUpResult)->Unit) {
        Amplify.Auth.confirmSignUp(
            getEmail(), code.value,
            onSuccess,
            { setMessage(it.message.toString()) }
        )
    }
    fun setCode(codeValue:String) {
        code.value = codeValue
    }

}



