package com.onepercent.feature.notes.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onepercent.core.constants.RouteConstants.NOTES_GRAPH_ROUTE
import com.onepercent.feature.notes.NotesScreen
import com.onepercent.feature.notes.NotesViewModel

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

                        }
                    )
                }
            )
            composable(
                route = NotesNavItem.AddEditNoteScreen.route,
                content = {

                }
            )
        }
    )
}