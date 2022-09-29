package com.example.news_app.pojo

import com.google.gson.annotations.SerializedName

data class Source(

    @SerializedName("id") val id : String?,
    @SerializedName("name") val name : String
)
