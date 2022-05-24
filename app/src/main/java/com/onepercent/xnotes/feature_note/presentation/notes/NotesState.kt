package com.onepercent.xnotes.feature_note.presentation.notes

import com.onepercent.core.model.Note
import com.onepercent.xnotes.feature_note.domain.util.NoteOrder
import com.onepercent.xnotes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)