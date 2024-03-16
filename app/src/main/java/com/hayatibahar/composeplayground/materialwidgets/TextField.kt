package com.hayatibahar.composeplayground.materialwidgets

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayatibahar.composeplayground.ui.components.StyleableTutorialText
import com.hayatibahar.composeplayground.ui.components.TutorialHeader
import com.hayatibahar.composeplayground.ui.components.TutorialText2

@Composable
private fun TutorialContent() {
    LazyColumn(Modifier.fillMaxSize()) {

        item {
            val fullWidthModifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

            TutorialHeader(text = "TextField")

            StyleableTutorialText(
                text = "1-) **TextField** let users enter and edit text. remember is " +
                        "used with MutableState to store state of text or TextFieldValue"
            )

            val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }
            TextField(
                modifier = fullWidthModifier,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "PlaceHolder") },
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                })

            TutorialText2(text = "Error")

            val errorText = remember { mutableStateOf(TextFieldValue("Don't leave blank")) }

            TextField(
                modifier = fullWidthModifier,
                label = { Text(text = "Placeholder") },
                isError = errorText.value.text.isEmpty(),
                value = errorText.value,
                onValueChange = {
                    errorText.value = it
                })

            TutorialText2(text = "Colors")
            TextField(
                modifier = fullWidthModifier,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xffFFD54F),
                    unfocusedContainerColor = Color(0xffFFD54F),
                    focusedContainerColor = Color(0xffFFD54F),
                    disabledTextColor = Color(0xff42A5F5),
                    errorLabelColor = Color(0xff2E7D32),
                    disabledLabelColor = Color(0xff42A5F5)
                )
            )

            TutorialText2(text = "Colors & Text Style")
            TextField(
                modifier = fullWidthModifier,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xffFFD54F),
                    unfocusedContainerColor = Color(0xffFFD54F),
                    focusedContainerColor = Color(0xffFFD54F),
                    errorLabelColor = Color(0xff2E7D32),
                    disabledLabelColor = Color(0xff42A5F5),
                    focusedLabelColor = Color(0xffAEEA00),
                    focusedPlaceholderColor = Color(0xffFFE082),
                    unfocusedPlaceholderColor = Color(0xffFFE082),
                    disabledPlaceholderColor = Color(0xffFFE082),
                ),
                textStyle = TextStyle(
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
            TutorialText2(text = "Shape")
            Surface(
                contentColor = Color.White,
                color = Color(0xffEC407A),
                modifier = fullWidthModifier,
                shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ) {
                TextField(
                    value = textFieldValue.value,
                    onValueChange = { newValue ->
                        textFieldValue.value = newValue
                    },
                    placeholder = { Text(text = "Search") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            TextField(
                modifier = fullWidthModifier, value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                label = { Text(text = "Label") },
                placeholder = { Text(text = "No Bottom Line") },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xff607D8B),
                    unfocusedContainerColor = Color(0xff607D8B),
                    focusedContainerColor = Color(0xff607D8B),
                    focusedPlaceholderColor = Color(0xffFFEA00),
                    unfocusedPlaceholderColor = Color(0xffFFEA00),
                    disabledPlaceholderColor = Color(0xffFFEA00),
                    unfocusedLabelColor = Color(0xff795548),
                    focusedLabelColor = Color(0xff66BB6A),
                    cursorColor = Color(0xffE1F5FE),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
            )

            TutorialText2(text = "Outlined")

            OutlinedTextField(
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                modifier = fullWidthModifier,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
            )

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = textFieldValue.value,
                placeholder = { Text("Placeholder") },
                onValueChange = { newValue ->
                    textFieldValue.value = newValue
                }
            )

            OutlinedTextField(
                value = textFieldValue.value, onValueChange = {
                    textFieldValue.value = it
                },
                modifier = fullWidthModifier,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Blue,
                    disabledTextColor = Color.Blue,
                    focusedContainerColor = Color.Yellow,
                    unfocusedContainerColor = Color.Yellow,
                    disabledContainerColor = Color.Yellow,
                    focusedPlaceholderColor = Color(0xffFFF176),
                    unfocusedPlaceholderColor = Color(0xffFFF176),
                    disabledPlaceholderColor = Color(0xffFFF176),
                    unfocusedLabelColor = Color(0xff795548),
                    focusedLabelColor = Color(0xff66BB6A),
                    errorLabelColor = Color(0xffFF1744),
                    unfocusedIndicatorColor = Color(0xffEF9A9A),
                    focusedIndicatorColor = Color(0xff1976D2)
                )
            )

            TutorialText2(text = "Single Line and Line Height")

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = textFieldValue.value,
                label = { Text("Single Line") },
                placeholder = { Text("Placeholder") },
                onValueChange = { newValue ->
                    textFieldValue.value = newValue
                },
                singleLine = true
            )

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = textFieldValue.value,
                label = { Text("Max Lines 2") },
                placeholder = { Text("Placeholder") },
                onValueChange = { newValue ->
                    textFieldValue.value = newValue
                },
                maxLines = 2
            )

            StyleableTutorialText(
                text = "2-) Keyboard options change the type of TextField. For instance " +
                        "PasswordVisualTransformation" +
                        "transforms that TextField to password input area"
            )

            TutorialText2(text = "keyboardOptions")
            OutlinedTextField(
                modifier = fullWidthModifier,
                value = textFieldValue.value,
                label = { Text("KeyboardType.Password") },
                placeholder = { Text(text = "123456789") },
                onValueChange = { newValue ->
                    textFieldValue.value = newValue
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            val phoneNumberText = remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = phoneNumberText.value,
                label = { Text("KeyboardType.Phone") },
                placeholder = { Text(text = "555-555-5555") },
                onValueChange = { newValue ->
                    phoneNumberText.value = newValue
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            StyleableTutorialText(text = "3-) TextField can have leading and trailing icons.")
            TutorialText2(text = "Leading and Trailing Icons")

            val emailText = remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = emailText.value,
                onValueChange = {
                    emailText.value = it
                },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            var searchQuery by remember { mutableStateOf("") }

            Surface(
                modifier = fullWidthModifier,
                shape = RoundedCornerShape(percent = 40),
                border = BorderStroke(1.dp, Color(0xff90A4AE))
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                    },
                    label = { Text(text = "Search") },
                    leadingIcon = {
                        if (searchQuery.isEmpty()) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffF5F5F5),
                        unfocusedContainerColor = Color(0xffF5F5F5),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                    singleLine = true,
                )
            }

            val emailText2 = remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = emailText2.value,
                label = { Text("Email") },
                placeholder = { Text(text = "") },
                onValueChange = { newValue ->
                    emailText2.value = newValue
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null
                    )
                }
            )

            StyleableTutorialText(
                text = "4-) Changing IME action changes icon/text at bottom right, " +
                        "action to be performed when that button is clicked"
            )

            TutorialText2(text = "IME Icons and Actions")

            val searchText = remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = searchText.value,
                label = { Text("Search") },
                placeholder = { Text(text = "") },
                onValueChange = { newValue ->
                    searchText.value = newValue
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = true,
                    imeAction = ImeAction.Search
                )
            )

            val context = LocalContext.current

            val keyboardController = LocalSoftwareKeyboardController.current

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = searchText.value,
                onValueChange = { newValue ->
                    searchText.value = newValue
                },
                label = { Text("Search onImeActionPerformed") },
                placeholder = { Text(text = "") },

                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    imeAction = ImeAction.Go,
                ),
                keyboardActions = KeyboardActions(onGo = {
                    keyboardController?.hide()

                    Toast.makeText(context, "ImeAction performed onGo", Toast.LENGTH_SHORT).show()
                })

            )

            StyleableTutorialText(
                text = "5-) With **VisualTransformation** and Regex it's possible to " +
                        "transform text based on a format such as masked chars, phone " +
                        ", currency or credit card."
            )

            val maskText = remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = fullWidthModifier,
                value = maskText.value,
                label = { Text("Mask Chars") },
                placeholder = { Text(text = "") },
                onValueChange = { newValue ->
                    maskText.value = newValue
                },
                singleLine = true,
                visualTransformation = PasswordMaskTransformation()
            )


            val phoneText = remember { mutableStateOf(TextFieldValue("")) }
            val maxChar = 10

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = phoneText.value,
                label = { Text("Phone") },
                placeholder = { Text(text = "") },
                onValueChange = { newValue ->
                    if (newValue.text.length <= maxChar) phoneText.value = newValue
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                maxLines = 1,
                visualTransformation = PhoneVisualTransformation()
            )

            val creditCardText = remember { mutableStateOf(TextFieldValue("")) }
            val maxCharCreditCard = 16
            val numberRegex = "^[0-9]+\$".toRegex()

            OutlinedTextField(
                modifier = fullWidthModifier,
                value = creditCardText.value,
                label = { Text("Credit Card") },
                placeholder = { Text(text = "") },
                onValueChange = { newValue ->
                    val text = newValue.text
                    if (text.length <= maxCharCreditCard && numberRegex.matches(text)) {
                        creditCardText.value = newValue
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                visualTransformation = CreditCardVisualTransformation()
            )

            StyleableTutorialText(
                text = "6-) Basic composable that enables users to edit text via hardware " +
                        "or software keyboard, but provides no decorations like hint or placeholder."
            )

            Surface(
                modifier = fullWidthModifier.padding(8.dp),
                shape = MaterialTheme.shapes.small,
                color = Color(0xff90A4AE)
            ) {
                var basicText by remember { mutableStateOf("BasicTextField") }

                BasicTextField(value = basicText, onValueChange = {
                    basicText = it
                }, modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.padding(bottom = 32.dp))


        }
    }

}

class PasswordMaskTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString(text.text.replace(".".toRegex(), "!")), maskOffsetMap
        )
    }

    private val maskOffsetMap = object : OffsetMapping {
        override fun originalToTransformed(offset: Int) = offset
        override fun transformedToOriginal(offset: Int) = offset
    }
}

class PhoneVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 10) text.text.substring(0..9) else text.text

        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            if (i % 3 == 2 && i != 8) output += "-"
        }

        println("PhoneVisualTransformation text: $text, trimmed: $trimmed, output: $output")


        return TransformedText(AnnotatedString(output), phoneOffsetMap)
    }

    private val phoneOffsetMap = object : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int {

            if (offset <= 2) return offset
            if (offset <= 5) return offset + 1
            if (offset <= 9) return offset + 2

            return 12
        }

        override fun transformedToOriginal(offset: Int): Int {

            println("transformedToOriginal() offset: $offset")
            if (offset <= 2) return offset
            if (offset <= 6) return offset - 1
            if (offset <= 11) return offset - 2
            return 10
        }

    }
}

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return creditCardFilter(text)
    }
}

fun creditCardFilter(text: AnnotatedString): TransformedText {

    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i < 15) out += "-"
    }

    /**
     * The offset translator should ignore the hyphen characters, so conversion from
     *  original offset to transformed text works like
     *  - The 4th char of the original text is 5th char in the transformed text.
     *  - The 13th char of the original text is 15th char in the transformed text.
     *  Similarly, the reverse conversion works like
     *  - The 5th char of the transformed text is 4th char in the original text.
     *  - The 12th char of the transformed text is 10th char in the original text.
     */
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 7) return offset + 1
            if (offset <= 11) return offset + 2
            if (offset <= 16) return offset + 3
            return 19
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 9) return offset - 1
            if (offset <= 14) return offset - 2
            if (offset <= 19) return offset - 3
            return 16
        }
    }

    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}


@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun Tutorial2_3Preview() {
    TutorialContent()
}
