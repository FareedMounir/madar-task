package com.madarsoft.madarsoft.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.madarsoft.madarsoft.data.prefs.Prefs
import com.madarsoft.madarsoft.data.prefs.PrefsImpl
import com.madarsoft.madarsoft.utils.Constants.SHARED_PREFERENCES_KEY
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val storageModule = module {

    single<Prefs> { PrefsImpl(get()) }

    single { getSharedPreferences(androidApplication()) }
}

fun getSharedPreferences(context: Application): SharedPreferences {
    return context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
}