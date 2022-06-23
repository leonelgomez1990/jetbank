package com.lgomez.jetbank.login.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.R

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    value: String,
    errorValue: String = "",
    onValueChange: (String) -> Unit,
) {
    var isError by rememberSaveable { mutableStateOf(false) }
    isError = errorValue != ""

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(Icons.Default.Email, "email")
            },
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Error, "error", tint = MaterialTheme.colors.error)
            },
            label = { Text(text = stringResource(id = R.string.log_in_user)) },
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