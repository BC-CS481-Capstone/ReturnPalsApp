package com.example.returnpals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.registerForActivityResult
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import com.example.returnpals.ui.theme.ReturnPalsTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReturnPalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Button(onClick = { returnPalMediaSelector.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly)) }) {Text("Button")}
                }

            }




        }
    }
    val returnPalMediaSelector = registerForActivityResult(PickVisualMedia()) {uri ->
        if (uri!= null) {
            Log.d("PhotoPicked", "Selected URI: $uri")
        } else{
            Log.d("PhotoPicker", "No Media selected")
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReturnPalsTheme {
        Greeting("Android")
    }
}
