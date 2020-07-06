package com.example.nasaphotooftheday.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**base class viewModel class all viewModels
 * */
open class BaseViewModel : ViewModel(){
    public val  isProgressVisible = MutableLiveData<Boolean>();
    init {
        isProgressVisible.value=false
    }
}