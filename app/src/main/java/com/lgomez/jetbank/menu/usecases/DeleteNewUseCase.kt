package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.data.NewsRepository

class DeleteNewUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(uid: String): MyResult<Boolean> =
        newsRepository.deleteNew(uid)
}