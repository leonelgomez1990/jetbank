package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.data.NewsRepository
import com.lgomez.jetbank.menu.domain.News

class CreateNewUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(data: News): MyResult<String> =
        newsRepository.createNew(data)
}
