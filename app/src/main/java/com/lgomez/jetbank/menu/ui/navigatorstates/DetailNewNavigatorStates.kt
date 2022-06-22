package com.lgomez.jetbank.menu.ui.navigatorstates

sealed class DetailNewNavigatorStates {
    object Here : DetailNewNavigatorStates()
    data class ToEditNew(val uid: String) : DetailNewNavigatorStates()
    object GoBack : DetailNewNavigatorStates()
}
