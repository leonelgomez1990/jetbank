package com.lgomez.jetbank.login.ui.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.login.ui.navigatorstates.SplashNavigatorStates
import com.lgomez.jetbank.login.ui.screens.SplashScreen
import com.lgomez.jetbank.login.ui.viewmodels.SplashViewModel

@Composable
fun SplashState(navController: NavController) {
    val viewModel = hiltViewModel<SplashViewModel>()
    val navigator by viewModel.navigation.collectAsState()

    SplashScreen(viewModel)
    LaunchedEffect(navigator) {
        when (navigator) {
            SplashNavigatorStates.ToSignIn -> {
                navController.popBackStack()
                navController.navigate(route = NavSections.LOGIN_GRAPH.route)
            }
            else -> {}
        }
    }
}