package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.views.ShowProgressIndicator
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.core.utils.showMessage
import com.lgomez.jetbank.login.ui.navigatorstates.SignUpNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SignUpScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignUpViewModel

@Composable
fun SignUpState(navController: NavController) {
    val viewModel = hiltViewModel<SignUpViewModel>()
    val navigator by viewModel.navigation.collectAsState()
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))

    SignUpScreen(viewModel)

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
    
    LaunchedEffect(navigator) {
        when (navigator) {
            SignUpNavigatorStates.GoBack -> {
                navController.navigateUp()
                viewModel.navigationReset()
            }
            SignUpNavigatorStates.ToSignIn -> {
                navController.navigate(route = NavSections.USERNAME.route)
                viewModel.navigationReset()
            }
            else -> {}
        }
    }
}