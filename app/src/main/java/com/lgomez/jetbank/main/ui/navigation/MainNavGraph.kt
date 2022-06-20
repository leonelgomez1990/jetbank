package com.lgomez.jetbank.main.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.main.ui.screens.Main

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.MAIN.route
    ) {

        composable(NavSections.MAIN.route) {
            Main(navController)
        }
    }
}

enum class NavSections(
    val route: String
) {
    MAIN("main")
}