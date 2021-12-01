package com.example.composerecyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.composerecyclerview.model.Movie

@Composable
fun Rating(rating: Movie, modifier: Modifier) {
    Row (modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.star),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(16.dp)
        )

        Text(
            text = rating.rating.toString(),
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}