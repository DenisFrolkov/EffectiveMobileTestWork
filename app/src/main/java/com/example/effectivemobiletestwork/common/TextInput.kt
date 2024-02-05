package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Composable
fun TextInput(
    inputText: String,
    onTextChanged: (String) -> Unit,
    validation: (String) -> Boolean
) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    var isHintVisible by remember { mutableStateOf(text.text.isEmpty()) }
    var isError by remember { mutableStateOf(false) }

    if (text.text.isEmpty()) isError = false

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isError) Color.Red else Gray, shape = RoundedCornerShape(8.dp))
            .padding(start = 16.dp, top = 15.dp, end = 12.dp, bottom = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                isHintVisible = it.text.isEmpty()
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Dark
            ),
            singleLine = true,
            cursorBrush = SolidColor(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp)
                .align(Alignment.CenterStart)
        )

        if (isHintVisible) {
            Text(
                text = inputText,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = SoftGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
            )
        }
        if (text.text.isNotEmpty()) {
            Icon(
                painter = painterResource(id = R.drawable.clear_icon),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(20.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        text = TextFieldValue("")
                        isHintVisible = true
                        isError = false
                    }
            )
        }
    }

    LaunchedEffect(text.text) {
        isError = !validation(text.text)
        onTextChanged(text.text)
    }
}

