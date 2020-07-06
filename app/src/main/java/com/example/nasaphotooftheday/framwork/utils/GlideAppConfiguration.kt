package com.example.nasaphotooftheday.framwork.utils

import android.content.Context
import android.util.Log
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

/**setting glide class for global configurations
 * */

@GlideModule
class GlideAppConfiguration : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val cacheMemorySize = 1024 * 1024 * 20 // 20mb
        builder.setMemoryCache(LruResourceCache(cacheMemorySize.toLong()))
        builder.setLogLevel(Log.DEBUG)
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 20f
        circularProgressDrawable.centerRadius = 80f
        circularProgressDrawable.start()
        val requestOptions = RequestOptions().placeholder(circularProgressDrawable)
        builder.setDefaultRequestOptions(requestOptions)
    }

    // Disable manifest parsing to avoid adding similar modules twice.
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}