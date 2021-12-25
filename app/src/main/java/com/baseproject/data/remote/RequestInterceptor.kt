package com.baseproject.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * It helps in intercepting the request body of APIS call.
 * e.g. Sending API KEY in all request body
 */
class RequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url
        val url = originalHttpUrl.newBuilder().build()
        val request = originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}