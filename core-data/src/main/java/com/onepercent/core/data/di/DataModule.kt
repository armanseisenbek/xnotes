package com.onepercent.core.data.di

import com.onepercent.core.data.NoteCacheDataSourceImpl
import com.onepercent.core.database.dao.NoteDao
import com.onepercent.core.domain.datasource.NoteCacheDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideNoteCacheDataSource(noteDao: NoteDao): NoteCacheDataSource = NoteCacheDataSourceImpl(noteDao)

}