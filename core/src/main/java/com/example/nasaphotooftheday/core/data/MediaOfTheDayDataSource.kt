package com.example.nasaphotooftheday.core.data

import com.example.nasaphotooftheday.core.domain.APIResult
import com.example.nasaphotooftheday.core.domain.MediaOfTheDay

/**data layer interface for getting data
 * */
interface MediaOfTheDayDataSource {
    suspend fun  getMediaOfTheDay(): APIResult<MediaOfTheDay>
    suspend fun  getMediaOfTheDay(date:String): APIResult<MediaOfTheDay>
}