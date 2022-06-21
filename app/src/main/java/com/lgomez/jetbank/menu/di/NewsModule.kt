package com.lgomez.jetbank.menu.di

import com.google.firebase.firestore.FirebaseFirestore
import com.lgomez.jetbank.menu.data.NewsRepository
import com.lgomez.jetbank.menu.data.NewsRepositoryImpl
import com.lgomez.jetbank.menu.framework.FirebaseNewsDataSource
import com.lgomez.jetbank.menu.framework.NewsDataSource
import com.lgomez.jetbank.menu.usecases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Singleton
    @Provides
    fun provideFirebaseNewsDataSource(
        db: FirebaseFirestore
    ): NewsDataSource =
        FirebaseNewsDataSource(db)

    // Data - Repository provides
    @Provides
    @Singleton
    fun provideNewsRepository(newsDataSource: NewsDataSource): NewsRepository =
        NewsRepositoryImpl(newsDataSource)

    // Use cases provides
    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase =
        GetNewsUseCase(newsRepository)

}