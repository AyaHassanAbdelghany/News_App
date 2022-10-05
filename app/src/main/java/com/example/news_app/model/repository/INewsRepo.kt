package com.example.news_app.model.repository

import com.example.news_app.pojo.NewsResponse

interface INewsRepo {

    suspend fun getNews(category: String, country: String): NewsResponse
    suspend fun getNewsSearch(q :String ,sortBy : String) : NewsResponse

}