package com.baseproject.di.component

import com.baseproject.BaseApplication
import com.baseproject.di.builder.ActivityBuilderModule
import com.baseproject.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Parent DI component for application level dependencies
 */
@Singleton
@Component(modules = [ActivityBuilderModule::class, AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }
}