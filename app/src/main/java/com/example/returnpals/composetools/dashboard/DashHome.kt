package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.core.Amplify
import com.example.returnpals.R
import com.example.returnpals.navigation.MenuRoutes
import com.example.returnpals.navigation.goBack
import com.example.returnpals.services.LoginViewModel

val vm = DashHomeViewModel()
@Composable
fun HomeDash(navController: NavController, loginVM: LoginViewModel) {
    val hasName by vm.hasUserName.observeAsState()
    val isLoggedIn = loginVM.isLoggedIn.observeAsState()
    vm.init()
    if (hasName == true && isLoggedIn.value != false) { // check for not signed in to Avoid null probelm with login view model
        DashboardMenuScaffold(navController, loginVM::logOut) {
            HomeDashContent(navController = navController, firstName = vm.getFirstName())
        }
    } else if (hasName == false) {
        goBack(navController, MenuRoutes.Register)
    } else if (isLoggedIn.value == false) {
        goBack(navController,"MainMenu")
    }

}
@Composable
fun HomeDashContent(navController: NavController,firstName: String) {
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)

    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .background(Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        item{ Welcome(firstName = firstName) }
        item{ DashCard(navController = navController) }

    }
}

@Composable
fun Welcome(firstName:String) {
    Column (
        modifier = Modifier
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(
            text = "Welcome Back, $firstName", // Needs to get user's name
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                // fontFamily = customFont
            ),
        )
    }
}


@Composable
fun DashCard(navController: NavController) {
    val dashBlue = Color(0xFF052A42)
    val selectedBlue = Color(0xFF008BE7)

    Card (
        modifier = Modifier
            .padding(8.dp)
            .size(width = 350.dp, height = 300.dp),
        shape = RoundedCornerShape(10.dp),
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(dashBlue)
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

        ){

            Text(
                text = "Ready to schedule" + "\n" + "your pickup?",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    // fontFamily = customFont
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.boxlift_500x453),
                contentDescription = "box lift Icon",
                modifier = Modifier
                    .size(100.dp) // Adjust size as needed

            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    // Navigate to the DashboardMenu screen
                    navController.navigate(MenuRoutes.PickupProcess) {
                        // Clear all the back stack up to the start destination and save state
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when reselecting the same item
                        launchSingleTop = true
                        // Restore state when navigating back to the composable
                        restoreState = true
                    }
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = selectedBlue,
                    contentColor = Color.White
                )
            ) {
                Text("Next",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp

                    )
                )
            }
        }
    }
}

class DashHomeViewModel(): ViewModel() {// TODO move to new file
    private val _hasUserName = MutableLiveData<Boolean?>()
    val hasUserName: LiveData<Boolean?> = _hasUserName
    private val _userNameFirst = MutableLiveData<String?>()
    var userNameFirst : LiveData<String?> = _userNameFirst
    fun getFirstName() :String{
        return userNameFirst.value!!
    }
    fun init() { //TODO Move logic to repository
        Amplify.Auth.fetchUserAttributes({
            it.iterator().forEach {
               if (it.key == AuthUserAttributeKey.givenName()) {
                   _userNameFirst.postValue(it.value)
                   _hasUserName.postValue(true)
               }
            }
        }){}
    }
}