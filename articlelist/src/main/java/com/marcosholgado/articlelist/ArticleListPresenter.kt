package com.marcosholgado.articlelist

import android.util.Log
import com.marcosholgado.articlelist.network.ArticleListService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArticleListPresenter @Inject constructor(
    private val articleListService: ArticleListService,
    private val view: ArticleListContract.View
) : ArticleListContract.Presenter {

    var disposable: Disposable? = null

    override fun getArticles() {
        disposable = articleListService.getArticlesList("home")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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