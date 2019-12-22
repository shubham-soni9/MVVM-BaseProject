package com.baseproject.data.remote.model

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Handling CommonResponse from the server
 * Should be used when server is sending standard response in multiple APIS
 */
class CommonResponse<T> {
    @SerializedName("status")
    @Expose
    val status = 0
    @SerializedName("message")
    @Expose
    val message: String? = null
    @SerializedName("data")
    @Expose
    private val data: T? = null

    fun <T> toResponseModel(classRef: Class<T>?): T {
        return Gson().fromJson(Gson().toJson(data), classRef)
    }

    override fun toString(): String {
        return "$status $message\n$data"
    }

    fun getData(): String {
        return data.toString()
    }
}