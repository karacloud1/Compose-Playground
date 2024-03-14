package com.hayatibahar.composeplayground.basics

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayatibahar.composeplayground.ui.components.StyleableTutorialText
import com.hayatibahar.composeplayground.ui.components.TutorialHeader
import com.hayatibahar.composeplayground.ui.components.TutorialText2

@Preview(showBackground = true)
@Composable
fun Tutorial1_1Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            TutorialHeader(text = "Row")
            StyleableTutorialText(text = "1-) **Row** is a layout composable that places its children in a horizontal sequence.")
            RowExample()

            TutorialHeader(text = "Column")
            StyleableTutorialText(text = "2-) **Column** is a layout composable that places is children in a vertical sequence.")
            ColumnExample()

            StyleableTutorialText(
                text = "3-) Padding order determines whether it's padding or margin for that component." +
                        "In example below check out paddings."
            )
            ColumnsAndRowPaddingsExample()

            StyleableTutorialText(text = "4-) Shadow can be applied to Column or Row.")
            ShadowExample()

            StyleableTutorialText(
                text = "5-) **Box** aligns children on top of each other like a Stack." +
                        "The one declared last is on top."
            )
            BoxExample()

            StyleableTutorialText(text = "6-) Elements in Box can be aligned with different alignments.")
            BoxShadowAndAlignmentExample()

            StyleableTutorialText(text = "7-) Spacer can be used to align elements to end or bottom of screen")
            WeightExample()

            TutorialHeader(text = "Weight and Spacer")
            StyleableTutorialText(
                text = "8-) **Weight** determines, based on total weight, how much of the parent's " +
                        "dimensions should be occupied by each child. **Spacer** is used to " +
                        "create horizontal or vertical " +
                        "space between components."
            )
            WeightAndSpacerExample()


        }
    }
}


@Composable
fun RowExample() {

    TutorialText2(text = "Arrangement.Start")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        RowTexts()
    }
    TutorialText2(text = "Arrangement.End")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        RowTexts()
    }
    TutorialText2(text = "Arrangement.Center")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        RowTexts()
    }
    TutorialText2(text = "Arrangement.SpaceEvenly")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.SpaceAround")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.SpaceBetween")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        RowTexts()
    }

}

@Composable
fun ColumnExample() {
    val modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(200.dp)
        .background(Color.LightGray)

    TutorialText2(text = "Arrangement.Top")
    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
        ColumnTexts()
    }

    TutorialText2(text = "Arrangement.Bottom")
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        ColumnTexts()
    }

    TutorialText2(text = "Arrangement.Center")
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        ColumnTexts()
    }

    TutorialText2(text = "Arrangement.SpaceEvenly")
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        ColumnTexts()
    }

    TutorialText2(text = "Arrangement.SpaceAround")
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceAround) {
        ColumnTexts()
    }

    TutorialText2(text = "Arrangement.SpaceBetween")
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        ColumnTexts()
    }
}

@Composable
fun RowTexts() {
    Text(
        text = "Row1",
        modifier = Modifier
            .background(Color(0xFFFF9800))
            .padding(4.dp)
    )
    Text(
        text = "Row2", modifier = Modifier
            .background(Color(0xFFFFA726))
            .padding(4.dp)
    )
    Text(
        text = "Row3", modifier = Modifier
            .background(Color(0xFFFFB74D))
            .padding(4.dp)
    )
}

@Composable
fun ColumnTexts() {
    Text(
        text = "Column1", modifier = Modifier
            .background(Color(0xFF8BC34A))
            .padding(4.dp)
    )
    Text(
        text = "Column2", modifier = Modifier
            .background(Color(0xFF9CCC65))
            .padding(4.dp)
    )
    Text(
        text = "Column3", modifier = Modifier
            .background(Color(0xFFAED581))
            .padding(4.dp)
    )
}

