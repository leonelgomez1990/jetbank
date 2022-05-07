package com.lgomez.jetbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.ui.theme.JetbankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginForm()
        }
    }

}

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

@Preview
@Composable
private fun LoginForm() {
    Screen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            var user by remember { mutableStateOf("") }
            var pass by remember { mutableStateOf("") }
            val buttonEnabled = user.isNotEmpty() && pass.isNotEmpty()

            UserField(value = user, onValueChange = { user = it })
            PasswordField(value = pass, onValueChange = { pass = it })
            LoginButton(buttonEnabled)
        }
    }
}

@Composable
private fun UserField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "User") }
    )
}

@Composable
private fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Password") }
    )
}

@Composable
private fun LoginButton(enabled: Boolean) {
    Button(
        onClick = { /*TODO*/ },
        enabled = enabled,
    ) {
        Text(text = "Login")
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
    }
}
