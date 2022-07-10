package com.onepercent.feature.notes.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onepercent.core.common.DataState

import com.onepercent.core.domain.note_interactors.NoteInteractors
//import com.onepercent.xnotes.InvalidNoteException
import com.onepercent.core.domain.model.Note
import com.onepercent.core.ui.theme.noteColors

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteInteractors: NoteInteractors,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteTitle = mutableStateOf(NoteTextFieldState(hint = "Enter title..."))
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(hint = "Enter some content"))
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf(noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                noteInteractors.getNote.execute(noteId)
                    .onEach { dataState ->
                        when (dataState) {
                            is DataState.Loading -> {

                            }
                            is DataState.Data -> {
                                val note = dataState.data!!

                                currentNoteId = note.id
                                _noteTitle.value = noteTitle.value.copy(
                                    text = note.title,
                                    isHintVisible = false
                                )
                                _noteContent.value = _noteContent.value.copy(
                                    text = note.content,
                                    isHintVisible = false
                                )
                                _noteColor.value = note.color
                            }
                            is DataState.Response -> {

                            }
                        }
                    }
                    .launchIn(viewModelScope)
            }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when(event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            _noteContent.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }
            is AddEditNoteEvent.SaveNote -> {

                noteInteractors.addNote.execute(
                    Note(
                        id = currentNoteId ?: 0,
                        title = noteTitle.value.text,
                        content = noteContent.value.text,
                        timestamp = System.currentTimeMillis(),
                        color = noteColor.value
                    )
                ).onEach { dataState ->
                    when (dataState) {
                        is DataState.Loading -> {

                        }
                        is DataState.Data -> {
                            _eventFlow.emit(UiEvent.SaveNote)
                        }
                        is DataState.Response -> {

                        }
                    }
                }
                .launchIn(viewModelScope)
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String): UiEvent()
        object SaveNote: UiEvent()
    }
}