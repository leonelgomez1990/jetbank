package com.lgomez.jetbank.login.usecases

import com.lgomez.jetbank.core.utils.isEmailValid
import com.lgomez.jetbank.core.utils.isPasswordValid

class ValidateSignInFieldsUseCase() {

    fun validateEmail(email: String): String {
        return when {
            email.isBlank() -> "Debe completar el campo"
            !email.isEmailValid() -> "Debe completar un email válido"
            else -> ""
        }
    }

    fun validatePassword(password: String): String {
        return when {
            password.isBlank() -> "Debe completar el campo"
            password.length < 3 -> "La contraseña es muy corta"
            //password.isPasswordValid() -> "La contraseña es demasiado débil"
            else -> ""
        }
    }

}