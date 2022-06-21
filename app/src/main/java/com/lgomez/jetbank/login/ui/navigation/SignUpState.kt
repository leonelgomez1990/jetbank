package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.login.ui.navigatorstates.SignUpNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SignUpScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignUpViewModel

@Composable
fun SignUpState(navController: NavController) {
    val viewModel = hiltViewModel<SignUpViewModel>()
    val navigator by viewModel.navigation.collectAsState()

    SignUpScreen(viewModel)
    LaunchedEffect(navigator) {
        when (navigator) {
            SignUpNavigatorStates.GoBack -> {
                navController.navigateUp()
            }
            SignUpNavigatorStates.ToSignIn -> {
                navController.navigate(route = NavSections.USERNAME.route)
            }
            else -> {}
        }
    }
}