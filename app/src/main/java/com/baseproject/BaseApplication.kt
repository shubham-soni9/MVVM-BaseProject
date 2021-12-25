package com.baseproject

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.multidex.MultiDex
import com.baseproject.common.isRelease
import com.baseproject.util.FireAnalytics
import com.baseproject.util.Prefs
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Custom Application class for initializing components at application level
 */
@HiltAndroidApp

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        if (isRelease()) {
            FireAnalytics.Builder().setContext(this).build()
        } else {
            Timber.uprootAll()
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}