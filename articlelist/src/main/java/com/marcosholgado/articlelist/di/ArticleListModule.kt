package com.marcosholgado.articlelist.di

import com.marcosholgado.articlelist.ArticleListContract
import com.marcosholgado.articlelist.ArticleListPresenter
import com.marcosholgado.articlelist.adapter.ArticleListAdapter
import com.marcosholgado.articlelist.adapter.NewsDelegateAdapter
import com.marcosholgado.articlelist.network.ArticleListService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ArticleListModule(private val view: ArticleListContract.View,
                        private val newsDelegateAdapter: NewsDelegateAdapter.onViewSelectedListener,
                        private val section: String) {

    @Provides
    fun providesPresenter(presenter: ArticleListPresenter): ArticleListContract.Presenter = presenter

    @Provides
    fun providesView(): ArticleListContract.View = view

    @Provides
    fun provideAdapter(): ArticleListAdapter = ArticleListAdapter(newsDelegateAdapter)

    @Provides
    fun provideSection(): String = section

    @Provides
    fun providesArticleListService(): ArticleListService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.nytimes.com/svc/")
            .build()
        return retrofit.create(ArticleListService::class.java)
    }
}