package com.lgomez.jetbank.menu.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lgomez.jetbank.menu.ui.models.NewUI

@Composable
fun CardNewItem(item: NewUI, onClick: (NewUI) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(item) },
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                model = item.urlToImage,
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )
            Column(Modifier.padding(8.dp)) {
                Text(item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(item.content, maxLines = 3)
            }
        }
    }

}