package com.marcosholgado.articlereader.di

import com.marcosholgado.articlereader.ArticleReaderContract
import com.marcosholgado.articlereader.ArticleReaderPresenter
import dagger.Module
import dagger.Provides

@Module
class ArticleReaderModule(val view: ArticleReaderContract.View) {

    @Provides
    fun providesPresenter(presenter: ArticleReaderPresenter): ArticleReaderContract.Presenter =
        presenter

    @Provides
    fun providesView(): ArticleReaderContract.View = view
}