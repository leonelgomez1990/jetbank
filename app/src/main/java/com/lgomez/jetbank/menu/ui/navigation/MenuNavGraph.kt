package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.LIST.route
    ) {

        composable(NavSections.LIST.route) {
            ListNewsState(navController)
        }
        composable(NavSections.ADD.route) {
            //AddNewsState(navController)
        }
        composable(NavSections.EDIT.route) {
            //EditNewsState(navController)
        }
        composable(NavSections.DETAIL.route) {
            //DetailNewsState(navController)
        }
    }
}


enum class NavSections(
    val route: String
) {
    LIST("list"),
    ADD("add"),
    EDIT("edit"),
    DETAIL("detail")
}