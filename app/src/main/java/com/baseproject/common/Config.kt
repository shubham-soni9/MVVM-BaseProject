@file:JvmName("Config")
@file:JvmMultifileClass

package com.baseproject.common

import com.baseproject.BuildConfig

fun isRelease(): Boolean {
    return !BuildConfig.DEBUG;
}
