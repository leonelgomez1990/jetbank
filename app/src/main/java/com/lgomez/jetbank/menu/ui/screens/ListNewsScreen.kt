package com.lgomez.jetbank.menu.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.menu.domain.News

@Preview(showBackground = true, widthDp = 320)
@Composable
fun ListNewsPreview() {
    ListNewsScreen(
        listOf(
            News(
                title = "hola",
                urlToImage = "https://picsum.photos/200/300"
            )
        ), {}
    )
}

@Composable
fun ListNewsScreen(
    news: List<News>,
    onRefreshClick: () -> Unit,
) {
    DefaultScreen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Últimas noticias") },
                    actions = {
                        IconButton(onClick = onRefreshClick) {
                            Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Actualizar")
                        }
                    }
                )
            }
        ) {
            LazyColumn {
                items(news) { new ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clickable { },
                    ) {
                        Column {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(16f / 9f),
                                model = new.urlToImage,
                                contentScale = ContentScale.FillWidth,
                                contentDescription = null,
                            )
                            Column(Modifier.padding(8.dp)) {
                                Text(new.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text(new.content ?: "", maxLines = 3)
                            }
                        }

                    }
                }
            }
        }
    }
}