package com.onepercent.core.domain.note_interactors

import com.onepercent.core.common.DataState
import com.onepercent.core.common.ProgressBarState
import com.onepercent.core.common.UIComponent
import com.onepercent.core.domain.model.Note
import com.onepercent.core.common.util.NoteOrder
import com.onepercent.core.common.util.OrderType
import com.onepercent.core.domain.datasource.NoteCacheDataSource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNotes(
    private val noteCacheDataSource: NoteCacheDataSource
) {

    fun execute(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<DataState<List<Note>>> = flow {

        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val notes = noteCacheDataSource.getNotes().also { notes ->
                when (noteOrder.orderType) {
                    is OrderType.Ascending -> {
                        when(noteOrder) {
                            is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                            is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                            is NoteOrder.Color -> notes.sortedBy { it.color }
                        }
                    }
                    is OrderType.Descending -> {
                        when(noteOrder) {
                            is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                            is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                            is NoteOrder.Color ->notes.sortedByDescending { it.color }
                        }
                    }
                }
            }

            println("NOTES = $notes")

            emit(DataState.Data(notes))

        } catch (e: Exception) {
            e.printStackTrace()

            emit(
                DataState.Response(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        }

        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }
}