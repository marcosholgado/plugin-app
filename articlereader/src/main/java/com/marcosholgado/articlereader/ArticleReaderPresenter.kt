package com.marcosholgado.articlereader

import javax.inject.Inject

class ArticleReaderPresenter @Inject constructor(
    private val view: ArticleReaderContract.View
) : ArticleReaderContract.Presenter {

    override fun loadWebView(url: String) {
        view.loadWebView(url)
    }
}