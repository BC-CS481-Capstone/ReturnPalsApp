package com.example.returnpals.ui.pickup

import android.location.Address
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.returnpals.ui.theme.ReturnPalTheme
import com.example.returnpals.ui.IconManager
import com.example.returnpals.ui.getBackGroundColor
import com.example.returnpals.ui.getBlueIconColor
import com.example.returnpals.ui.getConfig
import java.util.Calendar
import java.util.Locale

class ConfirmPickup {

    @Composable
    fun drawConfirmPickup(numberOfDigital: Int = 0,
                          numberOfPhysical: Int = 0,
                          numberOfQRCodes: Int = 0,
                          visaLastFour: Int = 5555,
                          typeOfPickup: String = "Leave On Doorstep",
                          pickUpDate: Calendar = Calendar.getInstance(),
                          pickUpAddress: Address = Address(Locale.CANADA),
                          priceArray: Array<Int> = arrayOf(0,0,0),
                          nextButton:() -> Unit,
                          backButton: () -> Unit,
                          promoButton: () -> Unit)
    {
        ScheduleReturnScaffold(
            step = 5,
            onClickBack = backButton,
            onClickNext = nextButton,
            nextButtonText = "Confirm"
        ) { padding ->
            // Set up as a row with progress on top
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(getBackGroundColor())
                    .padding(padding)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Confirm Your Pickup",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    //Start the white box with summary info
                    WhiteBox(
                        pickUpDate = pickUpDate,
                        typeOfPickup = typeOfPickup,
                        pickUpAddress = pickUpAddress,
                        numberOfDigital = numberOfDigital,
                        numberOfPhysical = numberOfPhysical,
                        numberOfQRCodes = numberOfQRCodes,
                        priceArray = priceArray,
                        visaLastFour = visaLastFour
                    )
                    //end of the white box summary
                }
            }
        }
    }
    @Composable
    fun WhiteBox(
        pickUpDate: Calendar,
        typeOfPickup: String,
        pickUpAddress: Address,
        numberOfDigital: Int,
        numberOfPhysical: Int,
        numberOfQRCodes: Int,
        priceArray: Array<Int>,
        visaLastFour: Int
    ) {
        Column(
            Modifier
                .background(
                    ReturnPalTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(10)
                )
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Order Summary\n" +
                    "_________________",color = getBlueIconColor(),fontSize = 34.sp, maxLines = 2)

            val day = pickUpDate.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.getDefault())

            val month = pickUpDate.getDisplayName( Calendar.MONTH,Calendar.LONG,Locale.getDefault())
            val date = pickUpDate.get(Calendar.DATE)

            //Confirm Date
            Text(day.toString()+" "+month.toString()+" "+date.toString(),fontSize = 34.sp,maxLines = 1)

            //Confirm type of pickup as hand off or leave on door step
            Text(typeOfPickup,fontSize = 26.sp)

            //Avoid printing null if no address given
            printAddressLines(pickUpAddress)

            //Confirm packages
            PackagesText(numberOfDigital, numberOfPhysical, numberOfQRCodes)

            //Print payment if due. Should be able to skip if user is has already payed for a plan.
            printPriceArray(priceArray,visaLastFour)

        }
    }
    @Composable
    fun printPriceArray(priceArray:Array<Int>,visaLastFour:Int) {
        if (priceArray[0]!=0) {
            Text("Visa ending $visaLastFour")
            Text("One-Time Return ${priceArray[0]}")
            Text("Tax ${priceArray[1]}")
            Text("Total ${priceArray[2]}")
        }
    }
    @Composable
    fun printAddressLines(pickUpAddress:Address) {
        //Avoid printing null if no address given
        val fsize = (getConfig().screenWidthDp/20)
        if (pickUpAddress.getAddressLine(0) != null ) {
            Text(text = pickUpAddress.getAddressLine(0),fontSize = fsize.sp)
        }
        if (pickUpAddress.getAddressLine(1) != null ) {
            Text(text = pickUpAddress.getAddressLine(1),fontSize = fsize.sp)
        }
        if (pickUpAddress.getAddressLine(2) != null ) {
            Text(text = pickUpAddress.getAddressLine(2),fontSize = fsize.sp)
        }
    }

    @Composable
    private fun PackagesText(
        numberOfDigital: Int,
        numberOfPhysical: Int,
        numberOfQRCodes: Int,
    ) {
        val fsize = (getConfig().screenWidthDp/16)

        Text(
            text = "Packages",
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            color = Color.Black
        )
        //Row with Icon and text
        Row(
            horizontalArrangement =  Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical=6.dp)
        ) {
            IconManager().getBoxIcon(modifier = Modifier.height(fsize.dp))
            Text(
                text = numberOfDigital.toString() + " digital labels",
                fontSize = fsize.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
        //Row with Icon and text
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical=6.dp)
        ) {
            IconManager().getBoxIcon(modifier = Modifier.height(fsize.dp))
            Text(
                text = "$numberOfPhysical physical labels",
                fontSize = fsize.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
        //Row with Icon and text
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical=6.dp)
        ) {
            IconManager().getBoxIcon(modifier = Modifier.height(fsize.dp))
            Text(
                text = "$numberOfQRCodes QR codes",
                fontSize = fsize.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }

}

@Preview
@Composable
private fun ConfirmPickupPreview() {
    ReturnPalTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ConfirmPickup().drawConfirmPickup(
                nextButton = { /*TODO*/ },
                backButton = { /*TODO*/ },
                priceArray = arrayOf(11,1,12),
            ) {
                
            }
        }
    }
}