package com.baseproject.data.remote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.baseproject.common.ApiKeys.REQ_INCLUDE
import com.baseproject.common.ApiKeys.REQ_PAGE
import com.baseproject.common.ApiKeys.REQ_RESULTS
import com.baseproject.common.ApiKeys.REQ_SEED
import com.baseproject.data.local.dao.UserDao
import com.baseproject.data.local.table.UserEntity
import com.baseproject.data.remote.ApiService
import com.baseproject.data.remote.CommonParams
import com.baseproject.data.remote.NetworkBoundResource
import com.baseproject.data.remote.model.PopularUserResponse
import com.baseproject.data.remote.model.Resource
import retrofit2.Call
import javax.inject.Inject

open class UserRepository @Inject internal constructor(
    private val baseContext: Context,
    private val articleDao: UserDao,
    private val apiService: ApiService
) {

    fun loadUsers(page: Int): LiveData<Resource<List<UserEntity>>> {
        val commonParams = CommonParams.Builder()
            .add(REQ_PAGE, page)
            .add(REQ_SEED, "abc")
            .add(REQ_RESULTS, 10)
            .add(REQ_INCLUDE, "name,id,email,picture")
            .build()

        return object : NetworkBoundResource<List<UserEntity>, PopularUserResponse>(baseContext) {

            override suspend fun loadFromDb(): LiveData<List<UserEntity>> {
                return articleDao.loadPopularUser();
            }

            override fun createCall(): Call<PopularUserResponse> {
                return apiService.getUsers(commonParams.map);
            }

            override suspend fun saveCallResult(item: PopularUserResponse) {
                articleDao.saveUsers(item.popularUserEntities);
            }
        }.asLiveData;

    }
}