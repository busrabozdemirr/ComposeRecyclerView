package com.example.composerecyclerview

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun TextItem(
    text: String? = null,
    fontSize: Int = 12,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.orEmpty(),
        style = TextStyle(fontSize = fontSize.sp, fontWeight = fontWeight),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}