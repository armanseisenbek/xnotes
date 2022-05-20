package com.onepercent.xnotes.feature_note.data.repository

import com.onepercent.xnotes.feature_note.data.datasource.NoteDao
import com.onepercent.xnotes.feature_note.data.datasource.mapFromEntity
import com.onepercent.xnotes.feature_note.data.datasource.mapToEntity
import com.onepercent.xnotes.feature_note.domain.model.Note
import com.onepercent.xnotes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().map {
            it.map { noteEntity ->
                noteEntity.mapFromEntity()
            }
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