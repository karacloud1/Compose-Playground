package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayatibahar.composeplayground.ui.components.TutorialHeader
import com.hayatibahar.composeplayground.ui.components.TutorialText2


@Composable
private fun TutorialContent() {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TutorialHeader(text = "ListItem")
            TutorialText2(text = "one-line")
            OneLineListItemExample()
        }

        item {
            TutorialText2(text = "two-line")
            TwoLineListItemExample()

        }

        item {
            TutorialText2(text = "combined")
            CombinedListItemExample()
        }


    }
}

@Composable
fun OneLineListItemExample() {
    Column {
        ListItem(headlineContent = { Text("One line list item with no icon") })
        HorizontalDivider()
        ListItem(headlineContent = { Text("One line list item with 24x24 icon") },
            leadingContent = { Icon(Icons.Filled.Favorite, contentDescription = null) }
        )
        HorizontalDivider()
        ListItem(headlineContent = { Text("One line list item with 40x40 icon") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite, contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            })
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("One line list item with 56x56 icon") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            }
        )
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("One line clickable list item") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            },
            modifier = Modifier.clickable { }
        )
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("One line list item with trailing icon") },
            trailingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized Description"
                )
            }
        )
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("One line list item") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            trailingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
        )
        HorizontalDivider()

    }
}

@Composable
private fun TwoLineListItemExample() {
    Column {
        ListItem(headlineContent = { Text(text = "Two line list item") },
            overlineContent = { Text(text = "Over line ") },
            supportingContent = { Text(text = "Secondary text") },
            leadingContent = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            trailingContent = { Icon(Icons.Filled.Favorite, contentDescription = null) }
        )
    }
}

@Composable
fun CombinedListItemExample() {

    Column {
        var switched by remember { mutableStateOf(false) }
        val onSwitchedChanged: (Boolean) -> Unit = { switched = it }

        ListItem(
            headlineContent = { Text(text = "switch List item") },
            trailingContent = {
                Switch(checked = switched, onCheckedChange = null)
            }, modifier = Modifier.toggleable(
                value = switched,
                onValueChange = onSwitchedChanged
            )
        )
        HorizontalDivider()
        var checked by remember { mutableStateOf(true) }
        val onCheckedChanged: (Boolean) -> Unit = { checked = it }
        ListItem(
            headlineContent = { Text("Checkbox ListItem") },
            trailingContent = {
                Checkbox(
                    checked = checked,
                    onCheckedChange = null
                )
            },
            modifier = Modifier.toggleable(
                value = checked,
                onValueChange = onCheckedChanged
            )
        )
        HorizontalDivider()

    }

}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_9Preview() {
    TutorialContent()
}