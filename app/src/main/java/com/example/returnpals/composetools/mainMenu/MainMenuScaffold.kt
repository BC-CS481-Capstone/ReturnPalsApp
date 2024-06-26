import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun MainMenuScaffold(navigateRoute:(String)->Unit={}, content: @Composable () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

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
                backgroundColor = Color.White,
                elevation = 4.dp
            )
        },
        drawerContent = {
            val isSelected:(String)->Unit = {
                scope.launch {
                    scaffoldState.drawerState.close() // Close the drawer
                }
                navigateRoute(it)
            }
            DrawerContent(isSelected = isSelected)
        }
    ) {
        content()
    }
}



@Composable
fun DrawerContent( isSelected:(String)->Unit={}) {
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf("") }

    Column {
        DrawerItem(title = "Home", isSelected = selectedItem == "Home", onClick = {
            selectedItem = "Home"
            isSelected(MenuRoutes.Home)
        })
        DrawerItem(title = "About", isSelected = selectedItem == "About", onClick = {
            selectedItem = "About"
            isSelected(MenuRoutes.About)
        })
        DrawerItem(title = "Pricing", isSelected = selectedItem == "Pricing", onClick = {
            selectedItem = "Pricing"
            isSelected(MenuRoutes.Pricing)
        })
        /*DrawerItem(title = "Video", isSelected = selectedItem == "Video", onClick = {
            selectedItem = "Video"
            isSelected(MenuRoutes.Video)
            navigateToSc          */
        DrawerItem(title = "Contact", isSelected = selectedItem == "Contact", onClick = {
            selectedItem = "Contact"
            isSelected(MenuRoutes.Contact)
        })
        DrawerItem(title = "Sign In", isSelected = selectedItem == "Sign In", onClick = {
            selectedItem = "Sign In"
            isSelected(MenuRoutes.SignIn)
        })
        DrawerItem(title = "FAQ", isSelected = selectedItem == "FAQ", onClick = {
            selectedItem = "FAQ"
            isSelected(MenuRoutes.FAQ)
        })
    }
}

@Composable
fun DrawerItem(title: String, isSelected: Boolean, onClick: () -> Unit) {
    val selectedBlue = Color(0xFF008BE7)

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
            color = if (isSelected) selectedBlue else Color.Black,
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