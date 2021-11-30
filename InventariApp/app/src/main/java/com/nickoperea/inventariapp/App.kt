package com.nickoperea.inventariapp

import android.app.Application
import com.nickoperea.inventariapp.di.dataSourceModule
import com.nickoperea.inventariapp.di.repoModule
import com.nickoperea.inventariapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                dataSourceModule,
                repoModule,
                viewModelsModule
            )
        }
    }
}