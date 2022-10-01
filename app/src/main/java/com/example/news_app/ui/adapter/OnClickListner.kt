package com.example.news_app.ui.adapter

import com.example.news_app.pojo.Articles


interface OnClickListner {

    fun onClickItem(articles: Articles)
    fun onClickShare(articles: Articles)
}