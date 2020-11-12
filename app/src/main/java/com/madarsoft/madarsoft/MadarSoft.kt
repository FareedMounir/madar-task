package com.madarsoft.madarsoft

import android.app.Application
import com.madarsoft.madarsoft.di.storageModule
import com.madarsoft.madarsoft.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MadarSoft : Application() {


    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MadarSoft)
            modules(
                listOf(
                    viewModelModule,
                    storageModule
                )
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}