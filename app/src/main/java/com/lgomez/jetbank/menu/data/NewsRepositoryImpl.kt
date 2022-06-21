package com.lgomez.jetbank.menu.data

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.domain.News
import com.lgomez.jetbank.menu.framework.NewsDataSource

class NewsRepositoryImpl(
    private val newsDataSource: NewsDataSource
) : NewsRepository {

    override suspend fun getNews(
        country: String
    ): MyResult<List<News>> = newsDataSource.getNews(country)

    override suspend fun getNew(
        uid: String
    ): MyResult<News> = newsDataSource.getNew(uid)

    override suspend fun deleteNew(uid: String): MyResult<Boolean> =
        newsDataSource.deleteNew(uid)

    override suspend fun updateNew(data: News): MyResult<Boolean> =
        newsDataSource.updateNew(data)

    override suspend fun createNew(data: News): MyResult<String> =
        newsDataSource.createNew(data)

}