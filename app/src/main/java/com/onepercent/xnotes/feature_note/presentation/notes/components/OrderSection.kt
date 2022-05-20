package com.onepercent.xnotes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.onepercent.xnotes.feature_note.domain.util.NoteOrder
import com.onepercent.xnotes.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            content = {
                OrderRadioButton(
                    text = "Title",
                    selected = noteOrder is NoteOrder.Title,
                    onSelect = {
                        onOrderChange(NoteOrder.Title(noteOrder.orderType))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                OrderRadioButton(
                    text = "Date",
                    selected = noteOrder is NoteOrder.Date,
                    onSelect = {
                        onOrderChange(NoteOrder.Date(noteOrder.orderType))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                OrderRadioButton(
                    text = "Color",
                    selected = noteOrder is NoteOrder.Color,
                    onSelect = {
                        onOrderChange(NoteOrder.Color(noteOrder.orderType))
                    }
                )
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            content = {
                OrderRadioButton(
                    text = "Ascending",
                    selected = noteOrder.orderType is OrderType.Ascending,
                    onSelect = {
                        onOrderChange(noteOrder.copy(OrderType.Ascending))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                OrderRadioButton(
                    text = "Descending",
                    selected = noteOrder.orderType is OrderType.Descending,
                    onSelect = {
                        onOrderChange(noteOrder.copy(OrderType.Descending))
                    }
                )
            }
        )
    }
}