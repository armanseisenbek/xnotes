package com.onepercent.feature.notes

import com.onepercent.core.model.Note
import com.onepercent.core.common.util.NoteOrder
import com.onepercent.core.common.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)