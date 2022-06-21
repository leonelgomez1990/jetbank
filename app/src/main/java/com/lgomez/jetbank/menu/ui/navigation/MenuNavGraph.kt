package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lgomez.jetbank.menu.ui.models.NewUI

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
            AddNewsState(navController)
        }
        composable(NavSections.EDIT.route) {
            EditNewsState(navController)
        }
        composable(NavSections.DETAIL.route + "/{new}",
            arguments = listOf(navArgument("new") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val new: String = backStackEntry.arguments?.getString("new") ?: ""
            DetailNewsState(navController, new)
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