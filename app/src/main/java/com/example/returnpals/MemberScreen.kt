package com.example.returnpals

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.returnpals.ui.theme.Background
import com.example.returnpals.ui.theme.ReturnPalsTheme

class MemberScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReturnPalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Background
                ) {
                    MemberScreenContent()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberScreenContent() {
    Scaffold(
        topBar = { MemberTopAppBar() },
        // The background color for the content area can be set here if needed
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), // Apply inner padding to respect the app bar space
            color = Background // Set the background color
        ) {
            Greeting2("Member") // Your screen content
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberTopAppBar() {
    val appBarHeight = 56.dp

    TopAppBar(
        modifier = Modifier.height(appBarHeight),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Replace with your logo resource
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo"
                )
                // You can add more elements here if needed
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle menu icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        }
    )
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "Hello $name!",
        // Add more modifiers as needed
    )
}
