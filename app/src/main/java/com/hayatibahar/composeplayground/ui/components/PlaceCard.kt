package com.hayatibahar.composeplayground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayatibahar.composeplayground.R
import com.hayatibahar.composeplayground.model.Place
import java.text.DecimalFormat

val decimalFormat = DecimalFormat("0.0")

@Composable
fun PlaceCard(place: Place) {
    val painter = painterResource(id = place.imgRes)
    Box(contentAlignment = Alignment.BottomStart) {
        Surface(
            shadowElevation = 4.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(painter = painter, contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clickable { }
                    .width(150.dp)
                    .height(200.dp))

        }

        Text(
            text = place.description,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun PlacesToBook(place: Place) {
    Card(
        modifier = Modifier
            .wrapContentWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.clickable { }) {
            PlaceContent(place = place, Modifier.width(140.dp))
            ImageContent(place = place)

        }

    }
}

@Composable
private fun ImageContent(place: Place) {
    Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.size(140.dp)) {
        val painter = painterResource(id = place.imgRes)

        Image(
            painter = painter, contentDescription = null,
            contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()
        )

        Surface(
            shape = CircleShape,
            modifier = Modifier
                .padding(6.dp)
                .size(32.dp),
            color = Color(0x77000000)
        ) {
            FavoriteButton(modifier = Modifier.padding(8.dp))

        }
    }
}

@Composable
private fun PlaceContent(place: Place, modifier: Modifier = Modifier) {
    val rating = place.rating
    val triple = getPlaceProperties(rating)

    val color = triple.first
    val text = triple.second
    val startCount = triple.third

    Column(
        modifier = modifier
            .height(140.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = place.description, fontWeight = FontWeight.Bold,
                fontSize = 18.sp, overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                repeat(startCount) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_12),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = color
                ) {
                    Text(
                        text = decimalFormat.format(rating),
                        modifier = Modifier.padding(2.dp),
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = text, color = color, fontSize = 12.sp)
            }
        }

        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$${place.price}", color = Color(0xff4CAF50))
        }

    }
}

@Composable
private fun getPlaceProperties(rating: Double): Triple<Color, String, Int> {
    val triple = if (rating > 8) {
        Triple(Color(0xff4CAF50), "Very good", 5)
    } else if (rating <= 8 && rating > 6) {
        Triple(Color(0xff2196F3), "Good", 4)
    } else if (rating > 4) {
        Triple(Color(0xffFFEB3B), "Mediocre", 3)
    } else if (rating > 2) {
        Triple(Color(0xffFF9800), "Bad", 2)
    } else {
        Triple(Color(0xffF44336), "Very bad", 1)
    }
    return triple
}