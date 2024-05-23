
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.returnpals.R
import com.example.returnpals.navigation.MenuRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardMenuScaffold(navController: NavController, isLoggedIn: Boolean, onLogOut: () -> Unit = {}, content: @Composable () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    //if (!isLoggedIn) navigateToScreen(navController, MenuRoutes.Home, scaffoldState, scope)
    //Removed this logic as it would not work when the app closed and opened again
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.returnpal_500x196),
                            contentDescription = "ReturnPals Logo",
                            modifier = Modifier.size(190.dp)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                backgroundColor = Color(0xFF052A42),
                elevation = 4.dp
            )
        },
        drawerContent = {
            DrawerContent1(navController = navController, scaffoldState = scaffoldState, onLogOut = onLogOut)
        }
    ) {
        content()
    }
}



@Composable
fun DrawerContent1(navController: NavController, scaffoldState: ScaffoldState, onLogOut: () -> Unit) {
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf("") }
    val dashBlue = Color(0xFF052A42)

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .background(dashBlue)
    ) {
        DrawerItem1(title = "Dashboard", isSelected = selectedItem == "Dashboard", onClick = {
            selectedItem = "Dashboard"
            navigateToScreen(navController, MenuRoutes.HomeDash, scaffoldState, scope)
        })
        DrawerItem1(title = "Profile", isSelected = selectedItem == "Profile", onClick = {
            selectedItem = "Profile"
            navigateToScreen(navController, MenuRoutes.Profile, scaffoldState, scope)
        })
        DrawerItem1(title = "Orders", isSelected = selectedItem == "Orders", onClick = {
            selectedItem = "Orders"
            navigateToScreen(navController, MenuRoutes.Orders, scaffoldState, scope)
        })
        DrawerItem1(title = "Settings", isSelected = selectedItem == "Settings", onClick = {
            selectedItem = "Settings"
            navigateToScreen(navController, MenuRoutes.Settings, scaffoldState, scope)
        })

        //Add more if needed

        Spacer(modifier = Modifier.weight(1f)) // This pushes the items below it to the bottom

        DrawerItem1(title = "Sign Out", isSelected = selectedItem == "Sign Out", onClick = {
            onLogOut()
            selectedItem = "Sign Out"
//            navigateToScreen(navController, MenuRoutes.Home, scaffoldState, scope)    // will navigate right back to home dash because log out takes some time to complete

//            signOut {
//                Log.i("signOut",it.toString())
//                Backend.resetEmail()
//                selectedItem = "Sign Out"
//                GlobalScope.launch(Dispatchers.Main) {  navigateToScreen(navController, MenuRoutes.Home, scaffoldState, scope)}
//            }
        })
    }
}

@Composable
fun DrawerItem1(title: String, isSelected: Boolean, onClick: () -> Unit) {
    val selectedBlue = Color(0xFF008BE7)
    val dashBlue = Color(0xFF052A42)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(dashBlue)
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                // fontFamily = customFont
            ),
            color = if (isSelected) selectedBlue else Color.White,
            modifier = Modifier.padding(2.dp)

        )

    }
}
// Helper function to navigate to a screen and close the drawer
private fun navigateToScreen(
    navController: NavController,
    route: String,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
    scope.launch {
        scaffoldState.drawerState.close() // Close the drawer
    }
}