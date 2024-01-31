package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.common.FilterButton
import com.example.effectivemobiletestwork.common.ProductCard

@Preview
@Composable
fun CatalogScreen() {

    val sfprodisplay_medium = FontFamily(
        Font(R.font.sfprodisplay_medium, FontWeight.Normal),
    )
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Каталог",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_regular
                ),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .height(height = 24.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.selected_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                    text = "По популярности",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_regular
                    )
                )
                Image(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .size(width = 4.dp, height = 7.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.revealing_icon),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
                    .height(height = 24.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.parameters_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp),
                    text = "Фильтр",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_regular
                    )
                )
            }
        }
        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                FilterButton(textButton = "Смотреть все")
                FilterButton(textButton = "Лицо")
                FilterButton(textButton = "Тело")
                FilterButton(textButton = "Загар")
                FilterButton(textButton = "Массаж")
                FilterButton(textButton = "Массаж")
            }
        }
        ProductCard()
    }
}