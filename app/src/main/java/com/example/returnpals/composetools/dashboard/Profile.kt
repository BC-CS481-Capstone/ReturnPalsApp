package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User
import com.example.returnpals.R
import com.example.returnpals.composetools.pickup.PricingPlanText
import com.example.returnpals.services.LoginViewModel

val profileVM = ProfileViewModel()
@Composable
fun Profile(navController: NavController, loginVM: LoginViewModel) {
    DashboardMenuScaffold(navController, loginVM.isLoggedIn.value!! ?: false, loginVM::logOut) {
        val hasUserInfo by profileVM.hasUserInfo.observeAsState()
        profileVM.init()
        if (hasUserInfo == true) {
            ProfileContent(profileVM)
        }
    }

}



@Composable
fun ProfileContent(vm:ProfileViewModel) {
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    val profile = vm


    Column(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Image(
            painter = painterResource(R.drawable.returnpal_icon_500x500),
            contentDescription = "",
        )

        Text(
            text = "Welcome, " + profile.getFirstName() + " " + profile.getLastName(),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,

                )

        )
        Text(
            text = "Your Plan:",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,

                )
        )
        //Code to detect what profile plan is being used goes here
        val plan = profile.getType()
        when (plan) {
            "SILVER" -> PricingPlanText(
                PricingPlan.SILVER,
                Modifier
                    .padding(15.dp)
                    .scale(1.5F)
            )

            "BRONZE" -> PricingPlanText(
                PricingPlan.BRONZE,
                Modifier
                    .padding(15.dp)
                    .scale(1.5F)
            )

            "GOLD" -> PricingPlanText(
                PricingPlan.GOLD,
                Modifier
                    .padding(15.dp)
                    .scale(1.5F)
            )

            "PLATINUM" -> PricingPlanText(
                PricingPlan.PLATINUM,
                Modifier
                    .padding(15.dp)
                    .scale(1.5F)
            )

        }



      Spacer(Modifier.padding(15.dp))
      Text(text = "Plan Expires On:", style = TextStyle(fontSize = 20.sp))
      Text(text = profile.getExpireDate().toString())
      Spacer(Modifier.padding(15.dp))
      CancelPlanButton()
    }

}




//Possibly unnecessary function
fun getStartDate():String{
    //Backend Code
    return "01/01/2024"


}

fun getBillDate():String{
    //backend code
    return "02/01/2024"
}
@Composable
fun CancelPlanButton(){
    Button(onClick = { cancel() }, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)){
        Text("Cancel")
    }
}

private fun cancel(){

}



class ProfileViewModel(): ViewModel() {
    private val _hasUserInfo = MutableLiveData<Boolean?>()
    val hasUserInfo: LiveData<Boolean?> = _hasUserInfo


    var userNameFirst  = mutableStateOf("John")
    var userNameLast = mutableStateOf("Doe")
    var userPlan = mutableStateOf(PricingPlan.BRONZE)
    var expireDate = mutableStateOf("Never")

    fun getFirstName() :String{
        return userNameFirst.value
    }
    fun getLastName() :String{
        return userNameLast.value
    }
    fun getExpireDate() :String{
        return expireDate.value
    }
    fun getType ():String {
        return userPlan.value.toString()
    }
    fun init() {
        Amplify.API.query(
            ModelQuery.list(User::class.java), {
                if (it.hasData()) {
                    val first = it.data.items.first()
                    userNameFirst.value = first.firstName
                    userNameLast.value = first.lastName
                    userPlan.value = first.subscription
                    _hasUserInfo.postValue(true)
                } else {
                    _hasUserInfo.postValue(false)
                }
            },
            {
            }
        );
    }
}

