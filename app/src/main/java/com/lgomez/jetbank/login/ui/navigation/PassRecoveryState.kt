package com.lgomez.jetbank.login.ui.navigation


import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.login.ui.navigatorstates.PassRecoveryNavigatorStates
import com.lgomez.jetbank.login.ui.screens.PassRecoveryScreen
import com.lgomez.jetbank.login.ui.viewmodels.PassRecoveryViewModel

@Composable
fun PassRecoveryState(navController: NavController) {
    val viewModel = hiltViewModel<PassRecoveryViewModel>()
    val navigator by viewModel.navigation.collectAsState()

    PassRecoveryScreen(viewModel)
    LaunchedEffect(navigator) {
        when (navigator) {
            PassRecoveryNavigatorStates.GoBack -> {
                navController.navigateUp()
            }
            PassRecoveryNavigatorStates.ToSignIn -> {
                navController.navigate(route = NavSections.REGISTER.route)
            }
            else -> {}
        }
    }
}