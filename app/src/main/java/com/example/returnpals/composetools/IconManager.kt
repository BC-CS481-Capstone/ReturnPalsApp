package com.example.returnpals.composetools

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.returnpals.R
import androidx.compose.ui.Modifier


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
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getBarcodeIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.barcode_500x320),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getBestchoiceIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.bestchoice_500x541),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getBoxIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.box_500x404),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getBoxholdIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.boxhold_500x472),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getBoxliftIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.boxlift_500x453),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getCalendarIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.calendar_500x517),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getCheckmarkIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.checkmark_500x300),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getComputerIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.computer_500x464),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getDoorstepIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.doorstep_500x440),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getFileIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.file_500x819),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    fun getHandoffIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.handoff_500x500),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getLabelIcon(modifier: Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.label_500x520),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getPinIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.pin_500x365),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getReturnPalNameIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.returnpal_500x196),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getReturnPalIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.returnpal_icon_500x500),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getStopwatchIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.stopwatch_500x448),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getTruckIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.truck_500x300),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getVanIcon(modifier: Modifier) {
        return Icon(
            painter = painterResource(id = R.drawable.van_500x295),
            contentDescription = null,
            modifier = modifier
        )
    }
}