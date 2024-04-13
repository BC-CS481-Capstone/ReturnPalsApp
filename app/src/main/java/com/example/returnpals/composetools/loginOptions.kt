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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.amplifyframework.core.Amplify
import com.example.returnpals.mainMenu.MenuRoutes
import com.example.returnpals.mainMenu.viewModelLogin
import com.example.returnpals.services.LoginViewModel
import com.example.returnpals.services.UserRepository


/* This is the login options class used to create the two login UI for guest and user.*/




@Composable
fun ConfirmNumber(navController: NavController,confirmviewMd:ConfirmNumberViewModel ) {
    val confirmSuccessful by confirmviewMd.confirmSuccessful.observeAsState()
    Box(modifier = Modifier
        .background(getBackGroundColor())
        .fillMaxSize()) {
        ConfirmNumberContent(
            emailToConfirm = confirmviewMd.getEmail(),
            message = confirmviewMd.getMessage(),
            submitNumber = confirmviewMd.code.value,
            onSubmitNumberChange = { confirmviewMd.setCode(it) }) {
            confirmviewMd.confirmNumber()
        }
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
    fun LoginScreen(viewModel:LoginViewModel, navController: NavController) {
        // Condition variables
        val signUpSuccessful by viewModel.signUpSuccessful.observeAsState()
        val logInSuccessful by viewModel.logInSuccessful.observeAsState()
        viewModel.changeEmail("daviddcmmoo@gmail.com")
        viewModel.checkUser()
        Box(modifier = Modifier
            .background(getBackGroundColor())
            .fillMaxSize()) {
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
                    signin = {viewModel.logIn()},
                    signup = {viewModel.signUp()},
                    emailString = viewModel.getEmail(),
                    passString =  viewModel.password.value)
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
    fun ConfirmNumberContent(emailToConfirm:String,message:String,submitNumber:String,onSubmitNumberChange:(String)->Unit,verifyButton:()->Unit) {
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

class ConfirmNumberViewModel(): ViewModel() {
    //View model for confirm number. Sends data to amplify (confirm number)

    // Condition variable
    private val _confirmSuccessful = MutableLiveData<Boolean?>()
    val confirmSuccessful: LiveData<Boolean?> = _confirmSuccessful

    //Get email from login
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
    fun setCode(codeValue:String) {
        code.value = codeValue
    }
    fun confirmNumber() {

        Amplify.Auth.confirmSignUp(
            getEmail(), code.value,
            { _confirmSuccessful.postValue(true) },
            { _confirmSuccessful.postValue(false)
                setMessage(it.message.toString()) }
        )
    }
}



