package com.hkc.jetpackcomposedemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                
            }
            val color = remember {
                mutableStateOf(Color.Yellow)
            }
            Column(Modifier.fillMaxSize()) {
                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                )
                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize()

                ) {

                }
            }

        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier,
            updateColor: (Color) ->
             ){
    val color = remember {
        mutableStateOf(Color.Yellow)
    }

    Box(modifier = Modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }

    ) {

    }
}

