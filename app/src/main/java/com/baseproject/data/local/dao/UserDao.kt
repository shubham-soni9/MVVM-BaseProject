package com.baseproject.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baseproject.data.local.table.UserEntity

/**
 * Dao for saving location in room database
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM tb_user")
    fun loadPopularUser(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUsers(userEntities: List<UserEntity>)
}
