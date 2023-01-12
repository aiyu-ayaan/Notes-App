package com.atech.task.database

import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val dao: NotesDao
) {

    val allNotes = dao.getAllNotes()

    suspend fun insert(note: NoteModel) = dao.insert(note)

    suspend fun update(note: NoteModel) = dao.update(note)

    suspend fun delete(note: NoteModel) = dao.delete(note)

    suspend fun deleteAllNotes() = dao.deleteAllNotes()
}