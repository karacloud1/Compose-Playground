package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayatibahar.composeplayground.model.Snack
import com.hayatibahar.composeplayground.model.snacks
import com.hayatibahar.composeplayground.ui.components.FullWidthRow
import com.hayatibahar.composeplayground.ui.components.SnackCard
import kotlinx.coroutines.launch

@Composable
private fun TutorialContent() {

//    LazyColumn(
//        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        content = {
//            items(snacks) {
//                SnackCard(snack = it)
//            }
//        }
//    )

    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val list = remember { mutableStateListOf<Snack>() }

    Column {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = scrollState,
            modifier = Modifier.weight(1f),
            content = {
                items(list) {
                    SnackCard(snack = it)
                }
            })

        FullWidthRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }, shape = RoundedCornerShape(8.dp)) {
                Text(text = "Top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    if (snacks.isNotEmpty()) {
                        scrollState.animateScrollToItem(snacks.lastIndex)
                    }
                }
            }, shape = RoundedCornerShape(8.dp)) {
                Text(text = "Bottom")
            }

            Button(onClick = {
                if (list.size < snacks.size) {
                    list.add(snacks[list.size])
                }
            }, shape = RoundedCornerShape(8.dp)) {
                Text(text = "Add")
            }

            Button(onClick = {
                if (list.size > 0) {
                    list.removeLast()
                }
            }, shape = RoundedCornerShape(8.dp)) {
                Text(text = "Remove")
            }

        }
    }

}

@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_5Preview() {
    TutorialContent()
}