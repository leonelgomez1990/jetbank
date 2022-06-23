package com.lgomez.jetbank.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.menu.ui.models.NewUI
import com.lgomez.jetbank.menu.ui.widgets.*

val data = listOf(
    NewUI(
        uid = "0",
        title = "título",
        content = "descripción",
        urlToImage = "https://picsum.photos/200/300"
    )
)

@Preview(
    showBackground = true,
    widthDp = 320,
    name = "LightPreview"
)
@Composable
fun LightPreview() {
    ListNewsScreen(
        data, {}, TextFieldValue(""), {}, {}, {}, {}
    )
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkPreview"
)
@Composable
fun DarkPreview() {
    ListNewsScreen(
        data, {}, TextFieldValue(""), {}, {}, {}, {}
    )
}

@Composable
fun ListNewsScreen(
    news: List<NewUI>,
    onRefreshClick: () -> Unit,
    stateValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onCloseClick: () -> Unit,
    onAddClick: () -> Unit,
    onDetailClick: (NewUI) -> Unit
) {
    DefaultScreen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Últimas noticias") },
                    actions = {
                        IconButton(onClick = onRefreshClick) {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Actualizar"
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = onAddClick) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Crear")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true
        ) {
            Column(
                Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxSize()
            ) {
                SearchViewTextField(
                    stateValue = stateValue,
                    onValueChange = onValueChange,
                    onCloseClick = onCloseClick
                )
                Spacer(modifier = Modifier.padding(8.dp))
                LazyColumn {
                    items(news) { new ->
                        key(new.uid) {
                            CardNewItem(item = new, onClick = onDetailClick)
                        }
                        Divider()
                    }
                }
            }
        }
    }
}