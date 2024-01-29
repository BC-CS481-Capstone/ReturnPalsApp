package com.example.returnpals.composetools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.returnpals.composetools.ButtonManager
import androidx.compose.ui.unit.dp

class ThankYou {

    @Composable
    fun drawThankYouUI(userName:String = "Guest",
                       confirmNumber:String = "#R957394",
                       email:String = "johndoe2394@gmail.com",
                       dashBoardButton: () -> Unit)
    {
        //Column with progress at top
        Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            ProgressBar(step = 5)
            //Truck icon
            IconManager().getTruckIcon(modifier = Modifier.height(36.dp))
            //Thank you text
            Text("Thank you for scheduling a return with us!")
            //Confirm order number
            Text(userName+", your pickup order "+confirmNumber+" is confirmed.")
            //Confirm email
            Text("A confirmation email will be sent to "+email)
            //Navigation button out
            ButtonManager.NextButton(onClick =dashBoardButton, text = "Return to Dashboard")
        }
    }
}