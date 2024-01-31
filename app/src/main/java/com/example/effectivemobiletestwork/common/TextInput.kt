package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletestwork.ui.theme.Gray

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextInput(
    inputText: String
) {
    var text by remember { mutableStateOf(TextFieldValue(inputText)) }

    Box(
        modifier = Modifier.fillMaxWidth().background(color = Gray)
    ) {
        BasicTextField(
            modifier = Modifier.padding(start = 16.dp, top = 15.dp, end = 12.dp, bottom = 16.dp),
            value = text,
            onValueChange = { newText -> text = newText },
        )
    }
}