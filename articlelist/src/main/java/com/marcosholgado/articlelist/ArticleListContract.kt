package com.marcosholgado.articlelist

import com.marcosholgado.articlelist.model.Article

interface ArticleListContract {
    interface View {
        fun showArticles(articles: List<Article>)
    }

    interface Presenter {
        fun getArticles()
        fun dispose()
    }
}