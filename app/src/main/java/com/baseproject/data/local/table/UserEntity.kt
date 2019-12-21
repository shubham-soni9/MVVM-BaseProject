package com.baseproject.data.local.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.baseproject.data.local.Converters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nytimes.articles.data.model.ID
import com.nytimes.articles.data.model.Name
import com.nytimes.articles.data.model.Picture
import kotlinx.android.parcel.Parcelize

/**
 * Table of saving location into the table pinned_location
 */
@Entity(tableName = "tb_user", primaryKeys = ["id"])
@Parcelize
@TypeConverters(Converters::class)
data class UserEntity(
    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: ID,

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: Name,

    @Expose
    @SerializedName("picture")
    @ColumnInfo(name = "picture")
    var picture: Picture,

    @Expose
    @SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String
) : Parcelable