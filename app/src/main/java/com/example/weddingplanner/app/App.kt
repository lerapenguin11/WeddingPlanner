package com.example.weddingplanner.app

import android.app.Application
import com.example.weddingplanner.di.appModule
import com.example.weddingplanner.di.dataModule
import com.example.weddingplanner.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule,
                domainModule,
                dataModule))
        }
    }
}