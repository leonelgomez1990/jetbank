package com.lgomez.jetbank.menu.data

import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.domain.News

interface NewsRepository {
    suspend fun getNews(country: String): MyResult<List<News>>
    suspend fun getNew(uid: String): MyResult<News>
    suspend fun deleteNew(uid: String): MyResult<Boolean>
    suspend fun updateNew(data: News): MyResult<Boolean>
    suspend fun createNew(data: News): MyResult<String>
}