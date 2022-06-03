package com.onepercent.feature.notes.navigation

sealed class NotesNavItem(
    val route: String
) {
    object NotesScreen: NotesNavItem(
        route = "notes_screen"
    )

    object AddEditNoteScreen: NotesNavItem(
        route = "add_edit_note_screen"
    )
}
