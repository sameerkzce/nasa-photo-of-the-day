package com.example.nasaphotooftheday.framwork.datasourceimp

import com.example.nasaphotooftheday.core.data.MediaOfTheDayDataSource
import com.example.nasaphotooftheday.core.domain.APIResult
import com.example.nasaphotooftheday.core.domain.MediaOfTheDay


import com.example.nasaphotooftheday.framwork.api.MediaOfTheDayService
import com.example.nasaphotooftheday.framwork.api.RetrofitInstance

/**
 * data layer implement for API calling
 * */
class MediaOfTheDayDataSourceImp : MediaOfTheDayDataSource {
    private var mediaService: MediaOfTheDayService = RetrofitInstance.mediaService
    override suspend fun getMediaOfTheDay(): APIResult<MediaOfTheDay> {
        return try {
            val response = mediaService.getMediaOfTheDay(RetrofitInstance.DUMMY_KEY)
            APIResult(APIResult.Status.SUCCESS, response, "")
        } catch (e: Exception) {
            APIResult<MediaOfTheDay>(APIResult.Status.ERROR, null, e.message)
        }
    }

    override suspend fun getMediaOfTheDay(date: String): APIResult<MediaOfTheDay> {
        return try {
            val response = mediaService.getMediaOfTheDay(RetrofitInstance.DUMMY_KEY, date)
            APIResult(APIResult.Status.SUCCESS, response, "")
        } catch (e: Exception) {
            APIResult<MediaOfTheDay>(APIResult.Status.ERROR, null, e.message)
        }
    }
}