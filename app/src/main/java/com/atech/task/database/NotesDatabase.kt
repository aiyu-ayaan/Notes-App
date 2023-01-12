package com.atech.task.database

import androidx.room.RoomDatabase

abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        const val DATABASE_NAME = "notes_database"
    }
}