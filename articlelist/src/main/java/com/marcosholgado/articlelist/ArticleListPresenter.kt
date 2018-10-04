package com.marcosholgado.articlelist

import android.util.Log
import com.marcosholgado.articlelist.network.ArticleListService
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Named

class ArticleListPresenter @Inject constructor(
    private val articleListService: ArticleListService,
    private val view: ArticleListContract.View,
    @Named("ioScheduler") private val ioScheduler: Scheduler,
    @Named("mainScheduler") private val mainScheduler: Scheduler,
    private val section: String
) : ArticleListContract.Presenter {

    private var disposable: Disposable? = null

    override fun getArticles() {
        disposable = articleListService.getArticlesList(section)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe(
                { response ->
                    view.showArticles(response.results)
                },
                { error ->
                    Log.d("ERROR", error.message)
                }
            )
    }

    override fun dispose() {
        disposable?.dispose()
    }
}