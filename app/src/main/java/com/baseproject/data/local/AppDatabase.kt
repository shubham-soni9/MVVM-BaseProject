package com.baseproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.baseproject.data.local.dao.NotesDao
import com.baseproject.data.model.Note

/**
 * Database defination for define tables and Dao
 */
@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Providing Dao of location database
    abstract fun noteDao(): NotesDao
}
