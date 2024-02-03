package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.Orange
import com.example.effectivemobiletestwork.ui.theme.Pink
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Preview
@Composable
fun ProductCard() {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    val sfprodisplay_bold = FontFamily(
        Font(R.font.sfprodisplay_bold, FontWeight.Normal),
    )
    val clickHeart by remember { mutableStateOf(false) }

    val pagerImageList = listOf(
        R.drawable.photo_icon,
        R.drawable.photo_icon,
        R.drawable.photo_image_3,
    )

    Column(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(width = 1.dp, color = Gray, RoundedCornerShape(8.dp))
    ) {
        HorizontalPagerImages(pagerImageList = pagerImageList)
        Information(sfprodisplay_regular, sfprodisplay_bold)
        Box(modifier = Modifier.align(Alignment.End)) {
            AddProductButton()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerImages(
    pagerImageList: List<Int>
) {

}


@Composable
fun Information(
    sfprodisplay_regular: FontFamily,
    sfprodisplay_bold: FontFamily
) {
    Column(
        modifier = Modifier
            .padding(start = 6.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("000 ₽")
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
                text = "000 ₽",
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
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 3.dp),
                    text = "-00%",
                    style = TextStyle(
                        fontSize = 9.sp,
                        color = Color.White,
                        fontFamily = sfprodisplay_bold
                    )
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = "Title",
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = sfprodisplay_bold
            )
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = "text",
            style = TextStyle(
                fontSize = 10.sp,
                color = Dark,
                fontFamily = sfprodisplay_regular
            )
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                modifier = Modifier
                    .size(size = 13.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp, top = 3.dp, bottom = 3.dp)
                    .align(Alignment.CenterVertically),
                text = "0.0",
                style = TextStyle(
                    fontSize = 9.sp,
                    color = Orange,
                    fontFamily = sfprodisplay_regular
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .align(Alignment.CenterVertically),
                text = "(0)",
                style = TextStyle(
                    fontSize = 9.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                )
            )
        }
    }
}

@Composable
fun AddProductButton() {
    Box(
        modifier = Modifier
            .background(
                color = Pink,
                shape = RoundedCornerShape(
                    bottomStart = 0.dp,
                    topStart = 8.dp,
                    topEnd = 0.dp,
                    bottomEnd = 8.dp
                )
            ),
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(
            modifier = Modifier.padding(all = 8.dp)
        )
        {
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

