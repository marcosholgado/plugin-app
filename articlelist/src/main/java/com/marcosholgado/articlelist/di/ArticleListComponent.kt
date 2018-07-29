package com.marcosholgado.articlelist.di

import com.marcosholgado.articlelist.ArticleListFragment
import dagger.Component

@Component(modules = [ArticleListModule::class])
interface ArticleListComponent {
    fun inject(articleListFragment: ArticleListFragment)
}