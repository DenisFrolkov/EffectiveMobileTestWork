package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.DarkGray
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Composable
fun FilterButton(
    textButton: String,
    isSelected: Boolean,
    onFilterSelected: (String) -> Unit
) {
    val sfProDisplayRegular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )

    Row(
        modifier = Modifier
            .padding(end = 6.dp)
            .background(
                color = if (isSelected) DarkGray else Gray,
                shape = RoundedCornerShape(size = 100.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onFilterSelected(textButton)
            }
    ) {
        ButtonContent(
            textButton = textButton,
            isSelected = isSelected,
            sfProDisplayRegular = sfProDisplayRegular
        )
    }
}

@Composable
private fun ButtonContent(
    textButton: String,
    isSelected: Boolean,
    sfProDisplayRegular: FontFamily
) {
    Row(
        modifier = Modifier
            .padding(
                start = 12.dp,
                top = 8.dp,
                end = 12.dp,
                bottom = 8.dp,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = textButton,
            style = TextStyle(
                fontSize = 14.sp,
                color = if (isSelected) Color.White else SoftGray,
                fontFamily = sfProDisplayRegular
            )
        )

        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.undo_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(size = 8.dp),
                tint = Color.White
            )
        }
    }
}
