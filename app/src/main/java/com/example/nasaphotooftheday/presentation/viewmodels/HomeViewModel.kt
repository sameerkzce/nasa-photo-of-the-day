package com.example.nasaphotooftheday.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nasaphotooftheday.core.data.MediaOfTheDayRepository
import com.example.nasaphotooftheday.core.domain.APIResult
import com.example.nasaphotooftheday.R
import com.example.nasaphotooftheday.dto.MediaOfTheDayDto
import com.example.nasaphotooftheday.dto.mapDto
import com.example.nasaphotooftheday.framwork.api.RetrofitInstance
import com.example.nasaphotooftheday.framwork.datasourceimp.MediaOfTheDayDataSourceImp
import com.example.nasaphotooftheday.framwork.utils.extractYoutubeIdId
import com.example.nasaphotooftheday.presentation.base.BaseViewModel
import com.example.nasaphotooftheday.presentation.navigator.HomeNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * view mode for HomeScreen Fragment
 * */
class HomeViewModel : BaseViewModel() {
    val TAG: String = HomeViewModel::class.java.simpleName
    var respository = MediaOfTheDayRepository(MediaOfTheDayDataSourceImp())

    var navigator: HomeNavigator? = null //navigator to communicate with activity
    var mediaOfTheDayLiveData = MutableLiveData<MediaOfTheDayDto>()

    /*function return the response planetary/apod?api_key=DEMO_KEY with date
   * we are using coroutine to fetch data from the server
   * On success we will update the list and change Domain object to DTO
   * on Fail we will show alert to user
   * */
    fun getMediaOfTheDay(selectedDate: String) {
        isProgressVisible.value = true
        viewModelScope.launch(Dispatchers.IO) {

            val response =
                if (selectedDate.isEmpty()) respository.getMediaOfTheDay() else respository.getMediaOfTheDay(
                    date = selectedDate
                )
            withContext(Dispatchers.Main) {
                isProgressVisible.value = false
                if (response.status == APIResult.Status.SUCCESS && response.data != null) {
                    if (response.data?.media_type == RetrofitInstance.MEDIATYPE_VIDEO) {
                        //in case of video there is no hdurl tag in response so we have set value from url property
                        response.data!!.hdurl = "${RetrofitInstance.VIDEO_URL + extractYoutubeIdId(
                            response.data!!.url
                        )}/0.jpg"
                        navigator?.setFabIcon(R.drawable.ic_baseline_play_arrow_24)
                    } else {
                        navigator?.setFabIcon(R.drawable.ic_baseline_zoom_out_map_24)
                    }
                    mediaOfTheDayLiveData.postValue(response.data?.mapDto())
                    Log.d(TAG, "we got response")
                } else {
                    Log.e(TAG, "we got Error${response.message.toString()}")
                    navigator?.showError("Error", response.message.toString())
                }
            }
        }
    }
}