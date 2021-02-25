package com.example.androiddevchallenge.ui.cats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.theme.black
import com.example.androiddevchallenge.ui.theme.grayFont

@Composable
fun CatList(cats: List<Cat>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = cats) { cat ->
            CatCard(cat, modifier)
        }
    }
}

@Composable
fun CatCard(cat: Cat, modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = 8.dp) {
        Row(
            modifier = Modifier
                .size(150.dp)
        ) {
            Image(
                painter = painterResource(id = cat.image),
                contentDescription = cat.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .background(cat.background)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                Row {
                    Text(
                        text = cat.name,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = black,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = cat.gender,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = grayFont,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(top = 5.dp, end = 16.dp).fillMaxWidth()
                    )
                }
                Text(
                    text = cat.breed,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = grayFont,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = cat.age,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = grayFont
                )
            }
        }
    }
}
