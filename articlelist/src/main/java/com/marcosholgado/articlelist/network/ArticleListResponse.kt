package com.marcosholgado.articlelist.network

import com.marcosholgado.articlelist.model.Article

data class ArticleListResponse(val results: List<Article>)