package com.lgomez.jetbank.menu.ui.navigatorstates

import com.lgomez.jetbank.menu.ui.models.NewUI

sealed class ListNewsNavigatorStates {
    object Here : ListNewsNavigatorStates()
    data class ToDetailNews(val new: NewUI) : ListNewsNavigatorStates()
    object ToAddNew : ListNewsNavigatorStates()
}
