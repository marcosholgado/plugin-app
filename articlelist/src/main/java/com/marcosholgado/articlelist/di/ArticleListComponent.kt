package com.marcosholgado.articlelist.di

import com.marcosholgado.articlelist.ArticleListFragment
import com.marcosholgado.core.di.CoreComponent
import com.marcosholgado.core.di.FeatureScope
import dagger.Component

@Component(modules = [ArticleListModule::class], dependencies = [CoreComponent::class])
@FeatureScope
interface ArticleListComponent {
    fun inject(articleListFragment: ArticleListFragment)
}