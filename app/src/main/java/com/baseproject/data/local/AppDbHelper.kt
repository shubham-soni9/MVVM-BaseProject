package com.baseproject.data.local

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.baseproject.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Providing Database helper of accessing room database tables
 */
@Singleton
class AppDbHelper @Inject constructor(private val mAppDatabase: AppDatabase) : DbHelper {
    override fun getAllNotes(): LiveData<List<Note>> {
        return mAppDatabase.noteDao().loadAll()
    }

    @WorkerThread
    override suspend fun insertLocation(pinnedLocation: Note) =
        withContext(Dispatchers.IO) {
            mAppDatabase.noteDao().insert(pinnedLocation)
        }
}
