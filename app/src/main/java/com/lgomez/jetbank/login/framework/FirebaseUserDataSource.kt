package com.lgomez.jetbank.login.framework

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.lgomez.jetbank.core.utils.MyResult
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class FirebaseUserDataSource constructor(
    private val auth: FirebaseAuth
) : UserDataSource {

    companion object {
        const val TAG = "FirebaseUserDataSource"
    }


    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): MyResult<Boolean> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Log.d(TAG, "signInWithEmail:success")
            MyResult.Success(true)
        } catch (e: Exception) {
            Log.w(TAG, "signInWithEmail:failure, Exception thrown: ${e.message}")
            MyResult.Failure(e)
        }
    }

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): MyResult<Boolean> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            Log.d(TAG, "createUserWithEmailAndPassword:success")
            MyResult.Success(true)
        } catch (e: Exception) {
            Log.w(
                TAG,
                "createUserWithEmailAndPassword:failure, Exception thrown: ${e.message}"
            )
            MyResult.Failure(e)
        }
    }

    override suspend fun sendPasswordResetEmail(email: String): MyResult<Boolean> {
        return try {
            val result = auth.sendPasswordResetEmail(email).await()
            Log.d(TAG, "sendPasswordResetEmail:success")
            MyResult.Success(true)
        } catch (e: Exception) {
            Log.w(
                TAG,
                "sendPasswordResetEmail:failure, Exception thrown: ${e.message}"
            )
            MyResult.Failure(e)
        }
    }
}