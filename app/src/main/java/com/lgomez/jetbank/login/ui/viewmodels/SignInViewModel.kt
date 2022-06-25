package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.*
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.ui.navigatorstates.SignInNavigatorStates
import com.lgomez.jetbank.login.usecases.SignInWithEmailAndPasswordUseCase
import com.lgomez.jetbank.login.usecases.ValidateSignInFieldsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
    private val validateSignInFieldsUseCase: ValidateSignInFieldsUseCase,
) : ViewModel() {

    companion object {
        const val TAG = "SignInViewModel"
    }

    private val _navigation = MutableStateFlow<SignInNavigatorStates>(SignInNavigatorStates.Here)
    val navigation: StateFlow<SignInNavigatorStates> = _navigation.asStateFlow()

    private val _viewState =
        MutableStateFlow<MyResult<Boolean>>(MyResult.Success(false))
    val viewState: StateFlow<MyResult<Boolean>> = _viewState.asStateFlow()

    fun navigationReset() {
        _navigation.value = SignInNavigatorStates.Here
    }

    fun goToSignUp() {
        _navigation.value = SignInNavigatorStates.ToSignUp
    }

    fun goToMenuFeature() {
        _navigation.value = SignInNavigatorStates.ToMenuFeature
    }

    fun onEmailValidation(email: String): String =
        validateSignInFieldsUseCase.validateEmail(email)

    fun onPasswordValidation(password: String): String =
        validateSignInFieldsUseCase.validatePassword(password)

    fun doUserLogin(email: String, password: String) {
        viewModelScope.launch {

            _viewState.emit(MyResult.Loading())
            try {
                _viewState.emit(signInWithEmailAndPasswordUseCase(email, password))
            } catch (e: Exception) {
                _viewState.emit(MyResult.Failure(e))
            }
        }
    }
}
