package com.lgomez.jetbank.login.ui.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(enabled: Boolean, onLogin: () -> Unit) {
    Button(
        onClick = onLogin,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(180.dp)
    ) {
        Text(text = "Ingresar ")
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
    }
}