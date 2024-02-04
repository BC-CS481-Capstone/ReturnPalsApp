package com.example.returnpals.composetools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.example.returnpals.composetools.ButtonManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ThankYou {

    @Composable
    fun drawThankYouUI(userName:String = "Guest",
                       confirmNumber:String = "#",
                       email:String = "johndoe2394@gmail.com",
                       dashBoardButton: () -> Unit)
    {
        val configsWidth = getConfig().screenWidthDp
        val iconSize = configsWidth/2
        val fontSize = configsWidth/14
        val lineLength = configsWidth-20
        //Column with progress at top
        Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            ProgressBar(step = 5)
            //Truck icon
            IconManager().getTruckIcon(modifier = Modifier.width(iconSize.dp))
            //Thank you text
            Text(thankText(), fontSize = (fontSize+4).sp, textAlign = TextAlign.Center, modifier = Modifier.width(lineLength.dp))
            //Confirm order number
            Text(confirmNumberText(name=userName, confirm = confirmNumber),fontSize = fontSize.sp, textAlign = TextAlign.Center, modifier = Modifier.width(lineLength.dp))
            //Confirm email
            Text(emailText(email = email),fontSize = fontSize.sp, textAlign = TextAlign.Center, modifier = Modifier.width(lineLength.dp))
            //Navigation button out
            ButtonManager.NextButton(onClick =dashBoardButton, text = "Return to Dashboard")
        }
    }


    fun thankText(): AnnotatedString {
        //Builds annotated string for /BLUE/ thank you /NORMAL/ for scheduling a return with us
        var out: AnnotatedString = buildAnnotatedString {
            pushStyle(style = SpanStyle(color = getBlueIconColor())) //push style onto stack
            append("Thank you")
            pop() //pop style off stack
            append(" for scheduling a return with us!")
            toAnnotatedString()
        }
        return out;
    }


    fun confirmNumberText(name:String,
                          confirm:String,
                          ): AnnotatedString {
        //Builds annotated string for /NORMAL/ %NAME%, your pickup order /BLUE/ %CONFIRM#% /NORMAL/ is confirmed.
        val out = buildAnnotatedString {
            append(name)
            append("your pickup order ")
            pushStyle(style= SpanStyle(color= getBlueIconColor()))  // Push style onto stack
            append(confirm)
            pop() //pop style off stack
            append(" is confirmed.")
            toAnnotatedString()
        }
        return out
    }


    fun emailText(email:String): AnnotatedString {
        //Builds annotated string for /NORMAL/ A confirmation email will be sent to: /BLUE/ %EMAIL%
        val out =buildAnnotatedString {
            append("A confirmation email will be sent to: ")
            pushStyle(style = SpanStyle(color = getBlueIconColor())) //push style onto stack
            append(email)
            pop() //pop style off stack
            toAnnotatedString()
        }
        return out
    }
}