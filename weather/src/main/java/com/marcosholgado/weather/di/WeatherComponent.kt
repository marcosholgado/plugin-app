package com.marcosholgado.weather.di

import com.marcosholgado.core.di.CoreComponent
import com.marcosholgado.core.di.FeatureScope
import com.marcosholgado.weather.WeatherFragment
import dagger.Component

@Component(modules = [WeatherModule::class], dependencies = [CoreComponent::class])
@FeatureScope
interface WeatherComponent {
    fun inject(fragment: WeatherFragment)
}