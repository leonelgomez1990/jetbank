package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.widgets.ShowProgressIndicator
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.core.ui.showMessage
import com.lgomez.jetbank.login.ui.navigatorstates.SignInNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SignInScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel

@Composable
fun SignInState(navController: NavController) {
    val viewModel = hiltViewModel<SignInViewModel>()
    val navigator by viewModel.navigation.collectAsState()
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))

    val emailError by viewModel.emailError.observeAsState("")
    val passwordError by viewModel.passwordError.observeAsState("")

    SignInScreen(
        emailError = emailError,
        passwordError = passwordError,
        onUserNameChange = {
            viewModel.onEmailValidation(it)
        },
        onPasswordChange = {
            viewModel.onPasswordValidation(it)
        },
        onLoginClick = { (user, pass) -> viewModel.doUserLogin(user, pass) },
        onRegisterClick = { viewModel.goToSignUp() }
    )

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
                viewModel.goToMenuFeature()
            }
        }
    }

    LaunchedEffect(navigator) {
        when (navigator) {
            SignInNavigatorStates.ToMenuFeature -> {
                navController.popBackStack()
                navController.navigate(route = NavSections.MAIN.route)
                viewModel.navigationReset()
            }
            SignInNavigatorStates.ToPassRecovery -> {
                navController.navigate(route = NavSections.PASSWORD.route)
                viewModel.navigationReset()
            }
            SignInNavigatorStates.ToSignUp -> {
                navController.navigate(route = NavSections.REGISTER.route)
                viewModel.navigationReset()
            }
            else -> {}
        }
    }
}