package com.baseproject.data.remote

import com.baseproject.data.remote.model.PopularUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Provide request and response type information of REST APIS
 */
interface ApiService {

    @GET(GENERAL_API)
    fun getUsers(@QueryMap map: Map<String, String>): Call<PopularUserResponse>

}