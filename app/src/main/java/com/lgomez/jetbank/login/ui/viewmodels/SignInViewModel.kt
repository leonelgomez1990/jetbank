package com.lgomez.jetbank.login.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.usecases.SignInWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
) : ViewModel() {

    companion object {
        const val TAG = "SignInViewModel"
    }

    private val _isSuccessfulLoggued: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessfulLoggued: LiveData<Boolean> get() = _isSuccessfulLoggued

    init {
        _isSuccessfulLoggued.value = false
    }

    fun signInUser(email: String, password: String) {
        viewModelScope.launch {
            when (val result = signInWithEmailAndPasswordUseCase(email, password)) {
                is MyResult.Failure -> {}
                is MyResult.Success -> { _isSuccessfulLoggued.value = true }
            }
        }

    }

    fun isSuccessfulLoggued() = _isSuccessfulLoggued.value ?: false
}
