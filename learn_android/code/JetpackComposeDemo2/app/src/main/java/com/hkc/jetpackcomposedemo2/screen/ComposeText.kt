package com.hkc.jetpackcomposedemo2.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


//@Preview
@Composable
fun ComposeText(text: String, textColor: Color = Color.White, fontsize: TextUnit = 30.sp) {
    Text(
        text = text ,
        color = textColor ,
        fontSize = fontsize,
        fontWeight = FontWeight.Bold,
    )


}