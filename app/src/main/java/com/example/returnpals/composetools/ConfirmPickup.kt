package com.example.returnpals.composetools

import android.location.Address
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Row(Modifier) {
            ProgressBar(modifier = Modifier, step = 4)
            Text("Confirm Your Pickup",Modifier)
            Row(Modifier.background(Color.White,shape = RoundedCornerShape(10) )) {
                val day = pickUpDate.get(Calendar.DAY_OF_WEEK)
                val month = pickUpDate.get(Calendar.MONTH)
                val date = pickUpDate.get(Calendar.DATE)
                Text("pickUpDate")
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
                Text("Packages")
                Text("Package with digital label")
                Text("Package with physical label")
                Text("Visa ending")
                if (priceArray[0]!=0) {
                    Text("One-Time Return")
                    Text("Tax")
                    Text("Total")
                }
                Text("Promo and Apply")
            }
            Column(Modifier) {
                ButtonManager.BackButton(onClick = backButton)
                ButtonManager.NextButton(onClick = nextButton)
            }
        }
    }

}