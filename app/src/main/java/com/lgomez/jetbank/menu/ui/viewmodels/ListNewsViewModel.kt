package com.lgomez.jetbank.menu.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.domain.News
import com.lgomez.jetbank.menu.ui.models.NewUI
import com.lgomez.jetbank.menu.ui.navigatorstates.ListNewsNavigatorStates
import com.lgomez.jetbank.menu.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class ListNewsViewModel @Inject constructor(
    val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    companion object {
        const val TAG = "ListNewsViewModel"
    }

    private val _navigation =
        MutableStateFlow<ListNewsNavigatorStates>(ListNewsNavigatorStates.Here)
    val navigation: StateFlow<ListNewsNavigatorStates> = _navigation.asStateFlow()

    private val _viewState =
        MutableStateFlow<MyResult<Boolean>>(MyResult.Success(false))
    val viewState: StateFlow<MyResult<Boolean>> = _viewState.asStateFlow()

    private val _news = MutableStateFlow<List<News>>(emptyList())
    val news: StateFlow<List<News>> = _news.asStateFlow()

    private var newsBackup = emptyList<News>()

    init {
        refreshNews()
    }
    fun navigationReset() {
        _navigation.value = ListNewsNavigatorStates.Here
    }

    fun goToAddNews() {
        _navigation.value = ListNewsNavigatorStates.ToAddNew
    }

    fun goToDetailNews(new: NewUI) {
        _navigation.value = ListNewsNavigatorStates.ToDetailNews(new)
    }


    fun refreshNews() {
        viewModelScope.launch {

            _viewState.emit(MyResult.Loading())
            try {
                when (val result = getNewsUseCase("US")) {
                    is MyResult.Failure -> {
                        _viewState.emit(MyResult.Failure(result.exception))
                    }
                    is MyResult.Success -> {
                        _viewState.emit(MyResult.Success(true))
                        _news.emit(result.data)
                        newsBackup = result.data

                    }
                    is MyResult.Loading -> {
                        _viewState.emit(MyResult.Loading())
                    }
                }
            } catch (e: Exception) {
                _viewState.emit(MyResult.Failure(e))
            }
        }
    }

    fun searchedItems(searchedText: String) {
        if (searchedText.isNotEmpty()) {
            val resultList = ArrayList<News>()
            for (data in newsBackup) {
                if (data.title.lowercase(Locale.getDefault())
                        .contains(searchedText, ignoreCase = true)
                ) {
                    resultList.add(data)
                }
            }
            _news.value = resultList
        } else {
            _news.value = newsBackup
        }
    }
}
