package com.baseproject.di.module

import android.content.Context
import com.baseproject.data.local.dao.UserDao
import com.baseproject.data.remote.ApiService
import com.baseproject.data.remote.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

/**
 * Module for HomeActivity dependencies
 */
@Module
@InstallIn(ActivityComponent::class)
class HomeActivityModule {

//    @Provides
//    fun providesPermissionHelper(context: HomeActivity): PermissionHelper {
//        return PermissionHelper(context)
//    }
}