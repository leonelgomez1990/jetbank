package com.lgomez.jetbank.menu.usecases

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.data.NewsRepository
import com.lgomez.jetbank.menu.domain.News

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(news: String): MyResult<List<News>> =
        newsRepository.getNews(news)

    suspend fun getNew(news: String): MyResult<News> =
        newsRepository.getNew(news)
}