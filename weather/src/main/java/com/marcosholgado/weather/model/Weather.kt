package com.marcosholgado.weather.model

data class WeatherResponse(val name: String, val weather: List<Weather>, val main: Main, val wind: Wind)

data class Weather(val main: String, val description: String)

data class Main(val temp: Float, val pressure: Int, val humidity: Int)

data class Wind(val speed: Float)