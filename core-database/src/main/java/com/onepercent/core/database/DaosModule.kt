package com.onepercent.core.database

import com.onepercent.core.database.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun provideNoteDao(
        database: XnotesDatabase,
    ): NoteDao = database.noteDao()

}