package com.example.nasaphotooftheday.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.nasaphotooftheday.presentation.base.BaseViewModel
 
/**
 * viewmodel for FullScreen fragment
 * */
class FullScreenImageViewModel :BaseViewModel(){
    val TAG: String =  FullScreenImageViewModel::class.java.simpleName
    var imageUrlLive =MutableLiveData<String>()

}