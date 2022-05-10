package com.lgomez.jetbank.ui.configuration

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lgomez.jetbank.ui.theme.JetbankTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    JetbankTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            content = content
        )
    }
}