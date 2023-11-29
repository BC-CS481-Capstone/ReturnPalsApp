package com.example.returnpals

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.returnpals.dashboard.Dashboard
import com.example.returnpals.dashboardmenu.DashboardMenu

class MemberHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var showMenu by remember { mutableStateOf(false) }

            Box {
                Dashboard(menu = { showMenu = true })

                // Semi-transparent background
                if (showMenu) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { showMenu = false }
                            .background(Color.Black.copy(alpha = 0.5f))
                    )
                }

                AnimatedVisibility(
                    visible = showMenu,
                    enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }),
                    exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
                ) {
                    DashboardMenu(
                        // Your DashboardMenu content
                    )
                }
            }
        }
    }
}