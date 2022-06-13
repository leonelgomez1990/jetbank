package com.lgomez.jetbank.login.usecases

import com.lgomez.jetbank.login.data.UserRepository

class SendPasswordResetEmailUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String) =
        userRepository.sendPasswordResetEmail(email)
}