package com.baseproject.data.remote

import android.content.Context
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.baseproject.R
import com.baseproject.data.remote.model.Resource
import com.google.gson.stream.MalformedJsonException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Handling network and local database calls
 */
abstract class NetworkBoundResource<T, V> @MainThread protected constructor(private var baseContext: Context) {
    private val result = MediatorLiveData<Resource<T>>()

    init {
        result.setValue(Resource.loading(null))
        // Always load the data from DB initially so that we have
        CoroutineScope(Dispatchers.IO).launch {
            val dbSource = loadFromDb()
            withContext(Dispatchers.Main) {
                // Fetch the data from network and add it to the resource
                result.addSource(dbSource) {
                    result.removeSource(dbSource)
                    if (shouldFetch()) {
                        fetchFromNetwork(dbSource)
                    } else {
                        result.addSource(dbSource) { newData: T ->
                            if (null != newData) result.value = Resource.success(newData)
                        }
                    }
                }
            }
        }
    }

    /**
     * This method fetches the data from remoted service and save it to local db
     * @param dbSource - Database source
     */
    private fun fetchFromNetwork(dbSource: LiveData<T>) {
        result.addSource(dbSource) { newData: T ->
            result.setValue(Resource.loading(newData))
        }
        createCall().enqueue(object : Callback<V> {
            override fun onResponse(call: Call<V>, response: Response<V>) {
                result.removeSource(dbSource)
                saveResultAndReInit(response.body())
            }

            override fun onFailure(call: Call<V>, t: Throwable) {
                result.removeSource(dbSource)
                result.addSource(dbSource) { newData: T ->
                    result.setValue(Resource.error(getCustomErrorMessage(t), newData))
                }
            }
        })
    }

    private fun getCustomErrorMessage(error: Throwable): String {
        return if (error is SocketTimeoutException) {
            baseContext.getString(R.string.requestTimeOutError)
        } else if (error is MalformedJsonException) {
            baseContext.getString(R.string.responseMalformedJson)
        } else if (error is IOException) {
            baseContext.getString(R.string.networkError)
        } else if (error is HttpException) {
            error.response()?.message()?:""
        } else {
            baseContext.getString(R.string.unknownError)
        }
    }

    @MainThread
    private fun saveResultAndReInit(response: V?) {
        CoroutineScope(Dispatchers.IO).launch {
            if (response != null) {
                saveCallResult(response)
            }
            withContext(Dispatchers.Main) {
                result.addSource(loadFromDb()) { newData: T ->
                    if (null != newData) result.value = Resource.success(newData)
                }
            }
        }
    }

    @WorkerThread
    protected abstract suspend fun saveCallResult(item: V)

    @MainThread
    private fun shouldFetch(): Boolean {
        return true
    }

    @MainThread
    protected abstract suspend fun loadFromDb(): LiveData<T>

    @MainThread
    protected abstract fun createCall(): Call<V>

    val asLiveData: LiveData<Resource<T>>
        get() = result
}