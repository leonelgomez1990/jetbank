package com.lgomez.jetbank.login.ui.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lgomez.jetbank.main.ui.MainActivity
import com.lgomez.jetbank.login.ui.screens.LoginForm

@Composable
fun LoginNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavSections.LOGIN.route
    ) {

        composable(NavSections.LOGIN.route) {
            LoginForm(navController)
        }
        composable(NavSections.MAIN.route) {
            val context = LocalContext.current
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

enum class NavSections(
    val route: String
) {
    LOGIN("login"),
    MAIN("main")
}