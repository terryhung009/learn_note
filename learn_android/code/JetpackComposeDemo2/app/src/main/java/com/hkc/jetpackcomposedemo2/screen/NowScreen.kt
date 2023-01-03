package com.hkc.jetpackcomposedemo2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hkc.jetpackcomposedemo2.R
import com.hkc.jetpackcomposedemo2.ui.theme.color2
import com.hkc.jetpackcomposedemo2.ui.theme.color3


@Composable
fun NowScreen() {
    Image(painter = painterResource(id = R.drawable.sunny2), contentDescription = "")
    ComposeText(text = "27°",fontsize = 40.sp)
    
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxWidth(0.5f),
        color = color2,
        shape = RoundedCornerShape(48)

    ) {
        Row(horizontalArrangement = SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            ) {
            ComposeText(text = "東南風",fontsize = 16.sp,textColor = Color.Black)
            ComposeText(text = "2級",fontsize = 16.sp,textColor = Color.Black)
            ComposeText(text = "濕度",fontsize = 16.sp,textColor = Color.Black)
            ComposeText(text = "75%",fontsize = 16.sp,textColor = Color.Black)


        }
    }
}