package com.marcosholgado.droidcon.home.application

import android.app.Application
import com.marcosholgado.core.di.CoreComponent
import com.marcosholgado.core.di.CoreComponentProvider
import com.marcosholgado.core.di.DaggerCoreComponent

class App : Application(), CoreComponentProvider{

    var coreComponent: CoreComponent? = null

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent.let {
            DaggerCoreComponent.builder().build()
        }
    }
}