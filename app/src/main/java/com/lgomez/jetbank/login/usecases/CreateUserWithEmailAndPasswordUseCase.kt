package com.lgomez.jetbank.login.usecases

import com.lgomez.jetbank.login.data.UserRepository

class CreateUserWithEmailAndPasswordUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String) =
        userRepository.createUserWithEmailAndPassword(email, password)
}