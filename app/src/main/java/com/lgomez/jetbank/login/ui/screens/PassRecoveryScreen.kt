package com.lgomez.jetbank.login.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lgomez.jetbank.core.ui.compose.DefaultScreen

@Preview(
    showBackground = true,
    widthDp = 320,
    name = "LightPreview"
)
@Composable
fun PassRecoveryLightPreview() {
    PassRecoveryScreen()
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkPreview"
)
@Composable
fun PassRecoveryDarkPreview() {
    PassRecoveryScreen()
}

@Composable
fun PassRecoveryScreen() {

    DefaultScreen {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
        }
    }
}