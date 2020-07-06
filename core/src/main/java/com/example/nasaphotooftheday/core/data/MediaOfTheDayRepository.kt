package com.example.nasaphotooftheday.core.data


class MediaOfTheDayRepository(private val dataSource: MediaOfTheDayDataSource) {
    suspend fun getMediaOfTheDay() = dataSource.getMediaOfTheDay()
    suspend fun getMediaOfTheDay(date: String) = dataSource.getMediaOfTheDay(date)
}