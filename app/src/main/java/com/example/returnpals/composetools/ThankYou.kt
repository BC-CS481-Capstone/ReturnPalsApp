package com.example.returnpals.composetools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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


    fun thankText() {
        //Builds annotated string for /BLUE/ thank you /NORMAL/ for scheduling a return with us
        buildAnnotatedString {
            pushStyle(style = SpanStyle(color = getBlueIconColor())) //push style onto stack
            append("Thank you")
            pop() //pop style off stack
            append("for scheduling a return with us!")
        }
    }


    fun confirmNumberText(name:String,
                          confirm:String,
                          )
    {
        //Builds annotated string for /NORMAL/ %NAME%, your pickup order /BLUE/ %CONFIRM#% /NORMAL/ is confirmed.
        buildAnnotatedString {
            append(name)
            append("your pickup order")
            pushStyle(style= SpanStyle(color= getBlueIconColor()))  // Push style onto stack
            append(confirm)
            pop() //pop style off stack
            append("is confirmed.")
        }
    }


    fun emailText(email:String)
    {
        //Builds annotated string for /NORMAL/ A confirmation email will be sent to: /BLUE/ %EMAIL%
        buildAnnotatedString {
            append("A confirmation email will be sent to:")
            pushStyle(style = SpanStyle(color = getBlueIconColor())) //push style onto stack
            append(email)
            pop() //pop style off stack

        }
    }
}