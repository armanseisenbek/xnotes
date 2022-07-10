package com.onepercent.feature.notes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.onepercent.core.domain.model.Note
import com.onepercent.feature.notes.components.NoteItem

@Composable
fun NotesList(
    notes: List<Note>
) {
    LazyColumn(
        content = {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    onNoteClick = {

                    },
                    onDeleteClick = {

                    }
                )
            }
        }
    )
}