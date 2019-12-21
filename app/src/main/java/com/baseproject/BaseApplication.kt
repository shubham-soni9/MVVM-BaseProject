package com.baseproject

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.multidex.MultiDex
import com.baseproject.common.Config
import com.baseproject.di.component.DaggerAppComponent
import com.baseproject.util.FireAnalytics
import com.baseproject.util.Prefs
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        if (Config.isRelease()) {
            FireAnalytics.Builder().setContext(this).build()
        } else {
            Timber.uprootAll()
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<BaseApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}