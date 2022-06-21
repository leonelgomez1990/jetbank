package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.lgomez.jetbank.login.ui.navigatorstates.SplashNavigatorStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : ViewModel() {

    companion object {
        const val TAG = "SplashViewModel"
    }

    private val _navigation = MutableStateFlow<SplashNavigatorStates>(SplashNavigatorStates.Here)
    val navigation: StateFlow<SplashNavigatorStates> = _navigation.asStateFlow()

    fun navigationReset() {
        _navigation.value = SplashNavigatorStates.Here
    }

    fun goToSignIn() {
        _navigation.value = SplashNavigatorStates.ToSignIn
    }
}