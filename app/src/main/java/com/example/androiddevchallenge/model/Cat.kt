package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.beige
import com.example.androiddevchallenge.ui.theme.gray

data class Cat(
    val name: String,
    val gender: String,
    val age: String,
    val breed: String,
    val background: Color,
    val image: Int
)

//region Cats mock datasource
val catDataSource = listOf(
    Cat(
        "Luna", "♀️", "1 year old", "Siberian cat", gray, R.drawable.cat_1
    ),
    Cat(
        "Milo", "♂️", "3 year old", "Tabby cat", beige, R.drawable.cat_2
    ),
    Cat(
        "Simba", "♂️", "2 year old", "Arabian cat", gray, R.drawable.cat_3
    ),
    Cat(
        "Lucy", "♀️", "5 year old", "British Shorthair", beige, R.drawable.cat_4
    ),
    Cat(
        "Lily", "♀️", "7 year old", "Persian cat", gray, R.drawable.cat_5
    )
)
//endregion