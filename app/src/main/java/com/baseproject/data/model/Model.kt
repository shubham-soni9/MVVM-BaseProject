package com.baseproject.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Helper Parcelable model data classes
 */
@Parcelize
data class Picture(var large: String) : Parcelable

@Parcelize
data class Name(var title: String, var first: String, var last: String) : Parcelable

@Parcelize
data class Login(var uuid: String) : Parcelable