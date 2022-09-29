package com.example.news_app.model.repository

import com.example.news_app.network.RemoteSource
import com.example.news_app.pojo.NewsResponse

class NewsRepo  private  constructor(private  val remoteSource: RemoteSource): INewsRepo {

    companion object{

        private val newsRepo:NewsRepo? = null

        fun getInstance(remoteSource: RemoteSource): NewsRepo {
            return newsRepo ?: NewsRepo(remoteSource)
        }
    }

    override suspend fun getNews(category: String, country: String): NewsResponse {
        return remoteSource.getNews(category,country)
    }
}