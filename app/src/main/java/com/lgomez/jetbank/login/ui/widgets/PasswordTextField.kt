package com.lgomez.jetbank.login.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.R

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    errorValue: String = "",
    onValueChange: (String) -> Unit,
) {
    var isError by rememberSaveable { mutableStateOf(false) }
    isError = errorValue != ""

    var passVisible by remember { mutableStateOf(false) }
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(id = R.string.log_in_password)) },
            leadingIcon = {
                Icon(Icons.Default.Password, "password")
            },
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
            },
            singleLine = true,
            isError = isError,
            modifier = modifier
        )
        if (isError) {
            Text(
                text = errorValue,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}