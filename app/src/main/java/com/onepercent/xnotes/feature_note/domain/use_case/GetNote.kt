package com.onepercent.xnotes.feature_note.domain.use_case

import com.onepercent.core.model.Note
import com.onepercent.xnotes.core.data.repository.NoteRepository

class GetNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}