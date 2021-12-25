package com.baseproject.di.module

import android.content.Context
import com.baseproject.data.local.dao.UserDao
import com.baseproject.data.remote.ApiService
import com.baseproject.data.remote.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
class UserListFragmentModule {

}