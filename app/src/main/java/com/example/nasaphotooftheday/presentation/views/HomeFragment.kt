package com.example.nasaphotooftheday.presentation.views

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nasaphotooftheday.R
import com.example.nasaphotooftheday.databinding.HomeFragmentBinding
import com.example.nasaphotooftheday.framwork.api.RetrofitInstance
import com.example.nasaphotooftheday.framwork.utils.extractYoutubeIdId
import com.example.nasaphotooftheday.framwork.utils.getDateFromEpoch
import com.example.nasaphotooftheday.presentation.base.BaseFragment
import com.example.nasaphotooftheday.presentation.navigator.HomeNavigator
import com.example.nasaphotooftheday.presentation.viewmodels.HomeViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Home fragment will init first on start of the app using navigation component
 * */

class HomeFragment : BaseFragment(), HomeNavigator {
    val TAG: String = HomeFragment::class.java.simpleName

    companion object {
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.navigator = this
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMediaOfTheDay("")
        setUIListener()
    }

    private fun setUIListener() {
        btnFab.setOnClickListener {
            if (viewModel.mediaOfTheDayLiveData.value?.media_type == RetrofitInstance.MEDIATYPE_IMAGE) {
                Log.d(TAG, "media type image")
                val bundle =
                    bundleOf(RetrofitInstance.IMGURL to viewModel.mediaOfTheDayLiveData.value?.hdurl)
                findNavController().navigate(R.id.actionFullScreen, bundle)
            } else {
                openYoutubeLink(extractYoutubeIdId(viewModel.mediaOfTheDayLiveData.value?.url))
            }
        }
        imgCalender.setOnClickListener {
            showDateDialog()
        }
    }

    private fun showDateDialog() {
        val builder: MaterialDatePicker.Builder<Long> = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText(R.string.title_date)

        val picker: MaterialDatePicker<Long> = builder.build()  // 2
        activity?.supportFragmentManager?.let {
            picker.show(it, picker.toString())
            picker.addOnCancelListener {
                Log.d(TAG, "dialog cancel")
            }
            picker.addOnPositiveButtonClickListener { it1 ->
                Log.d(
                    "DatePicker Activity",
                    "Date String = ${picker.headerText}::  Date epoch value = $it1"
                )
                viewModel.getMediaOfTheDay(getDateFromEpoch(it1))
            }
        }
    }

    private fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser =
            Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }
    }

    override fun showError(title: String, message: String) {
        showAlert(title, message)
    }

    override fun setFabIcon(resId: Int) {
        imgCalender.visibility = View.VISIBLE
        btnFab.visibility = View.VISIBLE
        btnFab.setImageResource(resId)
    }
}