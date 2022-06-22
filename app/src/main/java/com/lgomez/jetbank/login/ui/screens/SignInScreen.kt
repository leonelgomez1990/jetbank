package com.lgomez.jetbank.login.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.widgets.*

@Preview(
    showBackground = true,
    widthDp = 320,
    name = "LightPreview"
)
@Composable
fun SignInLightPreview() {
    SignInScreen("", "", {}, {}, {}, {})
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkPreview"
)
@Composable
fun SignInDarkPreview() {
    SignInScreen("", "", {}, {}, {}, {})
}

@Composable
fun SignInScreen(
    user: String,
    pass: String,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
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
            Spacer(modifier = Modifier.padding(10.dp))
            Box(
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(10.dp)
                    .clickable(onClick = onRegisterClick)
            ) {
                Text(
                    text = "¿No tenés una cuenta? Registrate",
                    color = Color.White,

                    )
            }
        }
    }
}