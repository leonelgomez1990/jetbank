package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.viewmodels.PassRecoveryViewModel

@Composable
fun PassRecoveryScreen(PassRecoveryViewModel: PassRecoveryViewModel) {

    DefaultScreen {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
        }
    }
}