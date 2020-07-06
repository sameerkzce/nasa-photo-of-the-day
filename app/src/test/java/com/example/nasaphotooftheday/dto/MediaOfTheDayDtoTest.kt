package com.example.nasaphotooftheday.dto


import com.example.nasaphotooftheday.core.domain.MediaOfTheDay
import org.junit.Assert.assertEquals
import org.junit.Test

internal class MediaOfTheDayDtoTest {

    /***
     * Test case for check the extension function for convert the message to message dto
     * */
    @Test
    fun `maps User to MessageCollectionDto using extension function`() {
        val parent = buildMessageCollection()
        val child = parent.mapDto()
        assertEquals(TITLE, child.title)
        assertEquals(DESC, child.explanation)
        assertEquals(HDURL, child.hdurl)
    }

    private fun buildMessageCollection() = MediaOfTheDay(
        title = TITLE, explanation = DESC, hdurl = HDURL,
        media_type = "image", date = "", service_version = "", url = "", copyright = ""
    )

    companion object {
        const val HDURL = "hdUrl"
        const val DESC = "desc"
        const val TITLE = "title"
    }
}