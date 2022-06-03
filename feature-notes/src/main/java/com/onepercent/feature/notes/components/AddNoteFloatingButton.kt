package com.onepercent.feature.notes.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun AddNoteFloatingButton(
    onClick: () -> Unit,
) {

    FloatingActionButton(
        onClick = onClick,
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add note"
            )
        }
    )
}