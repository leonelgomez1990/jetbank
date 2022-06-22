package com.lgomez.jetbank.menu.ui.navigatorstates

sealed class AddNewNavigatorStates {
    object Here : AddNewNavigatorStates()
    object GoBack : AddNewNavigatorStates()
}
