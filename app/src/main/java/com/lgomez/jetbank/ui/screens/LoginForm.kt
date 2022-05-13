package com.lgomez.jetbank.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.R
import com.lgomez.jetbank.ui.configuration.Screen

@Composable
fun LoginForm(onLogin: () -> Unit) {
    Screen {
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

@Composable
private fun UserTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.log_in_user)) }
    )
}

@Composable
private fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    var passVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.log_in_password)) },
        visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconToggleButton(
                checked = passVisible,
                onCheckedChange = { passVisible = it }
            ) {
                val icon =
                    if (passVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                Icon(imageVector = icon, contentDescription = null)

            }
        }
    )
}

@Composable
private fun LoginButton(enabled: Boolean, onLogin: () -> Unit) {
    Button(
        onClick = onLogin,
        enabled = enabled,
    ) {
        Text(text = "Login")
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
    }
}