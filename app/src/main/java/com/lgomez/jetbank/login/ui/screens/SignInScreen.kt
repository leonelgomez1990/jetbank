package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.views.*

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SignInPreview() {
    SignInScreen("", "", {}, {}, {})
}

@Composable
fun SignInScreen(
    user: String,
    pass: String,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    DefaultScreen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            val loginEnabled = user.isNotEmpty() && pass.isNotEmpty()

            UserTextField(
                value = user,
                onValueChange = onUserNameChange
            )
            PasswordTextField(
                value = pass,
                onValueChange = onPasswordChange,
                modifier = Modifier.padding(16.dp)
            )
            LoginButton(loginEnabled, onLogin = onLoginClick)
        }
    }
}