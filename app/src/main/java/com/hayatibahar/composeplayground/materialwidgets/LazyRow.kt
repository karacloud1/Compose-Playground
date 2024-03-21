package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayatibahar.composeplayground.model.places
import com.hayatibahar.composeplayground.model.snacks
import com.hayatibahar.composeplayground.ui.components.HorizontalSnackCard
import com.hayatibahar.composeplayground.ui.components.PlaceCard
import com.hayatibahar.composeplayground.ui.components.PlacesToBook
import com.hayatibahar.composeplayground.ui.theme.backgroundColor

@Composable
private fun TutorialContent() {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxHeight()
            .background(backgroundColor),
        content = {
            item {
                Text(
                    text = "Snacks",
                    color = Color(0xffE53935),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(snacks) {
                            HorizontalSnackCard(snack = it)
                        }
                    }
                )
            }

            item {
                Text(
                    text = "Places",
                    color = Color(0xff4CAF50),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(places) {
                            PlaceCard(place = it)
                        }
                    }
                )
            }

            item {
                Text(
                    text = "Places to Visit",
                    color = Color(0xff4CAF50),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(places) {
                            PlacesToBook(place = it)
                        }
                    }
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_6Preview() {
    TutorialContent()
}