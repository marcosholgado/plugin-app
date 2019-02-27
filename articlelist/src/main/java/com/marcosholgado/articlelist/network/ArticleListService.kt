package com.marcosholgado.articlelist.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ArticleListService {

    @GET("topstories/v2/{section}.json?api-key=Urdc0bHeoBEsWPByKxpGmqZBO8Uj8vp7")
    fun getArticlesList(@Path("section") section: String): Single<ArticleListResponse>
}