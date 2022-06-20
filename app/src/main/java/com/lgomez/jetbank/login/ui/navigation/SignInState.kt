package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.login.ui.navigatorstates.SignInNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SignInScreen
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel

@Composable
fun SignInState(navController: NavController) {
    val viewModel = hiltViewModel<SignInViewModel>()
    val navigator by viewModel.navigation.collectAsState()

    SignInScreen(viewModel)
    LaunchedEffect(navigator) {
        when (navigator) {
            SignInNavigatorStates.ToMenuFeature -> {
                navController.popBackStack()
                navController.navigate(route = NavSections.MAIN.route)
            }
            SignInNavigatorStates.ToPassRecovery -> {}
            SignInNavigatorStates.ToSignUp -> {}
            else -> {}
        }
    }
}