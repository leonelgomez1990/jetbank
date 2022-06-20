package com.lgomez.jetbank.core.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.lgomez.jetbank.core.ui.theme.ProgressGray

@Composable
fun ShowProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ProgressGray)
            .pointerInput(Unit) { }
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}