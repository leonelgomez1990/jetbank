package com.lgomez.jetbank.login.data

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.login.framework.UserDataSource

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): MyResult<Boolean> = userDataSource.signInWithEmailAndPassword(email, password)

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): MyResult<Boolean> = userDataSource.createUserWithEmailAndPassword(email, password)

    override suspend fun sendPasswordResetEmail(email: String): MyResult<Boolean> =
        userDataSource.sendPasswordResetEmail(email)
}