package com.onepercent.feature.notes.add_edit_note.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AddEditNoteTopAppBar(
    navigateBack: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = navigateBack,
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back"
                    )
                }
            )
        },
        title = {},
        elevation = 0.dp
    )
}