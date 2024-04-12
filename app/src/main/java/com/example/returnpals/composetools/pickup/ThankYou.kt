package com.example.returnpals.composetools.pickup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ReturnPalTheme
import com.example.returnpals.composetools.ButtonManager
import com.example.returnpals.composetools.IconManager
import com.example.returnpals.composetools.ScheduleReturnProgressBar
import com.example.returnpals.composetools.getBlueIconColor
import com.example.returnpals.composetools.getConfig



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

        Scaffold(
            topBar = { ScheduleReturnProgressBar(step=100) },
            bottomBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(10.dp)
                ) {
                    ButtonManager.NextButton(
                        onClick = dashBoardButton,
                        text = "Return to Dashboard"
                    )
                } },
        ) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp,20.dp)
            ) {
                IconManager().getTruckIcon(
                    modifier = Modifier.width(iconSize.dp)
                        .padding(vertical=20.dp)
                )
                //Thank you text
                Text(
                    thankText(),
                    fontSize = (fontSize+4).sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical=20.dp)
                )
                //Confirm order number
                Text(
                    confirmNumberText(
                        name=userName,
                        confirm = confirmNumber),
                    fontSize = fontSize.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical=20.dp)
                )
                //Confirm email
                Text(
                    emailText(email = email),
                    fontSize = fontSize.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical=20.dp)
                )
            }
        }
    }


    fun thankText(): AnnotatedString {
        //Builds annotated string for /BLUE/ thank you /NORMAL/ for scheduling a return with us
        return buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    lineHeight = 32.sp
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight(800),
                        color = getBlueIconColor()
                    )
                ) {
                    append("Thank you")
                }
                append(" for scheduling a return with us!")
            }
        }
    }


    fun confirmNumberText(name:String,
                          confirm:String,
                          ): AnnotatedString {
        //Builds annotated string for /NORMAL/ %NAME%, your pickup order /BLUE/ %CONFIRM#% /NORMAL/ is confirmed.
        return buildAnnotatedString {
            withStyle(
                ParagraphStyle(
                    lineHeight = 32.sp
                )
            ) {
                append("$name, your pickup order ")
                withStyle(
                    style = SpanStyle(
                        color = getBlueIconColor()
                    )
                ) {
                    append(confirm)
                }
                append(" is confirmed.")
            }
        }
    }


    fun emailText(email:String): AnnotatedString {
        //Builds annotated string for /NORMAL/ A confirmation email will be sent to: /BLUE/ %EMAIL%
        return buildAnnotatedString {
            withStyle(
                ParagraphStyle(
                    lineHeight = 32.sp
                )
            ) {
                append("A confirmation email will be sent to: ")
                withStyle(
                    style = SpanStyle(
                        color = getBlueIconColor()
                    )
                ) {
                    append(email)
                }
            }
        }
    }


@Preview
@Composable
private fun ThankYouPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            drawThankYouUI(

            ) {

            }
        }
    }
}