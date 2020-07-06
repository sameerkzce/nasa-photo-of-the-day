package com.example.nasaphotooftheday.framwork.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * singleton class for retrofit lib and define the const require in app
 * */

object RetrofitInstance {
    const val BASE_URL = "https://api.nasa.gov/"
    const val VIDEO_URL="https://img.youtube.com/vi/"
    const val DUMMY_KEY="DEMO_KEY"
    const val MEDIATYPE_IMAGE="image"
    const val MEDIATYPE_VIDEO="video"
    const val IMGURL ="\"imgUrl\""
    private val httpLoggingInterceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private var okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .writeTimeout(120, TimeUnit.SECONDS)
        .build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)

        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mediaService: MediaOfTheDayService
        get() {
            return retrofit.create(MediaOfTheDayService::class.java)
        }
}
