package com.lgomez.jetbank.core.ui.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.lgomez.jetbank.core.ui.theme.*

@Composable
fun DefaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    lightColorPalette: Colors = LightColorPalette,
    darkColorPalette: Colors = DarkColorPalette,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
