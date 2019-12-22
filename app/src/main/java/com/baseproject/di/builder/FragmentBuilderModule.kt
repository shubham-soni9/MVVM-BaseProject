package com.baseproject.di.builder

import com.baseproject.di.module.UserListFragmentModule
import com.baseproject.ui.fragment.user_list.UserListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Providing support for injecting module with android components
 */
@Module
abstract class FragmentBuilderModule {

//    @ContributesAndroidInjector
//    internal abstract fun contributeSavedPinDialogFragment(): SavedPinDialog

    @ContributesAndroidInjector(modules = [UserListFragmentModule::class])
    internal abstract fun contributeUserListFragment(): UserListFragment

}
