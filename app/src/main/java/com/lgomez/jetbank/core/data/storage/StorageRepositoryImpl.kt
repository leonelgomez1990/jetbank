package com.lgomez.jetbank.core.data.storage

import com.lgomez.jetbank.core.framework.storage.StorageDataSource
import com.lgomez.jetbank.core.utils.MyResult

class StorageRepositoryImpl(private val storageDataSource: StorageDataSource) : StorageRepository {

    override suspend fun uploadFile(
        localPath: String,
        remotePath: String,
        name: String?
    ): MyResult<String> {
        return storageDataSource.uploadFile(localPath, remotePath, name)
    }

    override suspend fun deleteFile(path: String): MyResult<Boolean> {
        return storageDataSource.deleteFile(path)
    }

    override suspend fun uploadImage(
        localPath: String,
        remotePath: String,
        name: String?
    ): MyResult<String> {
        return storageDataSource.uploadImage(localPath, remotePath, name)
    }

    override suspend fun deleteImage(path: String): MyResult<Boolean> {
        return storageDataSource.deleteImage(path)
    }

}