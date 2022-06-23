package com.lgomez.jetbank.core.utils

import androidx.core.util.PatternsCompat

/**
 * Function that Checks if a String is a valid form of email.
 * It was changed to Jetpack PatternsCompat because of Patterns throws npe in tests
 *
 * @return true if email is valid
 */
fun String.isEmailValid(): Boolean =
    PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Function that Checks if a String is a valid form of password.
 *
 * @return true if password is valid
 */
fun String.isPasswordValid(): Boolean =
    PatternsLogIn.PASSWORD
        .matcher(this)
        .matches()