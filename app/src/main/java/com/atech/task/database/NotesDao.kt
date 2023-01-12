package com.atech.task.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteModel)

    @Update
    suspend fun update(note: NoteModel)

    @Delete
    suspend fun delete(note: NoteModel)

    @Query("SELECT * FROM tasks")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("DELETE FROM tasks ")
    suspend fun deleteAllNotes()
}