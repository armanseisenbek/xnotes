package com.onepercent.xnotes.feature_note.presentation.notes

import com.onepercent.core.domain.util.NoteOrder
import com.onepercent.core.domain.util.OrderType
import com.onepercent.core.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)