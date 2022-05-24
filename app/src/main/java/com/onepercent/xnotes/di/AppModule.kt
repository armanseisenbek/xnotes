package com.onepercent.xnotes.di

import com.onepercent.core.database.XnotesDatabase
import com.onepercent.xnotes.core.data.repository.NoteRepositoryImpl
import com.onepercent.xnotes.core.data.repository.NoteRepository
import com.onepercent.xnotes.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteRepository(db: XnotesDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNote = GetNote(repository),
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}