package com.baseproject.ui.home

import android.os.Bundle
import com.baseproject.BR
import com.baseproject.R
import com.baseproject.databinding.ActivityHomeBinding
import com.baseproject.ui.base.BaseActivity
import com.baseproject.ui.fragment.user_list.UserListFragment
import com.baseproject.util.TRANSITION_NONE
import com.baseproject.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(
            this,
            UserListFragment.newInstance(),
            R.id.fragContainer,
            false,
            TRANSITION_NONE
        );
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
}

