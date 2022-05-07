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
            UserField()
            PasswordField()
            LoginButton()
        }
    }
}

@Composable
private fun UserField() {
    var user by remember { mutableStateOf("") }

    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "User") }
    )
}

@Composable
private fun PasswordField() {
    var pass by remember { mutableStateOf("")}
    OutlinedTextField(
        value = pass,
        onValueChange = { pass = it },
        label = { Text(text = "Password") }
    )
}

@Composable
private fun LoginButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Login")
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)

    }
}
