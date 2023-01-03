package com.hkc.jetpackcomposedemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hkc.jetpackcomposedemo2.ViewModel.WeatherViewModel
import com.hkc.jetpackcomposedemo2.model.WeatherModel
import com.hkc.jetpackcomposedemo2.ui.theme.JetpackComposeDemo2Theme

class MainActivity : ComponentActivity() {

    private val weatherViewModel : WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetpackComposeDemo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    when (val result = )


//                    Column(horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(
//                                brush = Brush.verticalGradient(
//                                    colors = listOf(
//                                        color1,
//                                        color2,
//                                    )
//                                )
//                            )
//                        ) {
//                        Spacer(modifier = Modifier.height(40.dp))
//                        LocationScreen()
//                        Spacer(modifier = Modifier.height(40.dp))
//                        NowScreen()
//                        Spacer(modifier = Modifier.height(40.dp))
//                        weatherDayScreen()
//
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemo2Theme {
        Greeting("Android")
    }
}