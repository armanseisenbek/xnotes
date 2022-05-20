package com.onepercent.xnotes.feature_note.domain.use_case

import com.onepercent.xnotes.feature_note.domain.model.Note
import com.onepercent.xnotes.feature_note.domain.repository.NoteRepository

class GetNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}