package com.marcosholgado.articlelist.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ArticleListService {

    @GET("topstories/v2/{section}.json?api-key=f858ea0aa1814d169061d4b7f922cc4d")
    fun getArticlesList(@Path("section") section: String): Single<ArticleListResponse>
}