package com.onepercent.feature.notes

import com.onepercent.core.model.Note
import com.onepercent.core.common.util.NoteOrder

sealed class NotesEvent {

    data class Order(val noteOrder: NoteOrder): NotesEvent()

    data class DeleteNote(val note: Note):NotesEvent()

    object RestoreNote: NotesEvent()

    object ToggleOrderSection: NotesEvent()
}
