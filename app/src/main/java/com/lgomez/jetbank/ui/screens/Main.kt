package com.lgomez.jetbank.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.lgomez.jetbank.ui.configuration.Screen

@Composable
fun Main() {
    Screen {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Main Screen",
                style = MaterialTheme.typography.h5
            )
        }
    }
}
