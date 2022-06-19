package com.lgomez.jetbank.login.ui.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.main.ui.MainActivity
import com.lgomez.jetbank.login.ui.screens.LoginForm
import com.lgomez.jetbank.login.ui.screens.SplashScreen

@Composable
fun LoginNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.SPLASH_GRAPH.route
    ) {

        splashGraph(navController)
        loginGraph(navController)
        composable(NavSections.MAIN.route) {
            val context = LocalContext.current
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation(startDestination = NavSections.LOGO.route, route = NavSections.SPLASH_GRAPH.route) {
        composable(NavSections.LOGO.route) {
            SplashScreen(navController)
        }
    }
}

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = NavSections.USERNAME.route,
        route = NavSections.LOGIN_GRAPH.route
    ) {
        composable(NavSections.USERNAME.route) {
            LoginForm(navController)
        }
        composable(NavSections.PASSWORD.route) {
            LoginForm(navController)
        }
        composable(NavSections.REGISTER.route) {
            LoginForm(navController)
        }
    }
}

enum class NavSections(
    val route: String
) {
    SPLASH_GRAPH("splash"),
    LOGO("logo"),
    LOGIN_GRAPH("login"),
    MAIN("main"),
    USERNAME("username"),
    PASSWORD("password"),
    REGISTER("register")
}