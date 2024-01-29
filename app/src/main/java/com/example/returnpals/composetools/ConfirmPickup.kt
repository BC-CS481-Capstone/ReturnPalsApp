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
    fun drawConfirmPickup(numberOfDigitial: Int = 0,
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
            Text("Confirm Your Pickup",Modifier .fillMaxWidth(),color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 38.sp,maxLines = 1)
            Column(Modifier.background(Color.White,shape = RoundedCornerShape(10) ),verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally ) {
                Text("Order Summary\n" +
                        "_________________",color = getBlueIconColor(),fontSize = 34.sp, maxLines = 2)

                val day = pickUpDate.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.getDefault())

                val month = pickUpDate.getDisplayName( Calendar.MONTH,Calendar.LONG,Locale.getDefault())
                val date = pickUpDate.get(Calendar.DATE)

                Text(day.toString()+" "+month.toString()+" "+date.toString(),Modifier,fontSize = 26.sp,maxLines = 1)
                Text(typeOfPickup)
                if (pickUpAddress.getAddressLine(0) != null ) {
                    Text(text = pickUpAddress.getAddressLine(0))
                }
                if (pickUpAddress.getAddressLine(1) != null ) {
                    Text(text = pickUpAddress.getAddressLine(1))
                }
                if (pickUpAddress.getAddressLine(2) != null ) {
                    Text(text = pickUpAddress.getAddressLine(2))
                }
                Text("Packages", fontWeight = FontWeight.Bold,fontSize = 22.sp, color = Color.Black)
                Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                    IconManager().getBoxIcon(modifier = Modifier.height(22.dp))
                    Text(numberOfDigitial.toString()+" Package with digital label",fontSize = 20.sp,maxLines = 1)
                }
                Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                    IconManager().getBoxIcon(modifier = Modifier.height(22.dp))
                    Text(numberOfPhysical.toString()+" Package with physical label",fontSize = 20.sp,maxLines = 1)
                }

                if (priceArray[0]!=0) {
                    Text("Visa ending "+visaLastFour)
                    Text("One-Time Return "+priceArray[0])
                    Text("Tax "+priceArray[1])
                    Text("Total "+priceArray[2])
                }

            }
            Row(Modifier) {
                ButtonManager.BackButton(onClick = backButton)
                ButtonManager.NextButton(onClick = nextButton)
            }
        }
    }

}