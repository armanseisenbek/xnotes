package com.onepercent.core.domain.note_interactors

import com.onepercent.core.common.DataState
import com.onepercent.core.common.ProgressBarState
import com.onepercent.core.common.UIComponent
import com.onepercent.core.domain.datasource.NoteCacheDataSource
import com.onepercent.core.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DeleteNote(
    private val noteCacheDataSource: NoteCacheDataSource
) {

    fun execute(note: Note): Flow<DataState<Note>> = flow {

        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            noteCacheDataSource.deleteNote(note)

            emit(DataState.Data(note))

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