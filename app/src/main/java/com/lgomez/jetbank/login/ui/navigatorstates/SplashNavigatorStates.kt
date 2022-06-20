package com.lgomez.jetbank.login.ui.navigatorstates

sealed class SplashNavigatorStates {
    object Here : SplashNavigatorStates()
    object ToSignIn : SplashNavigatorStates()
}