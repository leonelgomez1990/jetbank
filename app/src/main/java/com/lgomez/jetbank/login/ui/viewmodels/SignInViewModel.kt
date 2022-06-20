package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.*
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.ui.domain.AuthCredentials
import com.lgomez.jetbank.login.ui.navigatorstates.SignInNavigatorStates
import com.lgomez.jetbank.login.usecases.SignInWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
) : ViewModel() {

    companion object {
        const val TAG = "SignInViewModel"
    }

    private val _navigation = MutableStateFlow<SignInNavigatorStates>(SignInNavigatorStates.Here)
    val navigation: StateFlow<SignInNavigatorStates> = _navigation.asStateFlow()

    private val loginCredentialsData = MutableLiveData<AuthCredentials>()

    private val _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName

    private val _userPassword = MutableLiveData("")
    val userPassword: LiveData<String> = _userPassword

    init {
    }

    fun goToSignUp() {
        _navigation.value = SignInNavigatorStates.ToSignUp
    }

    fun goToMenuFeature() {
        _navigation.value = SignInNavigatorStates.ToMenuFeature
    }

    fun setLoginCredentials(loginCredentials: AuthCredentials) {
        loginCredentialsData.value = loginCredentials
    }

    val getLoginResult = loginCredentialsData.switchMap { authCredentials ->
        liveData(Dispatchers.IO) {
            emit(MyResult.Loading())
            try {
                emit(
                    signInWithEmailAndPasswordUseCase(
                        authCredentials.username,
                        authCredentials.password
                    )
                )
            } catch (e: Exception) {
                emit(MyResult.Failure(e))
            }
        }
    }

    fun onUserNameChange(newValue: String) {
        _userName.value = newValue
    }

    fun onUserPasswordChange(newValue: String) {
        _userPassword.value = newValue
    }
}
