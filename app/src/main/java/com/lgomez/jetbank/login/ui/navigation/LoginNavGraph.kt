package com.lgomez.jetbank.login.ui.navigation

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.menu.ui.MenuActivity

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
            context.startActivity(Intent(context, MenuActivity::class.java))
            val activity = (LocalContext.current as? Activity)
            activity?.finish()
        }
    }
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation(
        startDestination = NavSections.LOGO.route,
        route = NavSections.SPLASH_GRAPH.route
    ) {
        composable(NavSections.LOGO.route) {
            SplashState(navController)
        }
    }
}

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = NavSections.USERNAME.route,
        route = NavSections.LOGIN_GRAPH.route
    ) {
        composable(NavSections.USERNAME.route) {
            SignInState(navController)
        }
        composable(NavSections.PASSWORD.route) {
            PassRecoveryState(navController)
        }
        composable(NavSections.REGISTER.route) {
            SignUpState(navController)
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