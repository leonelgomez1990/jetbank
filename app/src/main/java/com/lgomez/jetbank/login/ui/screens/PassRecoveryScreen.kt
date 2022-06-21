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
import com.lgomez.jetbank.login.ui.viewmodels.PassRecoveryViewModel
import com.lgomez.jetbank.login.ui.views.*

@Composable
fun PassRecoveryScreen(viewModel: PassRecoveryViewModel) {
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))
    PassRecoveryForm(viewModel)
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
fun PassRecoveryForm(PassRecoveryViewModel: PassRecoveryViewModel) {

    DefaultScreen {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
        }
    }
}