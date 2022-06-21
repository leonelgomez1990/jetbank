package com.lgomez.jetbank.login.ui.navigatorstates

sealed class PassRecoveryNavigatorStates {
    object Here : PassRecoveryNavigatorStates()
    object ToSignIn : PassRecoveryNavigatorStates()
    object GoBack : PassRecoveryNavigatorStates()
}

