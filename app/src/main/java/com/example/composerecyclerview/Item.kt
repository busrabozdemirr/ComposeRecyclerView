package com.example.composerecyclerview

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.composerecyclerview.model.Movie

@Composable
fun Item(movie: Movie) {

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        backgroundColor = if (isExpanded) colorResource(id = R.color.light_purple) else colorResource(
            id = R.color.dark_purple
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        ConstraintLayout {
            val (image, column, rating) = createRefs()

            ItemImage(
                image = movie,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    }
                    .size(48.dp)
            )

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(column) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .animateContentSize()
            ) {
                if (isExpanded) {
                    TextItem(text = movie.title, fontSize = 16, fontWeight = FontWeight.SemiBold)
                    TextItem(
                        text = movie.description,
                        fontSize = 12,
                        modifier = Modifier.padding(end = 16.dp),
                        maxLines = 6

                    )
                } else {
                    TextItem(text = movie.title, fontSize = 16, fontWeight = FontWeight.Bold)
                    TextItem(text = movie.description, maxLines = 2)
                }
            }

            Rating(
                rating = movie,
                modifier = Modifier
                    .padding(bottom = 8.dp, end = 16.dp)
                    .constrainAs(rating) {
                        top.linkTo(column.bottom)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}