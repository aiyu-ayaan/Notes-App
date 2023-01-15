package com.atech.task.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.atech.task.utils.DUMMY_LIST
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [NoteModel::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        const val DATABASE_NAME = "notes_database"
    }

    @OptIn(DelicateCoroutinesApi::class)
    class RoomDatabaseCallback @Inject constructor(
        private val database: Provider<NotesDatabase>
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            GlobalScope.launch {
                val dao = database.get().notesDao()
                DUMMY_LIST.forEach {
                    dao.insert(it)
                }
            }
        }
    }
}