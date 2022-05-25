package com.onepercent.datasource.di

import com.onepercent.core.data.NoteCacheDataSource
import com.onepercent.core.database.dao.NoteDao
import com.onepercent.datasource.note.NoteCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideNoteCacheDataSource(noteDao: NoteDao): NoteCacheDataSource = NoteCacheDataSourceImpl(noteDao)

}