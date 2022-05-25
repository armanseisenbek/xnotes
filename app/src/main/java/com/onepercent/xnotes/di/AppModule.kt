package com.onepercent.xnotes.di

import com.onepercent.core.data.NoteCacheDataSource
import com.onepercent.core.domain.note_interactors.NoteInteractors

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
    fun provideNoteInteractors(
        noteCacheDataSource: NoteCacheDataSource
    ): NoteInteractors {
        return NoteInteractors.build(noteCacheDataSource)
    }
}