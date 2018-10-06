package com.marcosholgado.weather

import android.util.Log
import com.marcosholgado.weather.network.WeatherService
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Named

class WeatherPresenter @Inject constructor(
    private val view: WeatherContract.View,
    private val weatherService: WeatherService,
    @Named("ioScheduler") private val ioScheduler: Scheduler,
    @Named("mainScheduler") private val mainScheduler: Scheduler,
    private val city: String
) : WeatherContract.Presenter {

    private var disposable: Disposable? = null

    override fun getWeather() {
        disposable = weatherService
            .getWeather(city, "c099b5d4d2978eb94d0eeb30c6472a09", "metric")
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe(
                { response ->
                    view.showWeather(response)
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