package com.marcosholgado.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.marcosholgado.core.di.CoreInjectHelper
import com.marcosholgado.weather.di.DaggerWeatherComponent
import com.marcosholgado.weather.di.WeatherModule
import com.marcosholgado.weather.model.WeatherResponse
import kotlinx.android.synthetic.main.fragment_weather.*
import javax.inject.Inject
import kotlin.math.roundToInt


class WeatherFragment : Fragment(), WeatherContract.View {

    @Inject
    lateinit var presenter: WeatherContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_weather, container, false)


    override fun onAttach(context: Context) {
        DaggerWeatherComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(activity!!.applicationContext))
            .weatherModule(WeatherModule(this))
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getWeather()
    }

    override fun showWeather(weather: WeatherResponse) {
        temperature.text = "${weather.main.temp.roundToInt()}°C"
        city.text = weather.name
        description.text = weather.weather[0].description
    }
}
