package com.marcosholgado.articlelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcosholgado.articlelist.adapter.ArticleListAdapter
import com.marcosholgado.articlelist.di.ArticleListModule
import com.marcosholgado.articlelist.di.DaggerArticleListComponent
import com.marcosholgado.articlelist.model.Article
import com.marcosholgado.core.di.CoreInjectHelper
import kotlinx.android.synthetic.main.fragment_article_list.*
import javax.inject.Inject


class ArticleListFragment : Fragment(), ArticleListContract.View {

    @Inject
    lateinit var adapter: ArticleListAdapter

    @Inject
    lateinit var presenter: ArticleListContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_article_list, container, false)


    override fun onAttach(context: Context) {
        DaggerArticleListComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(activity!!.applicationContext))
            .articleListModule(ArticleListModule(this))
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleList.adapter = adapter
        articleList.setHasFixedSize(true)
        articleList.layoutManager = LinearLayoutManager(context)
        presenter.getArticles()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.dispose()
    }

    override fun showArticles(articles: List<Article>) = adapter.addArticles(articles)

}
