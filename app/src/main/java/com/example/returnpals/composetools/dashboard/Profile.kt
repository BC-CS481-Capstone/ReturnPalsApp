package com.example.returnpals.composetools.dashboard

import DashboardMenuScaffold
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.returnpals.PricingPlan
import com.example.returnpals.R
import com.example.returnpals.composetools.PricingPlanText

@Composable
fun Profile(navController: NavController) {
    DashboardMenuScaffold(navController = navController) {
        ProfileContent()
    }

}

@Preview
@Composable
fun ProfileContent(){
    val gradientColors = listOf(Color(0xFFE1F6FF), Color.White)
    var picUri : Uri? = null


    Column(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        if(picUri == null) {
            Image(painter = painterResource(R.drawable.returnpal_icon_500x500), contentDescription = "Profile Picture",)
        }
            Text(
            text = "Your Plan:",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
                ,

            )
        )
        PricingPlanText(PricingPlan.SILVER,
            Modifier
                .padding(15.dp)
                .scale(1.5F))
        Spacer(Modifier.padding(15.dp))
        Text(text = "Start Date:", style =TextStyle(fontSize = 20.sp))
        Text(text = getStartDate())
        Spacer(Modifier.padding(15.dp))
        Text(text = "Next Billing On:", style =TextStyle(fontSize = 20.sp))
        Text(text = getBillDate())
        Spacer(Modifier.padding(15.dp))
        CancelPlanButton()

    }


}
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

