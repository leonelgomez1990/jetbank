package com.lgomez.jetbank.core.framework.storage

import com.lgomez.jetbank.core.utils.MyResult

interface StorageDataSource {

    suspend fun uploadFile(
        localPath: String,
        remotePath: String,
        name: String? = null
    ): MyResult<String>

    suspend fun deleteFile(path: String): MyResult<Boolean>

    suspend fun uploadImage(
        localPath: String,
        remotePath: String,
        name: String? = null
    ): MyResult<String>

    suspend fun deleteImage(path: String): MyResult<Boolean>
}