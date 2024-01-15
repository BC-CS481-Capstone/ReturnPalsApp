package com.example.returnpals.composetools

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.returnpals.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


public class IconManager {
    /*
    This is the icon manager class. Use this class to call Icons from resource folder.
    Uses the painter object api to pull R.drawable resources into an Icon object.
    Folloed examples from https://developer.android.com/jetpack/compose/resources
    * */
    @Composable
    fun getTruckIcon(modifier: Modifier) {
        return Icon(painter = painterResource(id = R.drawable.truck_500x300),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getPriceIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.bestchoice_500x541),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getComputerMonitorIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.computer_500x464),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getQRcodeIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.label_500x520),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getAmazonIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.amazon_icon_500x493),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getFileIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.file_500x819),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getDoorIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.doorstep_500x440),
            contentDescription = null,
            modifier = modifier
        )
    }
    @Composable
    fun getPackageIcon(modifier: Modifier) {
        Icon(painter = painterResource(id = R.drawable.handoff_500x500),
            contentDescription = null,
            modifier = modifier
        )
    }

}