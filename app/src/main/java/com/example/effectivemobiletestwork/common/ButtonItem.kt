package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.ui.theme.Pink

@Composable
fun EnterButton(
    navController: NavController,
    navigationRoute: String,
    textButton: String,
    colorButton: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorButton, shape = RoundedCornerShape(8.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate(navigationRoute)
            }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 15.dp),
            text = textButton,
            style = TextStyle(
                fontSize = 14.sp,
                color = if (colorButton == Pink) Color.White else Color.Black
            ),
            textAlign = TextAlign.Center
        )
    }
}