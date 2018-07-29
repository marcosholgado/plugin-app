package com.marcosholgado.articlelist.model

import com.marcosholgado.articlelist.Constants
import com.marcosholgado.core.list_utils.ViewType

data class Article(val section: String, val subsection: String, val title: String, val abstract: String,
                   val url: String, val byline: String, val item_type: String, val updated_date: String,
                   private val multimedia: List<Multimedia>) :
    ViewType {
    override fun getViewType(): Int = Constants.NEWS

    fun getThumbnail(): String {
        for(media in multimedia) {
            if (media.format == "mediumThreeByTwo210") {
                return media.url
            }
        }
        return ""
    }
}

data class Multimedia(val url: String, val format: String)