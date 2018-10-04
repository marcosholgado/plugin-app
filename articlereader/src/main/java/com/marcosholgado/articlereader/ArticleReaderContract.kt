package com.marcosholgado.articlereader

interface ArticleReaderContract {
    interface View {
        fun loadWebView(url: String)
    }

    interface Presenter {
        fun loadWebView(url: String)
    }
}