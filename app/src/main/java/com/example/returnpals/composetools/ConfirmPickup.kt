package com.example.returnpals.composetools

import android.location.Address
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.security.AllPermission
import java.time.DayOfWeek
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ConfirmPickup {

    @Composable
    fun drawConfirmPickup(numberOfDigital: Int = 0,
                          numberOfPhysical: Int = 0,
                          visaLastFour: Int = 5555,
                          typeOfPickup: String = "Leave On Doorstep",
                          pickUpDate: Calendar = Calendar.getInstance(),
                          pickUpAddress: Address = Address(Locale.CANADA),
                          priceArray: Array<Int> = arrayOf(0,0,0),
                          nextButton:() -> Unit,
                          backButton: () -> Unit,
                          promoButton: () -> Unit)
    {
        // Set up as a row with progress on top
        Column(
            Modifier
                .background(getBackGroundColor())
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally ) {
            ProgressBar(modifier = Modifier, step = 4)

            //Text field
            Text("Confirm Your Pickup",Modifier .fillMaxWidth(),color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 38.sp,maxLines = 1)

            //Start the white box with summary info
            whiteBox(
                pickUpDate = pickUpDate,
                typeOfPickup = typeOfPickup,
                pickUpAddress = pickUpAddress,
                numberOfDigital = numberOfDigital,
                numberOfPhysical = numberOfPhysical,
                priceArray = priceArray,
                visaLastFour = visaLastFour
            )
            //end of the white box summary

            //Navigation buttons
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier =  Modifier.fillMaxWidth()) {
                ButtonManager.BackButton(onClick = backButton)
                ButtonManager.NextButton(onClick = nextButton)
            }
        }
    }
    @Composable
    fun whiteBox(pickUpDate:Calendar,typeOfPickup:String,pickUpAddress:Address,numberOfDigital:Int,numberOfPhysical:Int,priceArray:Array<Int>,visaLastFour:Int) {
        val config = getConfig()
        val wwith =(config.screenWidthDp - 32).dp
        val whieght = (config.screenHeightDp / 3 * 2).dp
        Column(
            Modifier
                .background(
                    Color.White,
                    shape = RoundedCornerShape(10)
                )
                .width(wwith)
                .height(whieght),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("Order Summary\n" +
                    "_________________",color = getBlueIconColor(),fontSize = 34.sp, maxLines = 2)

            val day = pickUpDate.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.getDefault())

            val month = pickUpDate.getDisplayName( Calendar.MONTH,Calendar.LONG,Locale.getDefault())
            val date = pickUpDate.get(Calendar.DATE)
            val fsize = (getConfig().screenWidthDp/20).sp
            //Confirm Date
            Text(day.toString()+" "+month.toString()+" "+date.toString(),Modifier,fontSize = 34.sp,maxLines = 1)
            //Confirm type of pickup as hand off or leave on door step
            Text(typeOfPickup,fontSize = 34.sp)
            //Avoid printing null if no address given
            if (pickUpAddress.getAddressLine(0) != null ) {
                Text(text = pickUpAddress.getAddressLine(0),fontSize = 28.sp)
            }
            if (pickUpAddress.getAddressLine(1) != null ) {
                Text(text = pickUpAddress.getAddressLine(1),fontSize = 28.sp)
            }
            if (pickUpAddress.getAddressLine(2) != null ) {
                Text(text = pickUpAddress.getAddressLine(2),fontSize = 28.sp)
            }
            //Confirm packages
            Text("Packages", fontWeight = FontWeight.Bold,fontSize = 34.sp, color = Color.Black)
            //Row with Icon and text
            Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                IconManager().getBoxIcon(modifier = Modifier.height(34.dp))
                Text(numberOfDigital.toString()+" Package with digital label",fontSize = fsize,maxLines = 1)
            }
            //Row with Icon and text
            Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                IconManager().getBoxIcon(modifier = Modifier.height(34.dp))
                Text("$numberOfPhysical Package with physical label",fontSize = fsize,maxLines = 1)
            }
            //Print payment if due
            //Should be able to skip if user is has already payed for a plan.
            if (priceArray[0]!=0) {
                Text("Visa ending $visaLastFour")
                Text("One-Time Return "+priceArray[0])
                Text("Tax "+priceArray[1])
                Text("Total "+priceArray[2])
            }

        }
    }

}