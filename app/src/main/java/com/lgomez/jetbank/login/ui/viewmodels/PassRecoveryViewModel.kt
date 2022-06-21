package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.*
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.ui.navigatorstates.PassRecoveryNavigatorStates
import com.lgomez.jetbank.login.usecases.SendPasswordResetEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PassRecoveryViewModel @Inject constructor(
    val sendPasswordResetEmailUseCase: SendPasswordResetEmailUseCase
) : ViewModel() {

    companion object {
        const val TAG = "PassRecoveryViewModel"
    }

    private val _navigation =
        MutableStateFlow<PassRecoveryNavigatorStates>(PassRecoveryNavigatorStates.Here)
    val navigation: StateFlow<PassRecoveryNavigatorStates> = _navigation.asStateFlow()

    private val _viewState =
        MutableStateFlow<MyResult<Boolean>>(MyResult.Success(false))
    val viewState: StateFlow<MyResult<Boolean>> = _viewState.asStateFlow()

    fun navigationReset() {
        _navigation.value = PassRecoveryNavigatorStates.Here
    }

    fun goToSignIn() {
        _navigation.value = PassRecoveryNavigatorStates.ToSignIn
    }

    fun goBack() {
        _navigation.value = PassRecoveryNavigatorStates.GoBack
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {

            _viewState.emit(MyResult.Loading())
            try {
                _viewState.emit(sendPasswordResetEmailUseCase(email))
            } catch (e: Exception) {
                _viewState.emit(MyResult.Failure(e))
            }
        }
    }
}
