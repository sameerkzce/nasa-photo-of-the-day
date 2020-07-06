package com.example.nasaphotooftheday.core.domain

import com.google.gson.annotations.SerializedName

/**
 * domain layer
 * PoJo data class
 * */
data class MediaOfTheDay (

    @SerializedName("copyright") val copyright : String,
    @SerializedName("date") val date : String,
    @SerializedName("explanation") val explanation : String,
    @SerializedName("hdurl") var hdurl : String,
    @SerializedName("media_type") val media_type : String,
    @SerializedName("service_version") val service_version : String,
    @SerializedName("title") val title : String,
    @SerializedName("url") val url : String
)