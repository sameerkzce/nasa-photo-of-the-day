package com.example.nasaphotooftheday.framwork.api

import com.example.nasaphotooftheday.core.domain.MediaOfTheDay
import retrofit2.http.GET
import retrofit2.http.Query
/**service class for calling API
 * */
interface MediaOfTheDayService {
    @GET("planetary/apod")
    suspend fun getMediaOfTheDay(@Query("api_key") apiKey: String): MediaOfTheDay

    @GET("planetary/apod")
    suspend fun getMediaOfTheDay(
        @Query("api_key") apiKey: String,
        @Query("date") date: String
    ): MediaOfTheDay
}