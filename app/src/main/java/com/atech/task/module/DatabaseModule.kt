package com.atech.task.module

import android.app.Application
import androidx.room.Room
import com.atech.task.database.NotesDao
import com.atech.task.database.NotesDatabase
import com.atech.task.database.NotesDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideData(
        app: Application,
        callback: NotesDatabase.RoomDatabaseCallback
    ): NotesDatabase =
        Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            DATABASE_NAME
        ).addCallback(callback)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideDao(
        database: NotesDatabase
    ) :NotesDao= database.notesDao()
}