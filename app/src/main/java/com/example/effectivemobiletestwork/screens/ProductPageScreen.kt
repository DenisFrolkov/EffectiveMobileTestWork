package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.LightGray
import com.example.effectivemobiletestwork.ui.theme.Pink
import com.example.effectivemobiletestwork.ui.theme.SoftGray
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Preview
@Composable
fun ProductPageScreen() {
    val sfprodisplay_medium = FontFamily(
        Font(R.font.sfprodisplay_medium, FontWeight.Normal),
    )

    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    val sfprodisplay_bold = FontFamily(
        Font(R.font.sfprodisplay_bold, FontWeight.Normal),
    )

    val pagerImageList = listOf(
        R.drawable.photo_tovara,
        R.drawable.photo_tovara,
        R.drawable.photo_tovara,
        R.drawable.photo_tovara
    )

    val pagerState = rememberPagerState()

    var clickHeart by remember { mutableStateOf(false) }

    val description =
        "Пенка для лица Глубокое очищение содержит минеральную воду и соду, способствует глубокому очищению пор от различных загрязнений, контролирует работу сальных желез, сужает поры. Обладает мягким антисептическим действием, не пересушивая кожу. Минеральная вода тонизирует и смягчает кожу."
    val ingredients =
        "Water, Propylene Glycol, Dipropylene Glycol, Lauric acid, Myristic Acid, Potassium Hydroxide, Lauryl Hydroxysultaine, Potassium Cocoate, Potassium Cocoyl Glycinate, Sodium Chloride, Glycerin, Phenoxyethanol, Chlorphenesin, Fragrance, Caprylyl Glycol, Ethylhexylglycerin, Capric acid, Palmitic Acid, Disodium EDTA, Sodium Bicarbonate, Cocamidopropyl Betaine, Butylene Glycol."

    var expanded by remember { mutableStateOf(false) }

    val ingredientsShort = buildAnnotatedString {
        val shortText = if (expanded) ingredients else ingredients.take(135) + "..."
        withStyle(style = SpanStyle(fontSize = 12.sp, color = Dark)) {
            append(shortText)
        }
    }

    val quantity = 30

    val quantityText = remember(quantity) {
        when {
            quantity % 10 == 1 && quantity % 100 != 11 -> "$quantity штука"
            quantity % 10 in 2..4 && quantity % 100 !in 12..14 -> "$quantity штуки"
            else -> "$quantity штук"
        }
    }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .height(height = 46.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier
                        .padding()
                        .align(Alignment.Top)
                        .padding(start = 21.dp, top = 14.dp, end = 14.dp, bottom = 8.dp),
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = null
                )
                Icon(
                    modifier = Modifier
                        .padding()
                        .align(Alignment.Top)
                        .padding(top = 14.dp, end = 14.dp, bottom = 8.dp),
                    painter = painterResource(id = R.drawable.share_icon),
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier.padding(start = 21.dp, top = 16.dp, end = 14.dp)
            ) {
                HorizontalPager(
                    modifier = Modifier.height(400.dp),
                    state = pagerState,
                    count = pagerImageList.size,
                ) { page ->
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = pagerImageList[page]),
                        contentDescription = null
                    )
                }
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.TopEnd)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            clickHeart = !clickHeart
                        },
                    painter = painterResource(id = if (clickHeart) R.drawable.heart_icon else R.drawable.selected_heart),
                    contentDescription = null,
                    tint = Pink
                )
                Image(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(18.dp)
                        .align(Alignment.BottomStart),
                    painter = painterResource(id = R.drawable.question_icon),
                    contentDescription = null,
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(width = 52.dp, height = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    repeat(pagerImageList.size) { iteration ->
                        val color = if (pagerState.currentPage == iteration) Pink else LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .align(Alignment.CenterVertically)
                                .background(color = color, CircleShape)
                                .size(6.dp)
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
                text = "A`PIEU",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_medium
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 14.dp, bottom = 10.dp),
                text = "Пенка для умывания`A`PIEU` `DEEP CLEAN` 200 мл",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium,
                    textAlign = TextAlign.Justify
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                text = quantityText,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                )
            )
            Divider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                color = Gray,
                thickness = 1.dp,
            )
            Row(
                modifier = Modifier.padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                    painter = painterResource(id = R.drawable.star_two_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "4.3",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    )
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .size(2.dp)
                        .background(Color.Gray, CircleShape)
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "4 отзыва ",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    )
                )
            }
            Row(
                modifier = Modifier.padding(start = 21.dp, top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "549 ₽",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_bold
                    )
                )
                Text(
                    modifier = Modifier.padding(horizontal = 11.dp),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                            append("899 ₽")
                        }
                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    )
                )
                Box(
                    modifier = Modifier
                        .background(color = Pink, shape = RoundedCornerShape(size = 4.dp))
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 3.dp),
                        text = "-39%",
                        style = TextStyle(
                            fontSize = 9.sp,
                            color = Color.White,
                            fontFamily = sfprodisplay_bold
                        )
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, bottom = 16.dp),
                text = "Описани",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(color = Gray, shape = RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp, bottom = 15.dp),
                    text = "A`PIEU",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_medium
                    )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = null
                    )
                }
            }
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = description,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Dark,
                    fontFamily = sfprodisplay_regular,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Скрыть",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 34.dp, bottom = 16.dp),
                text = "Характеристики",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Артикул товара",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                    Text(
                        text = "133987",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                }
                Divider(
                    modifier = Modifier.padding(top = 4.dp, bottom = 12.dp),
                    color = Gray,
                    thickness = 2.dp,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Область использования ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                    Text(
                        text = "Лицо",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                }
                Divider(
                    modifier = Modifier.padding(top = 4.dp, bottom = 12.dp),
                    color = Gray,
                    thickness = 2.dp,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Страна производства ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                    Text(
                        text = "Республика Корея",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Dark,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                }
                Divider(
                    modifier = Modifier.padding(top = 4.dp),
                    color = Gray,
                    thickness = 2.dp,
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 34.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Состав",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_medium
                    )
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.copy_icon),
                        contentDescription = null
                    )
                }
            }
            ClickableText(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 10.dp),
                text = ingredientsShort,
                onClick = {
                    expanded = !expanded
                }
            )
            if (ingredients.length > 20) {
                Text(
                    text = if (expanded) "Скрыть" else "Подробнее",
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
                    .background(color = Pink, shape = RoundedCornerShape(8.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {

                    }
            ) {
                Row(
                    modifier = Modifier.padding(all = 16.dp)
                ) {
                    Text(
                        text = "809₽",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.White,
                            fontFamily = sfprodisplay_medium
                        )
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 11.dp),
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                                append("899 ₽")
                            }
                        },
                        style = TextStyle(
                            fontSize = 10.sp,
                            color = SoftGray,
                            fontFamily = sfprodisplay_regular
                        )
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "Добавить корзину",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontFamily = sfprodisplay_medium
                            )
                        )
                    }
                }
            }
        }
    }
}