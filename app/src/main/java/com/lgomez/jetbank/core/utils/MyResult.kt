package com.lgomez.jetbank.core.utils

sealed class MyResult<out R> {
    class Loading<out T> : MyResult<T>()
    data class Success<out T>(val data: T) : MyResult<T>()
    data class Failure(val exception: Exception) : MyResult<Nothing>()
}