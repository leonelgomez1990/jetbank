package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.data.storage.StorageRepository
import com.lgomez.jetbank.core.utils.MyResult

class UploadImageUseCase(private val storageRepository: StorageRepository) {
    suspend operator fun invoke(
        localPath: String,
        remotePath: String,
        name: String? = null
    ): MyResult<String> =
        storageRepository.uploadImage(localPath, remotePath)
}