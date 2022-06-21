package com.lgomez.jetbank.login.ui.navigatorstates

sealed class SignUpNavigatorStates {
    object Here : SignUpNavigatorStates()
    object ToSignIn : SignUpNavigatorStates()
    object GoBack : SignUpNavigatorStates()
}
