package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import com.google.accompanist.pager.rememberPagerState
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
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.DataClass.Item
import com.example.effectivemobiletestwork.DataClass.getImagesForItem
import com.example.effectivemobiletestwork.DataClass.itemImageMap
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.navigation.NavigationRoute
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.LightGray
import com.example.effectivemobiletestwork.ui.theme.Orange
import com.example.effectivemobiletestwork.ui.theme.Pink
import com.example.effectivemobiletestwork.ui.theme.SoftGray
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun ProductCard(
    navController: NavController,
    item: Item
) {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    val sfprodisplay_bold = FontFamily(
        Font(R.font.sfprodisplay_bold, FontWeight.Normal),
    )

    var isHeartSelected by remember { mutableStateOf(false) }

    val imagesForItem = getImagesForItem(item)

    Column(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(width = 1.dp, color = Gray, RoundedCornerShape(8.dp))
    ) {
        HorizontalPagerImages(
            navController = navController,
            isHeartSelected = isHeartSelected,
            item = item,
            imagesForItem = imagesForItem
        )
        Information(
            navController = navController,
            sfprodisplay_regular,
            sfprodisplay_bold,
            item = item
        )
        Box(modifier = Modifier.align(Alignment.End)) {
            AddProductButton()
        }
    }
}


@ExperimentalPagerApi
@Composable
fun HorizontalPagerImages(
    navController: NavController,
    isHeartSelected: Boolean,
    item: Item,
    imagesForItem: List<Int>
) {
    val pagerState = rememberPagerState()


    Box() {
        HorizontalPager(
            state = pagerState,
            count = imagesForItem.size,
            modifier = Modifier
                .width(168.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    navController.navigate("${NavigationRoute.ProductPageScreen.route}/${item.id}")

                }

        ) { page ->
            Image(
                painter = painterResource(id = imagesForItem[page]),
                contentDescription = null
            )
        }
        Icon(
            painter = painterResource(id = if (isHeartSelected) R.drawable.selected_heart else R.drawable.heart_icon),
            contentDescription = null,
            tint = Pink,
            modifier = Modifier
                .padding(all = 9.dp)
                .size(18.dp)
                .align(Alignment.TopEnd)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    !isHeartSelected
                },
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 2.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    navController.navigate(NavigationRoute.ProductPageScreen.route)
                },
        ) {
            repeat(imagesForItem.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) Pink else LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .background(color = color, CircleShape)
                        .size(4.dp)
                )
            }
        }
    }
}

@Composable
fun Information(
    navController: NavController,
    sfprodisplay_regular: FontFamily,
    sfprodisplay_bold: FontFamily,
    item: Item
) {
    Column(
        modifier = Modifier
            .padding(start = 6.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate("${NavigationRoute.ProductPageScreen.route}/${item.id}")
            }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append(item.price.price)
                }
            },
            style = TextStyle(
                fontSize = 9.sp,
                color = SoftGray,
                fontFamily = sfprodisplay_regular
            )
        )
        Row(
            modifier = Modifier.padding(top = 2.dp)
        ) {
            Text(
                text = item.price.priceWithDiscount,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_bold
                )
            )
            Box(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .background(color = Pink, shape = RoundedCornerShape(size = 4.dp))
            ) {
                Text(
                    text = "-${item.price.discount}%",
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
            text = item.title,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = sfprodisplay_bold
            ),
            modifier = Modifier.padding(top = 2.dp)
        )
        Text(
            text = item.subtitle,
            style = TextStyle(
                fontSize = 10.sp,
                color = Dark,
                fontFamily = sfprodisplay_regular
            ),
            modifier = Modifier
                .padding(top = 2.dp)
                .width(154.dp)
                .height(37.dp)
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 13.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = item.feedback.rating.toString(),
                style = TextStyle(
                    fontSize = 9.sp,
                    color = Orange,
                    fontFamily = sfprodisplay_regular
                ),
                modifier = Modifier
                    .padding(start = 2.dp, top = 3.dp, bottom = 3.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "(" + item.feedback.count.toString() + ")",
                style = TextStyle(
                    fontSize = 9.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                ),
                modifier = Modifier
                    .padding(start = 2.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun AddProductButton() {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .background(
                color = Pink,
                shape = RoundedCornerShape(
                    bottomStart = 0.dp,
                    topStart = 8.dp,
                    topEnd = 0.dp,
                    bottomEnd = 8.dp
                )
            )
    ) {
        Box(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(size = 24.dp),
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}