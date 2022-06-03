package com.onepercent.xnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.onepercent.core.constants.RouteConstants.NOTES_GRAPH_ROUTE
import com.onepercent.feature.notes.NotesScreen
import com.onepercent.feature.notes.navigation.NotesNavItem
import com.onepercent.feature.notes.navigation.notesNavGraph



@Composable
fun XnotesNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NOTES_GRAPH_ROUTE
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {

            notesNavGraph(navController)
        }
    )
}

//Surface(
//color = MaterialTheme.colors.background
//) {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = Screen.NotesScreen.route,
//        builder = {
//            composable(route = Screen.NotesScreen.route) {
//                NotesScreen(navController = navController)
//            }
//            composable(
//                route = Screen.AddEditNoteScreen.route
//                        + "?noteId={noteId}&noteColor={noteColor}",
//                arguments = listOf(
//                    navArgument(
//                        name = "noteId"
//                    ) {
//                        type = NavType.IntType
//                        defaultValue = -1
//                    },
//                    navArgument(
//                        name = "noteColor"
//                    ) {
//                        type = NavType.IntType
//                        defaultValue = -1
//                    }
//                )
//            ) {
//                val color = it.arguments?.getInt("noteColor") ?: -1
//
//                AddEditNoteScreen(
//                    navController = navController, noteColor = color)
//            }
//        }
//    )
//}