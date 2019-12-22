@file:JvmName("Config")
@file:JvmMultifileClass

package com.baseproject.common

import com.baseproject.BuildConfig

/**
 * Check whether app is debug or release
 */
fun isRelease(): Boolean {
    return !BuildConfig.DEBUG;
}
