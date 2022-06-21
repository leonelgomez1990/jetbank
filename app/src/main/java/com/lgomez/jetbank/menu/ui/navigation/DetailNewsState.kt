package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.compose.DefaultScreen

@Composable
fun DetailNewsState(navController: NavController, new: String) {
    DefaultScreen {
        Column(Modifier.padding(8.dp)) {
            Text("Detalle $new", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }

}