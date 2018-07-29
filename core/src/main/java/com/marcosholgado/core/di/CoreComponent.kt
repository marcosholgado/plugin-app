package com.marcosholgado.core.di

import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton


@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    @Named("ioScheduler") fun getIOScheduler(): Scheduler

    @Named("mainScheduler") fun getMainScheduler(): Scheduler
}