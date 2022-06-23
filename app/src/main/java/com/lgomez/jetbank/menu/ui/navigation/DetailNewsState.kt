package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.menu.ui.models.NewUI
import com.lgomez.jetbank.menu.ui.viewmodels.ListNewsViewModel
import com.lgomez.jetbank.menu.ui.widgets.CardNewItem

@Composable
fun DetailNewsState(navController: NavController, new: String, viewModel: ListNewsViewModel) {
    val newData = viewModel.getNew(new) ?: NewUI()
    DefaultScreen {
        Column(Modifier.padding(8.dp)) {
            CardNewItem(item = newData, onClick = { })
        }
        //BottomSheet()
    }

}
