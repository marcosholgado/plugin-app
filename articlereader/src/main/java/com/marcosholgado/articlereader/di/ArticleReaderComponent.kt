package com.marcosholgado.articlereader.di

import com.marcosholgado.core.di.CoreComponent
import com.marcosholgado.core.di.FeatureScope
import com.marcosholgado.articlereader.ArticleReaderActivity

import dagger.Component

@Component(modules = [ArticleReaderModule::class], dependencies = [CoreComponent::class])
@FeatureScope
interface ArticleReaderComponent {
    fun inject(fragment: ArticleReaderActivity)
}