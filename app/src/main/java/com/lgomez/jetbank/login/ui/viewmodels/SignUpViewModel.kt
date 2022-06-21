package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.*
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.ui.navigatorstates.SignUpNavigatorStates
import com.lgomez.jetbank.login.usecases.CreateUserWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    val createUserWithEmailAndPasswordUseCase: CreateUserWithEmailAndPasswordUseCase
) : ViewModel() {

    companion object {
        const val TAG = "SignUpViewModel"
    }

    private val _navigation =
        MutableStateFlow<SignUpNavigatorStates>(SignUpNavigatorStates.Here)
    val navigation: StateFlow<SignUpNavigatorStates> = _navigation.asStateFlow()

    private val _viewState =
        MutableStateFlow<MyResult<Boolean>>(MyResult.Success(false))
    val viewState: StateFlow<MyResult<Boolean>> = _viewState.asStateFlow()

    fun goToSignIn() {
        _navigation.value = SignUpNavigatorStates.ToSignIn
    }

    fun goBack() {
        _navigation.value = SignUpNavigatorStates.GoBack
    }

    fun doCreateNewUser(email: String, password: String) {
        viewModelScope.launch {

            _viewState.emit(MyResult.Loading())
            try {
                _viewState.emit(createUserWithEmailAndPasswordUseCase(email, password))
            } catch (e: Exception) {
                _viewState.emit(MyResult.Failure(e))
            }
        }
    }

}
