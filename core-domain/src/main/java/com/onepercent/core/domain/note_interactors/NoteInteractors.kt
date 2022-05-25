package com.onepercent.core.domain.note_interactors

import com.onepercent.core.data.NoteCacheDataSource

data class NoteInteractors(
    val getNote: GetNote,
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
) {

    companion object Factory {

        fun build(noteCacheDataSource: NoteCacheDataSource): NoteInteractors {
            return NoteInteractors(
                getNote = GetNote(noteCacheDataSource),
                getNotes = GetNotes(noteCacheDataSource),
                deleteNote = DeleteNote(noteCacheDataSource),
                addNote = AddNote(noteCacheDataSource)
            )
        }
    }
}
