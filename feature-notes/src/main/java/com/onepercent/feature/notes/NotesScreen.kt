package com.onepercent.feature.notes

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.onepercent.feature.notes.components.AddNoteFloatingButton
import com.onepercent.feature.notes.components.NoteItem
import com.onepercent.feature.notes.components.OrderSection
import com.onepercent.feature.notes.navigation.NotesNavItem
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(
    state: NotesState,
    event: (NotesEvent) -> Unit,
    navigateToAddEditNote: (String) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            AddNoteFloatingButton {
                navigateToAddEditNote(NotesNavItem.AddEditNoteScreen.route)
            }
        },
        content = {
            Column(
                modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ) {
                NotesList(notes = state.notes)
            }

        }
    )

//    val state = viewModel.state.value
//    val scaffoldState = rememberScaffoldState()
//    val scope = rememberCoroutineScope()

//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                backgroundColor = MaterialTheme.colors.primary,
//                onClick = {
//
////                    navController.navigate(Screen.AddEditNoteScreen.route)
//                },
//                content = {
//                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
//                }
//            )
//        },
//        scaffoldState = scaffoldState,
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = "Your notes",
//                    style = MaterialTheme.typography.h4
//                )
//
//                IconButton(
//                    onClick = {
//                        event()
//                        viewModel.onEvent(NotesEvent.ToggleOrderSection)
//                    },
//                    content = {
//                        Icon(imageVector = Icons.Default.Sort, contentDescription = "Sort")
//                    }
//                )
//            }
//            AnimatedVisibility(
//                visible = state.isOrderSectionVisible,
//                enter = fadeIn() + slideInVertically(),
//                exit = fadeOut() + slideOutVertically()
//            ) {
//                OrderSection(
//                    modifier = Modifier
//                        .fillMaxWidth()
////                        .padding(vertical = 16.dp)
//                    ,
//                    noteOrder = state.noteOrder,
//                    onOrderChange = {
//                        viewModel.onEvent(NotesEvent.Order(it))
//                    }
//                )
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                content = {
//                    items(state.notes) { note ->
//                        NoteItem(
//                            modifier = Modifier.fillMaxWidth(),
//                            note = note,
//                            onNoteClick = {
//                                navigateToAddEditNote("?noteId=${note.id}&noteColor=${note.color}")
//                            },
//                            onDeleteClick = {
//                                viewModel.onEvent(NotesEvent.DeleteNote(note))
//                                scope.launch {
//                                    val result = scaffoldState.snackbarHostState.showSnackbar(
//                                        "Note deleted",
//                                        actionLabel = "Undo"
//                                    )
//                                    if (result == SnackbarResult.ActionPerformed) {
//                                        viewModel.onEvent(NotesEvent.RestoreNote)
//                                    }
//                                }
//                            }
//                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
//                }
//            )
//        }
//    }
}