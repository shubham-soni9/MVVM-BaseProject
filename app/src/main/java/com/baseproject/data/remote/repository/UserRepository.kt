package com.baseproject.data.remote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.baseproject.common.REQ_INCLUDE
import com.baseproject.common.REQ_PAGE
import com.baseproject.common.REQ_RESULTS
import com.baseproject.common.REQ_SEED
import com.baseproject.data.local.AppDatabase
import com.baseproject.data.local.table.UserEntity
import com.baseproject.data.remote.ApiService
import com.baseproject.data.remote.CommonParams
import com.baseproject.data.remote.NetworkBoundResource
import com.baseproject.data.remote.model.PopularUserResponse
import com.baseproject.data.remote.model.Resource
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Named

/**
 * Helper Class for getting data from network or local database
 */
open class UserRepository @Inject internal constructor(
    @Named("application_context")
    private val baseContext: Context,
    private val appDatabase: AppDatabase,
    private val apiService: ApiService
) {

    fun loadUsers(page: Int): LiveData<Resource<List<UserEntity>>> {
        val commonParams = CommonParams.Builder()
            .add(REQ_PAGE, page)
            .add(REQ_SEED, "abc")
            .add(REQ_RESULTS, 10)
            .add(REQ_INCLUDE, "name,email,picture,login")
            .build()

        return object : NetworkBoundResource<List<UserEntity>, PopularUserResponse>(baseContext) {

            override suspend fun loadFromDb(): LiveData<List<UserEntity>> {
                return appDatabase.userDao().loadPopularUser()
            }

            override fun createCall(): Call<PopularUserResponse> {
                return apiService.getUsers(commonParams.map)
            }

            override suspend fun saveCallResult(item: PopularUserResponse) {
                appDatabase.userDao().saveUsers(item.popularUserEntities)
            }
        }.asLiveData

    }
}