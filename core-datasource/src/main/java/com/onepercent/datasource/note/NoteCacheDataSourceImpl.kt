package com.onepercent.datasource.note

import com.onepercent.core.data.NoteCacheDataSource
import com.onepercent.core.database.dao.NoteDao
import com.onepercent.core.model.Note
import com.onepercent.datasource.mapper.mapFromEntity
import com.onepercent.datasource.mapper.mapToEntity

class NoteCacheDataSourceImpl(
    private val noteDao: NoteDao
) : NoteCacheDataSource {

    override fun getNotes(): List<Note> {
        return noteDao.getNotes().map { noteEntity ->
                noteEntity.mapFromEntity()
        }
    }

    override suspend fun getNoteById(id: Int): Note {
        return noteDao.getNoteById(id).mapFromEntity()
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note.mapToEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.mapToEntity())
    }

}