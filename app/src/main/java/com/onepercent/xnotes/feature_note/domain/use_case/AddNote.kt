package com.onepercent.xnotes.feature_note.domain.use_case

import com.onepercent.core.model.Note
import com.onepercent.xnotes.core.model.InvalidNoteException
import com.onepercent.xnotes.core.data.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }
}