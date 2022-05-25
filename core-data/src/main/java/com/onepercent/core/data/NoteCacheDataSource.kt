package com.onepercent.core.data

import com.onepercent.core.model.Note

interface NoteCacheDataSource {

    fun getNotes(): List<Note>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}