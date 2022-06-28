package com.lgomez.jetbank.core.utils

import android.text.Html
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


fun String?.convertHtmlToString(): String {
    if (this == null)
        return ""
    //As fromHtml is deprecated, whe need to ask for Build version to includes the new int parameter
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(this).toString()
    }
}