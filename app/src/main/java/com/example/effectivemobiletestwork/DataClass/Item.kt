package com.example.effectivemobiletestwork.DataClass

data class Item(
    val id: String,
    val available: Int,
    val description: String,
    val feedback: Feedback,
    val info: List<Info>,
    val ingredients: String,
    val price: Price,
    val subtitle: String,
    val tags: List<String>,
    val title: String
)