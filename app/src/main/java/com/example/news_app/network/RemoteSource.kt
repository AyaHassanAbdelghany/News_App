package com.example.news_app.network

import com.example.news_app.pojo.NewsResponse

interface RemoteSource {

    suspend fun getNews(category: String, country: String): NewsResponse
    suspend fun getNewsSearch(q :String ,sortBy : String) : NewsResponse


}