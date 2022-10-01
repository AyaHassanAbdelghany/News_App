package com.example.news_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.model.repository.INewsRepo

class NewsViewModelFactory  (private val iNewsRepo : INewsRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            NewsViewModel(iNewsRepo) as T
        } else {
            throw IllegalArgumentException("Error")
        }
    }
}