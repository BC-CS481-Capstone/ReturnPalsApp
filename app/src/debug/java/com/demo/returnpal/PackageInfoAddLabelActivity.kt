package com.demo.returnpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.returnpal.ui.theme.ReturnPalsAppTheme

class PackageInfoAddLabelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageInfoComponent()
            createbuttonConfirm()
        }
    }
    @Composable
    fun createbuttonConfirm() {
        Button(onClick = {
            var x = Intent(this,ThankYouActivity::class.java)
            startActivity(x)
        }) {
            Text("HERE PUSH ME")
        }
    }
}
