/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.beige
import com.example.androiddevchallenge.ui.theme.gray

data class Cat(
    val id: Int,
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
        1, "Luna", "♀️", "1 year old", "Siberian cat", gray, R.drawable.cat_1
    ),
    Cat(
        2, "Milo", "♂️", "3 years old", "Tabby cat", beige, R.drawable.cat_2
    ),
    Cat(
        3, "Simba", "♂️", "2 years old", "Arabian cat", gray, R.drawable.cat_3
    ),
    Cat(
        4, "Lucy", "♀️", "5 years old", "British Shorthair", beige, R.drawable.cat_4
    ),
    Cat(
        5, "Lily", "♀️", "7 years old", "Persian cat", gray, R.drawable.cat_5
    )
)
//endregion