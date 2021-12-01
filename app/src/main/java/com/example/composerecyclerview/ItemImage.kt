package com.example.composerecyclerview

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.composerecyclerview.model.Movie

@Composable
fun ItemImage(image: Movie, modifier: Modifier) {
    Image(
        painter = painterResource(id = image.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}