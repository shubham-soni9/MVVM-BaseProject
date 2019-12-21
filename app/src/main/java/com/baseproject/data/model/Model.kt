package com.nytimes.articles.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(var large: String) : Parcelable

@Parcelize
data class Name(var title: String, var first: String, var last: String) : Parcelable

@Parcelize
data class ID(var value: String) : Parcelable