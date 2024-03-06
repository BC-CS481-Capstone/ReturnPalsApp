package com.example.returnpals.composetools

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.returnpals.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale


public class IconManager {
    /*
    This is the icon manager class. Use this class to call Icons from resource folder.
    Uses the painter object api to pull R.drawable resources into an Icon object.
    Folloed examples from https://developer.android.com/jetpack/compose/resources
    * */
    @Composable
    fun getAmazonIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.amazon_icon_500x493),
            contentDescription = "Amazon Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getBarcodeIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.barcode_500x320),
            contentDescription = "Barcode Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getBestchoiceIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.bestchoice_500x541),
            contentDescription = "Bestchoice Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getBoxIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.box_500x404),
            contentDescription = "Box Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getBoxholdIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.boxhold_500x472),
            contentDescription = "Boxhold Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getBoxliftIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.boxlift_500x453),
            contentDescription = "Boxlift Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getCalendarIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.calendar_500x517),
            contentDescription = "Calendar Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getCheckmarkIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.checkmark_500x300),
            contentDescription = "Checkmark Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getComputerIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.computer_500x464),
            contentDescription = "Computer Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getDoorstepIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.doorstep_500x440),
            contentDescription = "Doorstep Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getFileIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.file_500x819),
            contentDescription = "File Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }

    @Composable
    fun getHandoffIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.handoff_500x500),
            contentDescription = "Handoff Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
    @Composable
    fun getLabelIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.label_500x520),
            contentDescription = "Label Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
    @Composable
    fun getPinIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.pin_500x365),
            contentDescription = "Pin Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
    @Composable
    fun getReturnPalNameIcon(modifier: Modifier) {
        Image(
            painter = painterResource(id = R.drawable.returnpal_500x196),
            contentDescription = "ReturnPalName Image",
            contentScale = ContentScale.FillWidth,
            modifier = modifier
        )
    }
    @Composable
    fun getReturnPalIcon(modifier: Modifier) {
        Image(
            painter = painterResource(id = R.drawable.returnpal_icon_500x500),
            contentDescription = "ReturnPal Image",
            modifier = modifier
        )
    }
    @Composable
    fun getStopwatchIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.stopwatch_500x448),
            contentDescription = "Stopwatch Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
    @Composable
    fun getTruckIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.truck_500x300),
            contentDescription = "Truck Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
    @Composable
    fun getVanIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.van_500x295),
            contentDescription = "Van Icon",
            modifier = modifier,
            tint = getBlueIconColor()
        )
    }
}