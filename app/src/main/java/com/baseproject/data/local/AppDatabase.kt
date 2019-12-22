package com.baseproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.baseproject.data.local.dao.UserDao
import com.baseproject.data.local.table.UserEntity

/**
 * Database defination for define tables and Dao
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Providing Dao of location database
    abstract fun userDao(): UserDao
}
