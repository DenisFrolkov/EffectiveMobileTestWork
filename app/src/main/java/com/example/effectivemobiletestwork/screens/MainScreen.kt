package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R

@Composable
fun MainScreen() {

    val sfprodisplay_regular = FontFamily(Font(R.font.sfprodisplay_regular, FontWeight.Normal))

    val stringResource = LocalContext.current.resources

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource.getString(R.string.header_main_screen),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = sfprodisplay_regular
            ),
            textAlign = TextAlign.Center
        )
    }
}