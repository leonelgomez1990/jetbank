package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel
import com.lgomez.jetbank.login.ui.views.*
import com.lgomez.jetbank.main.ui.navigation.NavSections

@Composable
fun LoginForm(navController: NavController) {
    val signInViewModel = hiltViewModel<SignInViewModel>()

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
            LoginButton(loginEnabled) {
                signInViewModel.signInUser(user, pass)
                if (signInViewModel.isSuccessfulLoggued())
                    navController.navigate(NavSections.MAIN.route)
            }
        }
    }
}