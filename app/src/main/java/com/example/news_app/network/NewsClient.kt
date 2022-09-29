package com.example.news_app.network

import android.util.Log
import com.example.news_app.pojo.NewsResponse

class NewsClient private constructor() : RemoteSource{

    val newsService = RetrofitHelper.getInstance().create(NewsService::class.java)


    companion object{
        private var instance: NewsClient? = null
        fun getInstance(): NewsClient {
            return instance?: NewsClient()
        }
    }
    override suspend fun getNews(category: String, country: String): NewsResponse {
        Log.e("response", newsService.getNews(category,country).articles[0].author.toString())
       return  newsService.getNews(category,country)
    }

}