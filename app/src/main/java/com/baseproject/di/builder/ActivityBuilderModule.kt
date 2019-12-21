package com.baseproject.di.builder

import com.baseproject.di.module.HomeActivityModule
import com.baseproject.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Providing support for injecting module with android components
 */
@Module(includes = [FragmentBuilderModule::class])
internal abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity

}
