package com.example.news_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.model.repository.INewsRepo
import com.example.news_app.pojo.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel (private val iNewsRepo : INewsRepo) : ViewModel(){

    private var _news: MutableLiveData<NewsResponse> = MutableLiveData()
    var newsList: LiveData<NewsResponse> = _news


    fun getNews(category : String , country : String) {
        viewModelScope.launch  {
            val newsResponse = iNewsRepo.getNews(category,country)
            withContext(Dispatchers.Main){
                _news.postValue(newsResponse)
            }
        }
    }
}