package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.views.ShowProgressIndicator
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.core.utils.showMessage
import com.lgomez.jetbank.login.ui.navigatorstates.SignInNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SignInScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel

@Composable
fun SignInState(navController: NavController) {
    val viewModel = hiltViewModel<SignInViewModel>()
    val navigator by viewModel.navigation.collectAsState()
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))

    //var user by rememberSaveable { mutableStateOf("") }
    //var pass by rememberSaveable { mutableStateOf("") }
    val user by viewModel.userName.observeAsState("")
    val pass by viewModel.userPassword.observeAsState("")

    SignInScreen(
        user = user,
        pass = pass,
        onUserNameChange = { viewModel.onUserNameChange(it) },
        onPasswordChange = { viewModel.onUserPasswordChange(it) },
        onLoginClick = { viewModel.doUserLogin(user, pass) }
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
            }
            SignInNavigatorStates.ToPassRecovery -> {
                navController.navigate(route = NavSections.PASSWORD.route)
            }
            SignInNavigatorStates.ToSignUp -> {
                navController.navigate(route = NavSections.REGISTER.route)
            }
            else -> {}
        }
    }
}