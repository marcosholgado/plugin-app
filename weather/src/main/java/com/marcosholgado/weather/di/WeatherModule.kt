package com.marcosholgado.weather.di

import com.marcosholgado.weather.WeatherContract
import com.marcosholgado.weather.WeatherPresenter
import com.marcosholgado.weather.network.WeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class WeatherModule(private val view: WeatherContract.View, private val city: String) {

    @Provides
    fun providesPresenter(presenter: WeatherPresenter): WeatherContract.Presenter = presenter

    @Provides
    fun providesView(): WeatherContract.View = view

    @Provides
    fun providesCity(): String = city

    @Provides
    fun providesWeatherService() : WeatherService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
        return retrofit.create(WeatherService::class.java)
    }
}