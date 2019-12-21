package com.baseproject.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baseproject.data.model.Note

/**
 * Dao for saving location in room database
 */
@Dao
interface NotesDao {

    // Inserting the saved location into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    // Getting all saved location from database
    @Query("SELECT * FROM pinned_location")
    fun loadAll(): LiveData<List<Note>>
}
