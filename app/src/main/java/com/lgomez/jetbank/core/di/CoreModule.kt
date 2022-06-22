package com.lgomez.jetbank.core.di

import android.content.Context
import com.google.firebase.storage.FirebaseStorage
import com.lgomez.jetbank.core.data.storage.StorageRepository
import com.lgomez.jetbank.core.data.storage.StorageRepositoryImpl
import com.lgomez.jetbank.core.framework.storage.FirebaseStorageDataSource
import com.lgomez.jetbank.core.framework.storage.StorageDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    // Framework- DataSource provides
    @Singleton
    @Provides
    fun provideFirebaseStorageDataSource(
        storage: FirebaseStorage,
        @ApplicationContext context: Context
    ): StorageDataSource =
        FirebaseStorageDataSource(storage, context)

    // Data- Repository provides
    @Provides
    @Singleton
    fun provideStorageRepository(storageDataSource: StorageDataSource): StorageRepository =
        StorageRepositoryImpl(storageDataSource)

}