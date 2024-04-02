package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayatibahar.composeplayground.model.Snack
import com.hayatibahar.composeplayground.model.snacksOrdered
import com.hayatibahar.composeplayground.ui.components.SnackCard

@ExperimentalFoundationApi
@Composable
private fun TutorialContent() {
    val grouped: Map<Char, List<Snack>> = snacksOrdered.groupBy { it.name[0] }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {

            grouped.forEach { (initial: Char, snacks: List<Snack>) ->

                stickyHeader {
                    SnackHeader(initial)
                }

                items(snacks) {
                    SnackCard(snack = it)
                }
            }
        })
}

@Composable
private fun SnackHeader(initial: Char) {
    Text(
        text = "$initial",
        fontSize = 24.sp,
        color = Color(0xff039BE5),
        modifier = Modifier
            .background(Color(0xffE3F2FD))
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    )

}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_7Preview() {
    TutorialContent()
}