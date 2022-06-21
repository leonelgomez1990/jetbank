package com.lgomez.jetbank.menu.framework

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.lgomez.jetbank.core.utils.MyResult
import com.lgomez.jetbank.menu.domain.News
import com.lgomez.jetbank.menu.framework.entities.FirebaseNew
import com.lgomez.jetbank.menu.framework.entities.toFirebaseNew
import com.lgomez.jetbank.menu.framework.entities.toNews
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class FirebaseNewsDataSource(
    private val db: FirebaseFirestore
) : NewsDataSource {

    companion object {
        const val TAG = "FirebaseNewsDataSource"
    }

    private var news: List<News> = emptyList()
    private val COLLECTION_PATH = "News"

    override suspend fun getNews(country: String): MyResult<List<News>> {
        return try {
            val documents = db.collection(COLLECTION_PATH)
                .whereEqualTo("enabled", true)
                .orderBy("title")
                .get().await()

            if (!documents.isEmpty) {
                val list = mutableListOf<News>()
                documents.forEach { document ->
                    Log.d("GetNews", "Item retrieved with uid ${document.id}")
                    list.add(document.toObject<FirebaseNew>().toNews())
                }
                news = list.toList()
                MyResult.Success(list)
            } else {
                MyResult.Success(mutableListOf<News>())
            }
        } catch (e: Exception) {
            Log.e(TAG, "GetNews: Exception thrown: ${e.message}")
            MyResult.Failure(e)
        }
    }

    override suspend fun getNew(uid: String): MyResult<News> {
        return try {
            MyResult.Success(news.first { it.uid == uid })
        } catch (e: Exception) {
            MyResult.Failure(e)
        }
    }

    override suspend fun deleteNew(uid: String): MyResult<Boolean> {
        return try {
            val document = db.collection(COLLECTION_PATH).document(uid)
            val data = document
                .delete()
                .await()

            MyResult.Success(true)
        } catch (e: Exception) {
            Log.e(TAG, "deleteNew: Exception thrown: ${e.message}")
            MyResult.Failure(e)
        }
    }

    override suspend fun updateNew(data: News): MyResult<Boolean> {
        if (data.uid == null) {
            Log.e(TAG, "updateNew: Exception thrown: uid is null")
            MyResult.Failure(Exception("Error"))
        }
        val document = db.collection(COLLECTION_PATH).document(data.uid!!)
        return try {
            val op = document
                .set(data.toFirebaseNew())
                .await()
            MyResult.Success(true)
        } catch (e: Exception) {
            Log.e(TAG, "updateNew: Exception thrown: ${e.message}")
            MyResult.Failure(e)
        }
    }

    override suspend fun createNew(data: News): MyResult<String> {
        val document = db.collection(COLLECTION_PATH).document()
        data.uid = document.id
        return try {
            val op = document
                .set(data.toFirebaseNew())
                .await()
            MyResult.Success(document.id)
        } catch (e: Exception) {
            Log.e(TAG, "createNew: Exception thrown: ${e.message}")
            MyResult.Failure(e)
        }
    }

}