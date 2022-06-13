package com.lgomez.jetbank.login.data

import com.lgomez.jetbank.core.utils.MyResult

interface UserRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): MyResult<Boolean>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): MyResult<Boolean>
    suspend fun sendPasswordResetEmail(email: String): MyResult<Boolean>
}