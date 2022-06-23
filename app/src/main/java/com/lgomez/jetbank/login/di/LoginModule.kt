package com.lgomez.jetbank.login.di

import com.google.firebase.auth.FirebaseAuth
import com.lgomez.jetbank.login.data.UserRepository
import com.lgomez.jetbank.login.data.UserRepositoryImpl
import com.lgomez.jetbank.login.framework.FirebaseUserDataSource
import com.lgomez.jetbank.login.framework.UserDataSource
import com.lgomez.jetbank.login.usecases.CreateUserWithEmailAndPasswordUseCase
import com.lgomez.jetbank.login.usecases.SendPasswordResetEmailUseCase
import com.lgomez.jetbank.login.usecases.SignInWithEmailAndPasswordUseCase
import com.lgomez.jetbank.login.usecases.ValidateSignInFieldsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object LoginModule {

    // Framework- DataSource provides
    @Provides
    fun provideFirebaseUserDataSource(auth: FirebaseAuth): UserDataSource =
        FirebaseUserDataSource(auth)

    // Data- Repository provides
    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository =
        UserRepositoryImpl(userDataSource)

    // Use cases provides
    @Provides
    fun provideSignInWithEmailAndPasswordUseCase(userRepository: UserRepository): SignInWithEmailAndPasswordUseCase =
        SignInWithEmailAndPasswordUseCase(userRepository)

    @Provides
    fun provideCreateUserWithEmailAndPasswordUseCase(userRepository: UserRepository): CreateUserWithEmailAndPasswordUseCase =
        CreateUserWithEmailAndPasswordUseCase(userRepository)

    @Provides
    fun provideSendPasswordResetEmailUseCase(userRepository: UserRepository): SendPasswordResetEmailUseCase =
        SendPasswordResetEmailUseCase(userRepository)

    @Provides
    fun provideValidateSignInFieldsUseCase(): ValidateSignInFieldsUseCase =
        ValidateSignInFieldsUseCase()
}