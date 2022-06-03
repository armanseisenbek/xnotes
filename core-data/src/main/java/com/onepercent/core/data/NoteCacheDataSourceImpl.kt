package com.onepercent.core.data

import com.onepercent.core.data.mappers.mapFromEntity
import com.onepercent.core.data.mappers.mapToEntity
import com.onepercent.core.database.dao.NoteDao
import com.onepercent.core.domain.datasource.NoteCacheDataSource
import com.onepercent.core.model.Note

class NoteCacheDataSourceImpl(
    private val noteDao: NoteDao
) : NoteCacheDataSource {

    override suspend fun getNotes(): List<Note> {
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
