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
package com.example.androiddevchallenge.ui.cats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catDataSource

@Composable
fun CatListContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(stringResource(id = R.string.adopt_a_cat))
            })
        },
        content = {
            CatList(
                cats = catDataSource,
                Modifier.fillMaxWidth()
            ) {
                navController.navigate("detail/$it")
            }
        }
    )
}

@Composable
fun CatList(cats: List<Cat>, modifier: Modifier = Modifier, onClickListener: (catId: Int) -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = cats) { cat ->
            CatCard(cat, onClickListener)
        }
    }
}

@Composable
fun CatCard(cat: Cat, onClickListener: (catId: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickListener(cat.id) },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .size(150.dp)
        ) {
            CatImage(
                cat = cat,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .background(cat.background)
            )
            CatInfo(cat = cat)
        }
    }
}
