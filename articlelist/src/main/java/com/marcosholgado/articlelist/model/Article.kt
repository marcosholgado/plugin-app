package com.marcosholgado.articlelist.model

import com.marcosholgado.articlelist.Constants
import com.marcosholgado.core.list_utils.ViewType

data class Article(val section: String, val subsection: String, val title: String, val abstract: String,
                   val url: String, val byline: String, val item_type: String, val updated_date: String) :
    ViewType {
    override fun getViewType(): Int = Constants.NEWS
}