package com.lgomez.jetbank.menu.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lgomez.jetbank.core.ui.views.ShowProgressIndicator
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.core.utils.showMessage
import com.lgomez.jetbank.menu.ui.navigatorstates.ListNewsNavigatorStates
import com.lgomez.jetbank.menu.ui.screens.ListNewsScreen
import com.lgomez.jetbank.menu.ui.viewmodels.ListNewsViewModel

@Composable
fun ListNewsState(navController: NavController) {
    val viewModel = hiltViewModel<ListNewsViewModel>()
    val navigator by viewModel.navigation.collectAsState()
    val viewState by viewModel.viewState.collectAsState(MyResult.Success(false))

    val news by viewModel.news.collectAsState(emptyList())
    val searchBy = remember { mutableStateOf(TextFieldValue("")) }

    ListNewsScreen(
        news = news,
        onRefreshClick = {
            searchBy.value = TextFieldValue("")
            viewModel.refreshNews()
        },
        stateValue = searchBy.value,
        onValueChange = { searchBy.value = it },
        onCloseClick = { searchBy.value = TextFieldValue("") },
        onAddClick = { viewModel.goToAddNews() },
        onDetailClick = { viewModel.goToDetailNews(it) }
    )
    viewModel.searchedItems(searchBy.value.text)

    when (viewState) {
        is MyResult.Failure -> {
            showMessage(
                LocalContext.current,
                (viewState as MyResult.Failure).exception.localizedMessage ?: ""
            )
        }
        is MyResult.Loading -> {
            ShowProgressIndicator()
        }
        is MyResult.Success -> {
            if ((viewState as MyResult.Success<Boolean>).data) {
            }
        }
    }

    LaunchedEffect(navigator) {
        when (navigator) {
            is ListNewsNavigatorStates.ToDetailNews -> {
                navController.navigate(route = "${NavSections.DETAIL.route}/${(navigator as ListNewsNavigatorStates.ToDetailNews).new.title}")
                viewModel.navigationReset()
            }
            is ListNewsNavigatorStates.ToAddNew -> {
                navController.navigate(route = NavSections.ADD.route)
                viewModel.navigationReset()
            }
            else -> {}
        }
    }
}