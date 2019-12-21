package com.baseproject.data.local

import androidx.lifecycle.LiveData
import com.baseproject.data.model.Note

/**
 * Providing Interface for database helper of accessing room database tables
 */
interface DbHelper {
    fun getAllNotes(): LiveData<List<Note>>
    suspend fun insertLocation(pinnedLocation: Note)
}
