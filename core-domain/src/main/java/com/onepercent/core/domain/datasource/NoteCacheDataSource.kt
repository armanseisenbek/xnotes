package com.onepercent.core.domain.datasource

import com.onepercent.core.domain.model.Note

interface NoteCacheDataSource {

    suspend fun getNotes(): List<Note>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}