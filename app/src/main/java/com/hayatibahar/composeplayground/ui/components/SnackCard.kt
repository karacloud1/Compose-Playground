package com.hayatibahar.composeplayground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.hayatibahar.composeplayground.R
import com.hayatibahar.composeplayground.model.Snack
import kotlin.random.Random


@Composable
fun SnackCard(
    snack: Snack,
    textColor: Color = remember(snack.id) { randomColor() },
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(160.dp),
) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .clickable(onClick = {}),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = modifier,
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                placeholder(drawableResId = R.drawable.cat2)
                            }).build()
                    ),
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        text = snack.name
                    )
                    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
                        Text(text = "$${snack.price}", fontSize = 14.sp)
                        Text(text = "Tags: ${snack.tagline}", fontSize = 14.sp)
                    }
                }
            }

            FavoriteButton(
                modifier = Modifier
                    .padding(12.dp),
                color = textColor
            )

        }
    }
}

@Composable
fun HorizontalSnackCard(
    modifier: Modifier = Modifier,
    snack: Snack,
    textColor: Color = remember(snack.id) { randomColor() },
) {
    Box(contentAlignment = Alignment.TopEnd) {
        Column {
            Image(
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { },
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(drawableResId = R.drawable.cat2)
                        }).build()
                ),
                contentDescription = null,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = snack.name,
                modifier = Modifier.padding(2.dp),
                color = textColor,
                fontWeight = FontWeight.Bold,
            )
        }

        FavoriteButton(
            modifier = Modifier
                .padding(12.dp),
            color = textColor
        )
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63),
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(checked = isFavorite, onCheckedChange = { isFavorite = !isFavorite }) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = null,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            tint = color
        )
    }

}

private fun randomColor() = Color(
    Random.nextInt(255),
    Random.nextInt(255),
    Random.nextInt(255)
)