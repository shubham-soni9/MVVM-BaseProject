package com.baseproject.data.local.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.baseproject.data.local.Converters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.baseproject.data.model.Login
import com.baseproject.data.model.Name
import com.baseproject.data.model.Picture
import kotlinx.parcelize.Parcelize

/**
 * Table of saving location into the table pinned_location
 */
@Entity(tableName = "tb_user", primaryKeys = ["login"])
@Parcelize
@TypeConverters(Converters::class)
data class UserEntity(
    @Expose
    @SerializedName("login")
    @ColumnInfo(name = "login")
    var login: Login,

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