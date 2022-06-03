package com.onepercent.feature.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onepercent.core.common.DataState
import com.onepercent.core.domain.note_interactors.NoteInteractors
import com.onepercent.core.model.Note
import com.onepercent.core.common.util.NoteOrder
import com.onepercent.core.common.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel
@Inject
constructor(
    private val noteInteractors: NoteInteractors
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class
                    && state.value.noteOrder.orderType == event.noteOrder.orderType) {
                    return
                }

                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteInteractors.deleteNote.execute(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteInteractors.addNote.execute(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {

//        getNotesJob?.cancel()

//        getNotesJob =
            noteInteractors.getNotes.execute(noteOrder)
            .onEach { dataState ->
                when (dataState) {
                    is DataState.Loading -> {

                    }
                    is DataState.Data -> {
                        _state.value = state.value.copy(
                            notes = dataState.data ?: listOf(),
                            noteOrder = noteOrder
                        )
                    }
                    is DataState.Response -> {

                    }
                }
            }
            .launchIn(viewModelScope)

    }
}