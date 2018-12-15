package com.marcosholgado.droidcon.home.application

import android.app.Application
import com.marcosholgado.core.di.CoreComponent
import com.marcosholgado.core.di.CoreComponentProvider
import com.marcosholgado.core.di.DaggerCoreComponent

class App : Application(), CoreComponentProvider{

    private lateinit var coreComponent: CoreComponent

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent.builder().build()
        }
        return coreComponent
    }
}