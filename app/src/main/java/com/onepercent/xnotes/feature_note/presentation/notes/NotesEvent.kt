package com.onepercent.xnotes.feature_note.presentation.notes

import com.onepercent.core.model.Note
import com.onepercent.xnotes.feature_note.domain.util.NoteOrder

sealed class NotesEvent {

    data class Order(val noteOrder: NoteOrder): NotesEvent()

    data class DeleteNote(val note: Note):NotesEvent()

    object RestoreNote: NotesEvent()

    object ToggleOrderSection: NotesEvent()
}
