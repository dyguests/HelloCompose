package com.fanhl.hellocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.fanhl.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SimpleWidgetColumn()
                }
            }
        }
    }

}

@Composable
private fun SimpleWidgetColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Text1")
        Text(text = "Text1")
        val context = LocalContext.current
        val text = remember { mutableStateOf("Button") }
        Button(onClick = { text.value = "23333" }) {
            Text(text = text.value)
        }
        TextField(value = "", onValueChange = {}, placeholder = { Text(text = "Placeholder") }, colors = TextFieldDefaults.colors())
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "A dog")
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
private fun SimpleWidgetColumnPreview() {
    HelloComposeTheme {
        SimpleWidgetColumn()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloComposeTheme {
        Greeting("Android")
    }
}