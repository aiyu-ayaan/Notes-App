package com.atech.task.module

import android.content.Context
import androidx.room.Room
import com.atech.task.database.NotesDatabase
import com.atech.task.database.NotesDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideData(
        @ApplicationContext context: Context
    ): NotesDatabase =
        Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideDao(
        database: NotesDatabase
    ) = database.notesDao()
}