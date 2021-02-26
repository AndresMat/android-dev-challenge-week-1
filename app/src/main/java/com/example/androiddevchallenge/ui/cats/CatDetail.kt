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

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catDataSource
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CatDetailsContent(catId: Int) {
    catDataSource.find { it.id == catId }?.let {
        CatDetails(it)
    }
}

@Composable
fun CatDetails(cat: Cat) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(cat.name)
            })
        },
        content = {

            val context = LocalContext.current

            Column {
                CatImage(
                    cat = cat,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .background(cat.background)
                )
                CatInfo(cat = cat)

                Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(24.dp), onClick = {
                        Toast.makeText(context, R.string.thanks_adopt_me, Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = stringResource(id = R.string.adopt_me))
                    }
                }
            }
        }
    )
}

//region Previewers
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        CatDetails(catDataSource[0])
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        CatDetails(catDataSource[0])
    }
}
//endregion
