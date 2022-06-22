package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.data.storage.StorageRepository
import com.lgomez.jetbank.core.utils.MyResult

class DeleteImageUseCase(private val storageRepository: StorageRepository) {
    suspend operator fun invoke(path: String): MyResult<Boolean> =
        storageRepository.deleteImage(path)
}