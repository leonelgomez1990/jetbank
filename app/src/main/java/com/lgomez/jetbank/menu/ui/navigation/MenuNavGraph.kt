package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lgomez.jetbank.menu.ui.viewmodels.ListNewsViewModel

@Composable
fun MenuNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.ITEM_GRAPH.route
    ) {
        navigation(
            startDestination = NavSections.LIST.route,
            route = NavSections.ITEM_GRAPH.route
        ) {
            composable(NavSections.LIST.route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(NavSections.ITEM_GRAPH.route)
                }
                val viewModel = hiltViewModel<ListNewsViewModel>(parentEntry)
                ListNewsState(navController, viewModel)
            }
            composable(NavSections.ADD.route) {
                AddNewsState(navController)
            }
            composable(NavSections.EDIT.route) {
                EditNewsState(navController)
            }
            composable(
                NavSections.DETAIL.route + "/{new}",
                arguments = listOf(navArgument("new") {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(NavSections.ITEM_GRAPH.route)
                }
                val viewModel = hiltViewModel<ListNewsViewModel>(parentEntry)
                val new: String = backStackEntry.arguments?.getString("new") ?: ""
                DetailNewsState(navController, new, viewModel)
            }
        }
    }
}


enum class NavSections(
    val route: String
) {
    ITEM_GRAPH("item"),
    LIST("list"),
    ADD("add"),
    EDIT("edit"),
    DETAIL("detail")
}