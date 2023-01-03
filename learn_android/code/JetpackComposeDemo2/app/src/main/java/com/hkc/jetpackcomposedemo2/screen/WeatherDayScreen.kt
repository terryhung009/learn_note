package com.hkc.jetpackcomposedemo2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hkc.jetpackcomposedemo2.R

@Composable
fun weatherDayScreen(){
    val itemData = listOf<String>("A","A","A","A","A")
    LazyRow {
        items(itemData) {
            weatherDayItem()
        }

    }
}




@Composable
fun weatherDayItem(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 8.dp,end = 10.dp)) {
        ComposeText(text = "週日")
        Image(painter = painterResource(id = R.drawable.rainy), contentDescription = "")
        ComposeText(text = "27°/25°")


    }
    
}