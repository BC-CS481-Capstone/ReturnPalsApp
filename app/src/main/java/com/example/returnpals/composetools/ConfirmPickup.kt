package com.example.returnpals.composetools

import android.location.Address
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.Date
import java.util.Locale

class ConfirmPickup {

    @Composable
    fun drawConfirmPickup(numberOfDigitial: Int = 0,
                          numberOfPhysical: Int = 0,
                          visaLastFour: Int = 5555,
                          pickUpDate: Date = Date(),
                          pickUpAddress: Address = Address(Locale.CANADA),
                          priceArray: Array<Int> = arrayOf(0,0,0),
                          nextButton:() -> Unit,
                          backButton: () -> Unit,
                          promoButton: () -> Unit)
    {

    }

}