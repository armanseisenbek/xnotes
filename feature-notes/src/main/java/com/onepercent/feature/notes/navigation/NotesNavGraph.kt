package com.onepercent.feature.notes.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.onepercent.core.constants.RouteConstants.NOTES_GRAPH_ROUTE
import com.onepercent.feature.notes.NotesScreen
import com.onepercent.feature.notes.NotesViewModel
import com.onepercent.feature.notes.add_edit_note.AddEditNoteScreen

fun NavGraphBuilder.notesNavGraph(
    navController: NavHostController
) {
    navigation(
        route = NOTES_GRAPH_ROUTE,
        startDestination = NotesNavItem.NotesScreen.route,
        builder = {
            composable(
                route = NotesNavItem.NotesScreen.route,
                content = {
                    val notesViewModel: NotesViewModel = hiltViewModel()

                    NotesScreen(
                        state = notesViewModel.state.value,
                        event = notesViewModel::onEvent,
                        navigateToAddEditNote = {
                            navController.navigate(NotesNavItem.AddEditNoteScreen.route)
                        }
                    )
                }
            )
            composable(
                route = NotesNavItem.AddEditNoteScreen.route
                        + "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId",
                        builder = {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    ),
                    navArgument(
                        name = "noteColor",
                        builder = {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    )
                ),
                content = {
                    val color = it.arguments?.getInt("noteColor") ?: -1

                    AddEditNoteScreen(
                        noteColor = color
                    )
                }
            )
        }
    )
}