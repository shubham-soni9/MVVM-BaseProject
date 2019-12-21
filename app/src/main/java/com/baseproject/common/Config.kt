package com.baseproject.common

import com.baseproject.BuildConfig

object Config {

    fun isRelease(): Boolean {
        return !BuildConfig.DEBUG;
    }
}