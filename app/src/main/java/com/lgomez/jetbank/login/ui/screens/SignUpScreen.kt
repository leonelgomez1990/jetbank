package com.lgomez.jetbank.login.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.core.ui.views.ShowProgressIndicator
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.core.utils.showMessage
import com.lgomez.jetbank.login.ui.viewmodels.SignUpViewModel
import com.lgomez.jetbank.login.ui.views.*

@Composable
fun SignUpScreen(viewModel: SignUpViewModel) {
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))
    SignUpForm(viewModel)
    when (viewState) {
        is MyResult.Failure -> {
            showMessage(
                LocalContext.current,
                (viewState as MyResult.Failure).exception.localizedMessage ?: ""
            )
        }
        is MyResult.Loading -> {
            ShowProgressIndicator()
        }
        is MyResult.Success -> {
            if ((viewState as MyResult.Success<Boolean>).data) {
                viewModel.goBack()
            }
        }
    }
}

@Composable
fun SignUpForm(SignUpViewModel: SignUpViewModel) {

    DefaultScreen {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
        }
    }
}