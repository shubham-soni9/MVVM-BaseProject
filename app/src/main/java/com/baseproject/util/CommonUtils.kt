@file:JvmName("CommonUtils")
@file:JvmMultifileClass

package com.baseproject.util

import java.util.*

/**
 * Common Utility Methods
 */

fun generateUUID(): String {
    return UUID.randomUUID().toString()
}