@Composable
fun ColumnsAndRowPaddingsExample() {
    val rowModifier = Modifier
        .background(Color(0xFFF06292))
        .fillMaxWidth()
        .wrapContentHeight()

    val modifierA = Modifier
        .background(Color(0xFFFFEB3B))
        .padding(15.dp)

    val modifierB = Modifier
        .padding(10.dp)
        .background(Color(0xFF80DEEA))
        .padding(end = 15.dp)

    val modifierC = Modifier
        .background(Color(0xFF607D8B))
        .padding(15.dp)

    Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceEvenly) {

        Column(
            modifier = modifierA
                .background(Color(0xFFFFFFFF))
                .padding(8.dp)
        ) {
            Text(text = "Text A1")
            Text(text = "Text A2")
            Text(text = "Text A3")
        }

        Column(
            modifier = modifierB
                .background(Color(0xFF9575CD))
                .padding(top = 12.dp, bottom = 22.dp)
        ) {
            Text(text = "Text B1")
            Text(text = "Text B2")
            Text(text = "Text B3")
        }

        Column(modifier = modifierC.background(Color(0xFFB2FF59))) {
            Text(text = "Text C1")
            Text(text = "Text C2")
            Text(text = "Text C3")
        }

    }
}

@Composable
fun ShadowExample() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        RowTexts()
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        ColumnTexts()
    }
}

@Composable
fun BoxExample() {

    val modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .background(Color.LightGray)


//    Box(modifier = modifier) {
//        Text(
//            text = "First",
//            modifier = Modifier
//                .background(Color(0xFF1976D2))
//                .size(200.dp),
//            color = Color.White
//
//        )
//
//        Text(
//            text = "Second",
//            modifier = Modifier
//                .background(Color(0xFF2196F3))
//                .size(150.dp),
//            color = Color.White
//        )
//
//        Text(
//            text = "Third",
//            modifier = Modifier
//                .background(Color(0xFF64B5F6))
//                .size(100.dp),
//            color = Color.White
//        )
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color(0xFF1976D2))
                .size(200.dp)
                .padding(8.dp)
        ) {
            Text(
                text = "First",
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }

        Box(
            modifier = Modifier
                .background(Color(0xFF2196F3))
                .size(150.dp)
                .padding(8.dp)
        ) {
            Text(
                text = "Second",
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }

        Box(
            modifier = Modifier
                .background(Color(0xFF64B5F6))
                .size(100.dp)
                .padding(8.dp)
        ) {
            Text(
                text = "Third",
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun BoxShadowAndAlignmentExample() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.LightGray)
            .padding(8.dp)
    ) {

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "First",
                modifier = Modifier
                    .background(Color(0xFFFFA000))
                    .size(200.dp),
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "Second",
                modifier = Modifier
                    .background(Color(0xFFFFC107))
                    .size(150.dp),
                color = Color.White
            )
        }

        val modifier = Modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .align(Alignment.BottomStart)

        Box(modifier = modifier) {
            Text(
                text = "Third ",
                modifier = Modifier
                    .background(Color(0xFFFFD54F))
                    .size(100.dp),
                color = Color.White
            )
        }

    }
}

@Composable
fun WeightExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Row {
            Text(
                text = "Row1", modifier = Modifier
                    .background(Color(0xFFFF9800))
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Row2", modifier = Modifier
                    .background(Color(0xFFFFA726))
                    .padding(4.dp)
            )

            Text(
                text = "Row3", modifier = Modifier
                    .background(Color(0xFFFFB74D))
                    .padding(4.dp)
            )
        }

        Column(modifier = Modifier.height(200.dp)) {
            Text(
                text = "Column1", modifier = Modifier
                    .background(Color(0xFF8BC34A))
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Column2", modifier = Modifier
                    .background(Color(0xFF9CCC65))
                    .padding(4.dp)
            )
            Text(
                text = "Column3", modifier = Modifier
                    .background(Color(0xFFAED581))
                    .padding(4.dp)
            )
        }

    }
}

@Composable
fun WeightAndSpacerExample() {

    val modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color.LightGray)

    val rowModifier = Modifier
        .fillMaxHeight()
        .background(Color(0xFFA1887F))
        .padding(4.dp)

    Row(modifier = modifier) {
        Text(
            text = "Weight 2",
            fontSize = 12.sp,
            modifier = rowModifier.weight(2f)
        )

        Spacer(modifier = modifier.weight(1f))

        Text(
            text = "Weight 4",
            fontSize = 12.sp,
            modifier = rowModifier.weight(4f)
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
}


@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial1_1Preview() {
    TutorialContent()
}

