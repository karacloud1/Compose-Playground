package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayatibahar.composeplayground.ui.components.FullWidthRow
import com.hayatibahar.composeplayground.ui.components.IndicatingIconButton
import com.hayatibahar.composeplayground.ui.components.TutorialHeader
import com.hayatibahar.composeplayground.ui.components.TutorialText2

@Preview(showBackground = true)
@Composable
private fun Tutorial2_2Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            val paddingModifier = Modifier.padding(8.dp)
            TutorialHeader(text = "Button")
            TutorialText2(text = "Button")
            ButtonExample(paddingModifier)

            DisabledButtonExample(paddingModifier)

            ButtonWithIconExample(paddingModifier)

            ButtonBackgroundExample(paddingModifier)

            GradientButtonExample(paddingModifier)

            IconButtonExample(paddingModifier)

            CustomIconButtonExample(paddingModifier)

            FloatingActionButtonExample(paddingModifier)

        }
    }

}

@Composable
private fun ButtonExample(modifier: Modifier) {
    FullWidthRow {
        Button(onClick = {}, modifier = modifier) {
            Text(text = "Button")
        }
        TextButton(onClick = {}, modifier = modifier) {
            Text(text = "TextButton")
        }
        OutlinedButton(onClick = {}, modifier = modifier) {
            Text(text = "OutlinedButton")
        }
    }

    FullWidthRow {
        Button(onClick = {}, modifier = modifier, shape = RoundedCornerShape(15.dp)) {
            Text(text = "Rounded")
        }
        Button(
            onClick = {}, modifier = modifier, shape = RoundedCornerShape(
                topStartPercent = 30,
                topEndPercent = 0,
                bottomStartPercent = 0,
                bottomEndPercent = 0
            )
        ) {
            Text(text = "Rounded")
        }

        Button(onClick = {}, modifier = modifier, shape = CutCornerShape(20)) {
            Text(text = "CutCorner")
        }
    }
}

@Composable
private fun DisabledButtonExample(modifier: Modifier) {
    FullWidthRow {
        Button(
            onClick = {},
            modifier = modifier, enabled = false
        ) {
            Text(text = "Button")
        }

        TextButton(onClick = {}, modifier = modifier, enabled = false) {
            Text(text = "TextButton")
        }

        OutlinedButton(onClick = {}, modifier = modifier, enabled = false) {
            Text(text = "OutlinedButton")
        }
    }
}

@Composable
fun ButtonWithIconExample(modifier: Modifier) {
    FullWidthRow {
        Button(onClick = {}, modifier = modifier) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Icon + Text")
            }
        }

        Button(onClick = {}, modifier = modifier) {
            Text(text = "Text + Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Button(onClick = {}, shape = RoundedCornerShape(20), modifier = modifier) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
            )
        }
    }

    FullWidthRow {
        OutlinedButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Default.Call, contentDescription = null,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )

            Text(text = "Icon+Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
private fun ButtonBackgroundExample(modifier: Modifier) {
    FullWidthRow {
        Button(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffF57C00),
                contentColor = Color(0xffB2EBF2)
            )
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {}, modifier = modifier, colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xff8BC34A)
            )
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {}, modifier = modifier, colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xff795548),
            )
        ) {
            Text(text = "OutlinedButton")
        }
    }
}

@Composable
private fun GradientButtonExample(modifier: Modifier) {
    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
            Color(0xffFFF9C4)
        )
    )

    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xff4E342E),
            Color(0xff8D6E63),
            Color(0xffD7CCC8)
        )
    )

    FullWidthRow {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = horizontalGradientBrush)
                .clickable(onClick = {})
                .then(modifier)
        ) {
            Text(text = "Horizontal Gradient")
        }

        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = verticalGradientBrush)
                .clickable { }
                .then(modifier)
        ) {
            Text(text = "Vertical Gradient")
        }
    }
}

@Composable
private fun IconButtonExample(modifier: Modifier) {
    FullWidthRow {
        IconButton(onClick = {}, modifier = modifier) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }

        var checked by remember {
            mutableStateOf(false)
        }

        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = modifier
        ) {
            val tint by animateColorAsState(
                targetValue = if (checked) Color(0xffE91E63) else Color(0xffB0BEC5),
                animationSpec = tween(durationMillis = 400)
            )

            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = tint)
        }
    }
}

@Composable
private fun CustomIconButtonExample(modifier: Modifier) {
    FullWidthRow(modifier.padding(horizontal = 30.dp)) {
        IndicatingIconButton(
            onClick = {},
            indication = rememberRipple(
                bounded = false,
                radius = 40.dp,
                color = Color(0xff42A5F5)
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        IndicatingIconButton(
            onClick = { },
            indication = rememberRipple(
                bounded = false,
                radius = 30.dp,
                color = Color(0xffBF360C)
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63)
            )
        }
    }
}

@Composable
private fun FloatingActionButtonExample(modifier: Modifier) {
    FullWidthRow {
        FloatingActionButton(onClick = {}, modifier = modifier) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }

        FloatingActionButton(
            onClick = {},
            modifier = modifier,
            containerColor = Color(0xffFFA000)
        ) {
            Icon(imageVector = Icons.Filled.Done, contentDescription = null)
        }

        ExtendedFloatingActionButton(
            onClick = {},
            modifier = modifier
        ) {
            Text(text = "Extended")
        }

        ExtendedFloatingActionButton(
            onClick = {},
            containerColor = Color(0xffEC407A),
            modifier = modifier

        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color.White
            )
            Text(text = "Like", color = Color.White)

        }


    }
}


@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_2Preview() {
    TutorialContent()
}

