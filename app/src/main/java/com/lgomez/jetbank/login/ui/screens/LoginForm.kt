package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.views.*

@Composable
fun LoginForm(onLogin: () -> Unit) {
    DefaultScreen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            var user by remember { mutableStateOf("") }
            var pass by remember { mutableStateOf("") }
            val loginEnabled = user.isNotEmpty() && pass.isNotEmpty()

            UserTextField(value = user, onValueChange = { user = it })
            PasswordTextField(value = pass, onValueChange = { pass = it })
            LoginButton(loginEnabled, onLogin)
        }
    }
}