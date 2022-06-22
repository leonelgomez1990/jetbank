package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.data.NewsRepository
import com.lgomez.jetbank.menu.domain.News

class UpdateNewUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(data: News): MyResult<Boolean> =
        newsRepository.updateNew(data)
}