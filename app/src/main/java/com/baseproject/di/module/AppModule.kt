package com.baseproject.di.module

import android.content.Context
import androidx.room.Room
import com.baseproject.BaseApplication
import com.baseproject.common.Constants
import com.baseproject.di.qualifier.DatabaseInfo
import com.baseproject.data.local.AppDatabase
import com.baseproject.data.local.AppDbHelper
import com.baseproject.data.local.DbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Module for application level dependencies
 */
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Named("application_context")
    @Singleton
    fun provideContext(application: BaseApplication): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, @Named("application_context") context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return Constants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(mAppDataBase: AppDatabase): DbHelper {
        return AppDbHelper(mAppDataBase)
    }
}