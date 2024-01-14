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
    fun getTruckIcon() {
        return Icon(painter = painterResource(id = R.drawable.truck_100x101),
            contentDescription = null,
            modifier = Modifier.size(width = 360.dp, height = 360.dp)
        )
    }
    @Composable
    fun getPriceIcon() {
        //TODO find Price Icon
        //Icon(painter = painterResource(id = TODO),
        //    contentDescription = null
        //)
    }
    @Composable
    fun getComputerMonitorIcon() {
        Icon(painter = painterResource(id = R.drawable.computer_100x93),
            contentDescription = null
        )
    }
    @Composable
    fun getQRcodeIcon() {
        Icon(painter = painterResource(id = R.drawable.label_100x104),
            contentDescription = null
        )
    }
    @Composable
    fun getAmazonIcon() {
        Icon(painter = painterResource(id = R.drawable.amazon_icon_100x99),
            contentDescription = null
        )
    }
    @Composable
    fun getFileIcon() {
        Icon(painter = painterResource(id = R.drawable.file_100x164),
            contentDescription = null
        )
    }
    @Composable
    fun getDoorIcon() {
        Icon(painter = painterResource(id = R.drawable.doorstep_100x88),
            contentDescription = null
        )
    }
    @Composable
    fun getPackageIcon() {
        Icon(painter = painterResource(id = R.drawable.handoff_100x101),
            contentDescription = null
        )
    }

}