package com.example.nasaphotooftheday.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.nasaphotooftheday.R
import com.example.nasaphotooftheday.databinding.FragmentFullscreenBinding
import com.example.nasaphotooftheday.framwork.api.RetrofitInstance
import com.example.nasaphotooftheday.presentation.base.BaseFragment
import com.example.nasaphotooftheday.presentation.viewmodels.FullScreenImageViewModel


/**
 * An example full-screen fragment display full screen image with zoom in/out
 */
class FullscreenFragment : BaseFragment() {
    val TAG: String = FullscreenFragment::class.java.simpleName
    private lateinit var viewModel: FullScreenImageViewModel
    private lateinit var binding: FragmentFullscreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fullscreen, container, false)
        viewModel = ViewModelProvider(this)[FullScreenImageViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.imageUrlLive.value = it.getString(RetrofitInstance.IMGURL)
        }

    }


}