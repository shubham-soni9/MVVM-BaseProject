package com.baseproject.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Table of saving location into the table pinned_location
 */
@Entity(tableName = "pinned_location", primaryKeys = ["id"])
@Parcelize
data class Note(
    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: String,

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String,

    @Expose
    @SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String
) : Parcelable