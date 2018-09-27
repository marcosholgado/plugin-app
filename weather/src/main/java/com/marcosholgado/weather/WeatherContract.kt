package com.marcosholgado.weather

import com.marcosholgado.weather.model.WeatherResponse

interface WeatherContract {
    interface View {
        fun showWeather(weather: WeatherResponse)
    }

    interface Presenter {
        fun getWeather()

        fun dispose()
    }
}