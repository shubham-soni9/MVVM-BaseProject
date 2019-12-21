package com.baseproject.data.remote.model

import com.baseproject.data.local.table.UserEntity
import com.google.gson.annotations.SerializedName

/**
 * The model class which holds the top popular articles data
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
data class PopularUserResponse(
    @SerializedName("results")
    var popularUserEntities: List<UserEntity>
)
