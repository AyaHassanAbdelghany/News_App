package com.example.news_app.network

import com.example.news_app.model.Keys
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Keys.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}