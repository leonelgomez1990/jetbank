package com.lgomez.jetbank.menu.ui.navigatorstates

sealed class EditNewNavigatorStates {
    object Here : EditNewNavigatorStates()
    object GoBack : EditNewNavigatorStates()
}
