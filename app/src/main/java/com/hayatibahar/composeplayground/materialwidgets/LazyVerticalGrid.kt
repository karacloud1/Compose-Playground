package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.hayatibahar.composeplayground.R
import com.hayatibahar.composeplayground.model.Snack
import com.hayatibahar.composeplayground.model.snacks
import com.hayatibahar.composeplayground.ui.components.GridSnackCard
import com.hayatibahar.composeplayground.ui.theme.backgroundColor

@Composable
private fun TutorialContent() {

    LazyVerticalGrid(
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        columns = GridCells.Fixed(3),
        content = {
            items(snacks) {
                GridSnackCard(snack = it)
            }
        }
    )

    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        columns = GridCells.Fixed(2),
        content = {
            items(snacks) {
                GridSnackCardWithTitle(snack = it)
            }
        }

    )
}

@Composable
fun GridSnackCardWithTitle(
    modifier: Modifier = Modifier,
    snack: Snack,
) {

    Column(
        modifier = modifier
            .heightIn(min = 200.dp)
            .shadow(1.dp, shape = RoundedCornerShape(5.dp))
            .background(Color.White)
    ) {

        val density = LocalDensity.current.density

        Image(contentScale = ContentScale.None,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .clickable { },
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(drawableResId = R.drawable.cat2)
                    }
                    ).build()
            ),
            contentDescription = null
        )

        var padding by remember { mutableStateOf(0.dp) }

        Text(modifier = Modifier.padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = padding),
            text = "Snack ${snack.name}",
            fontSize = 20.sp,
            onTextLayout = {
                val lineCount = it.lineCount
                val height = (it.size.height / density).dp
                padding = 4.dp + if (lineCount > 1) 0.dp else height
            })
    }

}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_8Preview() {
    TutorialContent()
}


