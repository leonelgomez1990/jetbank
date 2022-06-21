package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel
import com.lgomez.jetbank.login.ui.views.*

@Composable
fun SignInScreen(signInViewModel: SignInViewModel) {
    //var user by rememberSaveable { mutableStateOf("") }
    //var pass by rememberSaveable { mutableStateOf("") }
    val user by signInViewModel.userName.observeAsState("")
    val pass by signInViewModel.userPassword.observeAsState("")

    DefaultScreen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            val loginEnabled = user.isNotEmpty() && pass.isNotEmpty()

            UserTextField(value = user, onValueChange = { signInViewModel.onUserNameChange(it) })
            PasswordTextField(value = pass, onValueChange = { signInViewModel.onUserPasswordChange(it) })
            LoginButton(loginEnabled) {
                signInViewModel.doUserLogin(user, pass)
            }
        }
    }
}