package com.lgomez.jetbank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.login.ui.screens.LoginForm
import com.lgomez.jetbank.login.ui.viewmodels.SignInViewModel
import com.lgomez.jetbank.main.ui.screens.Main

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.LOGIN.route
    ) {

        composable(NavSections.LOGIN.route) {
            LoginForm(navController)
        }
        composable(NavSections.MAIN.route) {
            Main(navController)
        }
    }
}

enum class NavSections(
    val route: String
) {
    LOGIN("login"),
    MAIN("main")
}