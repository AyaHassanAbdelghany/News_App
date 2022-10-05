package com.example.news_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.model.Keys
import com.example.news_app.model.repository.INewsRepo
import com.example.news_app.model.repository.NewsRepo
import com.example.news_app.network.RemoteSource
import com.example.news_app.pojo.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel (private val iNewsRepo : INewsRepo) : ViewModel(){

    private var _news: MutableLiveData<NewsResponse> = MutableLiveData()
    var newsList: LiveData<NewsResponse> = _news

    companion object{
         var textSearch: String =""
    }

    fun getNews(category : String = Keys.GENERAL, country : String ) {
        viewModelScope.launch  {
            val newsResponse = iNewsRepo.getNews(category,country)
            withContext(Dispatchers.Main){
                _news.postValue(newsResponse)
            }
        }
    }


    fun getNewsSearch(q :String, sortBy :String) {
        viewModelScope.launch  {
            val newsSearchResponse = iNewsRepo.getNewsSearch(q,sortBy)

            withContext(Dispatchers.Main){
                _news.postValue(newsSearchResponse)
            }
        }
    }
}