package com.baseproject.data.remote

import com.baseproject.data.remote.model.PopularUserResponse
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(ApiInventory.GENERAL_API)
    fun getUsers(@FieldMap map: Map<String, String>): Call<PopularUserResponse>

}