package com.example.nasaphotooftheday.dto

import com.example.nasaphotooftheday.core.domain.MediaOfTheDay
import com.google.gson.annotations.SerializedName

/** model class for DTO so that we can use in xml data binding
 * */
data class MediaOfTheDayDto(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("date") val date: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("hdurl") val hdurl: String,
    @SerializedName("media_type") val media_type: String,
    @SerializedName("service_version") val service_version: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
)

//extension function to covert model to DTO and change image path
fun MediaOfTheDay.mapDto() = MediaOfTheDayDto(
    copyright = "$copyright", date = "$date", explanation = "$explanation", hdurl = "$hdurl",
    media_type = "$media_type", service_version = "$service_version", title = "$title",
    url = "$url"
)