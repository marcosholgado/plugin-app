package com.marcosholgado.weather.network

import com.marcosholgado.weather.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    fun getWeather(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): Single<WeatherResponse>
}