package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.Pink
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Preview
@Composable
fun ProductCard() {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    val clickHeart by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Image(clickHeart = clickHeart)
        Information(sfprodisplay_regular)
    }
}

@Composable
fun Image(
    clickHeart: Boolean
) {
    Box(
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_image),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .padding(all = 9.dp)
                .size(18.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    clickHeart == !clickHeart
                }
        ) {
            if (clickHeart) {
                Icon(
                    painter = painterResource(id = R.drawable.selected_heart),
                    contentDescription = null,
                    tint = Pink

                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = null,
                    tint = Pink
                )
            }
        }
    }
}

@Composable
fun Information(
    sfprodisplay_regular: FontFamily
) {
    Text(
        modifier = Modifier.padding(start = 7.dp),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                append("749 ₽")
            }
        },
        style = TextStyle(
            fontSize = 9.sp,
            color = SoftGray,
            fontFamily = sfprodisplay_regular
        )
    )
}
