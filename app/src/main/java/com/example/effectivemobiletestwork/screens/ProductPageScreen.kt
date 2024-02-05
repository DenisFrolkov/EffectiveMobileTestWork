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
import androidx.navigation.NavController
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
@Composable
fun ProductPageScreen(
    navController: NavController
) {
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
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .height(height = 46.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding()
                        .align(Alignment.Top)
                        .padding(start = 21.dp, top = 14.dp, end = 14.dp, bottom = 8.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            navController.popBackStack()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.share_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding()
                        .align(Alignment.Top)
                        .padding(top = 14.dp, end = 14.dp, bottom = 8.dp)
                )
            }
            Box(
                modifier = Modifier.padding(start = 21.dp, top = 16.dp, end = 14.dp)
            ) {
                HorizontalPager(
                    state = pagerState,
                    count = pagerImageList.size,
                    modifier = Modifier.height(400.dp)
                ) { page ->
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = pagerImageList[page]),
                        contentDescription = null
                    )
                }
                Icon(
                    painter = painterResource(id = if (clickHeart) R.drawable.heart_icon else R.drawable.selected_heart),
                    contentDescription = null,
                    tint = Pink,
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.TopEnd)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            clickHeart = !clickHeart
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.question_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(18.dp)
                        .align(Alignment.BottomStart)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(width = 52.dp, height = 10.dp)
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
                text = "A`PIEU",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_medium
                ),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
            )
            Text(
                text = "Пенка для умывания`A`PIEU` `DEEP CLEAN` 200 мл",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 14.dp, bottom = 10.dp)
            )
            Text(
                text = quantityText,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            )
            Divider(
                color = Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null,
                    modifier = Modifier.size(height = 20.dp, width = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null,
                    modifier = Modifier.size(height = 20.dp, width = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null,
                    modifier = Modifier.size(height = 20.dp, width = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star_one_icon),
                    contentDescription = null,
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.star_two_icon),
                    contentDescription = null,
                    modifier = Modifier.size(height = 20.dp, width = 16.dp),
                )
                Text(
                    text = "4.3",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .size(2.dp)
                        .background(Color.Gray, CircleShape)
                )
                Text(
                    text = "4 отзыва ",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 21.dp, top = 16.dp),
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
                        text = "-39%",
                        style = TextStyle(
                            fontSize = 9.sp,
                            color = Color.White,
                            fontFamily = sfprodisplay_bold
                        ),
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }
            Text(
                text = "Описани",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, bottom = 16.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(color = Gray, shape = RoundedCornerShape(8.dp)),
            ) {
                Text(
                    text = "A`PIEU",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_medium
                    ),
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp, bottom = 15.dp)
                )
                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Dark,
                    fontFamily = sfprodisplay_regular,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Text(
                text = "Скрыть",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = "Характеристики",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_medium
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 34.dp, bottom = 16.dp),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
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
                    color = Gray,
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
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
                    color = Gray,
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
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
                    color = Gray,
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 34.dp),
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
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.copy_icon),
                        contentDescription = null
                    )
                }
            }
            ClickableText(
                text = ingredientsShort,
                onClick = {
                    expanded = !expanded
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 10.dp)
            )
            if (ingredients.length > 20) {
                Text(
                    text = if (expanded) "Скрыть" else "Подробнее",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable {
                            expanded = !expanded
                        }
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
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                                append("899 ₽")
                            }
                        },
                        style = TextStyle(
                            fontSize = 10.sp,
                            color = SoftGray,
                            fontFamily = sfprodisplay_regular
                        ),
                        modifier = Modifier.padding(horizontal = 11.dp)
                    )
                    Box(
                        contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.fillMaxWidth(),
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