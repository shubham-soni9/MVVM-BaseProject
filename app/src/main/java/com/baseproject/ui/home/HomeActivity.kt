package com.baseproject.ui.home

import com.baseproject.BR
import com.baseproject.R
import com.baseproject.databinding.ActivityHomeBinding
import com.baseproject.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
}

