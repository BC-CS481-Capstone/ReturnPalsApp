package com.example.returnpals.mainMenu

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.returnpals.composetools.IconManager

@Composable
fun Home(navController: NavController) {
    Text(text = "Test")


    var icon = IconManager()
        Column() {
            icon.getTruckIcon(Modifier)
            icon.getComputerIcon(Modifier)
            icon.getLabelIcon(Modifier)
            icon.getAmazonIcon(Modifier)
            icon.getFileIcon(Modifier)
            icon.getDoorstepIcon(Modifier)
            icon.getHandoffIcon(Modifier)
        }
}