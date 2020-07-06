package com.example.nasaphotooftheday.framwork.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**static utils function
 * */
fun extractYoutubeIdId(url: String?): String {
    var vId: String = ""
    val pattern: Pattern = Pattern.compile(
        "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
        Pattern.CASE_INSENSITIVE
    )
    val matcher: Matcher = pattern.matcher(url)
    if (matcher.matches()) {
        vId = matcher.group(1)
    }
    return vId
}

 fun getDateFromEpoch(long:Long):String{
     val sdf = SimpleDateFormat("yyyy-MM-dd",Locale.getDefault())
     val date = java.util.Date(long)
     return sdf.format(date)
 }

 