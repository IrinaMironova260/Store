package com.example.store.presentation

import android.app.Application
import com.example.store.presentation.di.moduleCategories
import com.example.store.presentation.di.moduleProducts
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@App)

            modules(moduleCategories, moduleProducts)
        }
    }
}