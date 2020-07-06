package com.example.nasaphotooftheday.presentation.navigator

/**
 * interface to communicate viewmodel with fragment
 * */
interface HomeNavigator {
    fun showError(title:String,message:String)
    fun setFabIcon(resId:Int)
}