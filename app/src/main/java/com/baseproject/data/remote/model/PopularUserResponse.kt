package com.baseproject.data.remote.model

import com.baseproject.data.local.table.UserEntity
import com.google.gson.annotations.SerializedName

/**
 * The model class which holds the top popular articles data
 */
data class PopularUserResponse(
    @SerializedName("results")
    var popularUserEntities: List<UserEntity>
)
