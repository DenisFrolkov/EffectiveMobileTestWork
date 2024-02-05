package com.example.effectivemobiletestwork.DataClass

import androidx.compose.ui.graphics.painter.Painter
import com.example.effectivemobiletestwork.R

data class Image(val id: String)

val itemImageMap = mapOf(
    "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to listOf(R.drawable.image_6, R.drawable.image_5),
    "54a876a5-2205-48ba-9498-cfecff4baa6e" to listOf(R.drawable.image_1, R.drawable.image_2),
    "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to listOf(R.drawable.image_5, R.drawable.image_6),
    "16f88865-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.image_3, R.drawable.image_4),
    "26f88856-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.image_2, R.drawable.image_3),
    "15f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.image_6, R.drawable.image_1),
    "88f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.image_4, R.drawable.image_3),
    "55f58865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.image_1, R.drawable.image_5)
)

fun getImagesForItem(item: Item): List<Int> {
    return itemImageMap[item.id] ?: emptyList()
}