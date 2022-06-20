package com.lgomez.jetbank.login.ui.navigatorstates

sealed class SignInNavigatorStates {
    object Here : SignInNavigatorStates()
    object ToMenuFeature : SignInNavigatorStates()
    object ToSignUp : SignInNavigatorStates()
    object ToPassRecovery : SignInNavigatorStates()
}