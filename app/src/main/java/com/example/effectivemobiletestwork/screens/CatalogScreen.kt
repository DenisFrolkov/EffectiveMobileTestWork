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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.common.FilterButton
import com.example.effectivemobiletestwork.common.ProductCard
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun CatalogScreen(navController: NavController) {

    val sfprodisplay_regular = FontFamily(Font(R.font.sfprodisplay_regular, FontWeight.Normal))

    val sfprodisplay_medium = FontFamily(Font(R.font.sfprodisplay_medium, FontWeight.Normal))

    val stringResource = LocalContext.current.resources

    var expanded by remember { mutableStateOf(false) }

    var selectedIndex by remember { mutableStateOf(0) }

    var selectedFilter by remember { mutableStateOf("") }

    val sortingOptions = listOf(
        stringResource.getString(R.string.popularity_sorting),
        stringResource.getString(R.string.on_price_reduction_sorting),
        stringResource.getString(R.string.in_ascending_order_of_price_sorting)
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
                text = stringResource.getString(R.string.header_catalog_screen),
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
                .padding(horizontal = 16.dp)
                .padding(top = 22.dp),
        ) {
            Row(
                modifier = Modifier
                    .height(height = 24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        expanded = !expanded
                    },
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.selected_icon),
                    contentDescription = null
                )
                Text(
                    text = sortingOptions[selectedIndex],
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_regular
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.revealing_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .size(width = 8.dp, height = 14.dp)
                        .align(Alignment.CenterVertically)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    sortingOptions.forEachIndexed { index, option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        fontFamily = sfprodisplay_medium
                                    ),
                                )
                            },
                            onClick = {
                                selectedIndex = index
                                expanded = false
                            })
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
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
                    text = stringResource.getString(R.string.filtering),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = sfprodisplay_regular
                    )
                )
            }
        }
        LazyRow(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    FilterButton(
                        textButton = stringResource.getString(R.string.see_all),
                        isSelected = selectedFilter == stringResource.getString(R.string.see_all),
                        onFilterSelected = { selectedFilter = it }
                    )
                }
                FilterButton(
                    textButton = stringResource.getString(R.string.face),
                    isSelected = selectedFilter == stringResource.getString(R.string.face),
                    onFilterSelected = { selectedFilter = it }
                )
                FilterButton(
                    textButton = stringResource.getString(R.string.body),
                    isSelected = selectedFilter == stringResource.getString(R.string.body),
                    onFilterSelected = { selectedFilter = it }
                )
                FilterButton(
                    textButton = stringResource.getString(R.string.sunburn),
                    isSelected = selectedFilter == stringResource.getString(R.string.sunburn),
                    onFilterSelected = { selectedFilter = it }
                )
                FilterButton(
                    textButton = stringResource.getString(R.string.mask),
                    isSelected = selectedFilter == stringResource.getString(R.string.mask),
                    onFilterSelected = { selectedFilter = it }
                )
                Box(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    FilterButton(
                        textButton = stringResource.getString(R.string.mask),
                        isSelected = selectedFilter == stringResource.getString(R.string.mask),
                        onFilterSelected = { selectedFilter = it }
                    )
                }
            }
        }
        LazyColumn() {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                ) {
                    repeat(3) {
                        RepeatProductCardRow(count = 2, navController = navController)
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun RepeatProductCardRow(
    count: Int,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(count) {
            ProductCard(navController = navController)
        }
    }
}