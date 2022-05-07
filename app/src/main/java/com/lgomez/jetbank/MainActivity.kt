package com.lgomez.jetbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.ui.theme.JetbankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginForm(onLogin = {
                        navController.navigate("main")
                    })
                }
                composable("main") {
                    Main()
                }
            }

        }
    }

}

@Composable
fun Main() {
    Screen {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Main Screen",
                style = MaterialTheme.typography.h5
            )
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

@Composable
private fun LoginForm(onLogin: () -> Unit) {
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
            LoginButton(buttonEnabled, onLogin)
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
    var passVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Password") },
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
