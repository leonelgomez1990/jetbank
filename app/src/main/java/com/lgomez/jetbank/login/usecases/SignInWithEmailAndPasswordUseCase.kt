package com.lgomez.jetbank.login.usecases

import com.lgomez.jetbank.login.data.UserRepository

class SignInWithEmailAndPasswordUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String) =
        userRepository.signInWithEmailAndPassword(email, password)
}