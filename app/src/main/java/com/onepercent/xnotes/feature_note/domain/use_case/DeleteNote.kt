package com.onepercent.xnotes.feature_note.domain.use_case

import com.onepercent.core.model.Note
import com.onepercent.xnotes.core.data.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}