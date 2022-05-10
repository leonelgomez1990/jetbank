package com.lgomez.jetbank.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.ui.screens.LoginForm
import com.lgomez.jetbank.ui.screens.Main

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.LOGIN.route
    ) {
        composable(NavSections.LOGIN.route) {
            LoginForm(onLogin = {
                navController.navigate(NavSections.MAIN.route)
            })
        }
        composable(NavSections.MAIN.route) {
            Main()
        }
    }
}

enum class NavSections(
    val route: String
) {
    LOGIN("login"),
    MAIN("main")
}