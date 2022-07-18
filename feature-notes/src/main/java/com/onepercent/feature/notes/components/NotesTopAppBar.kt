package com.onepercent.feature.notes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable

@Composable
fun NotesTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "xnotes")
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Sort, contentDescription = "sort notes")
            }
        }
    )
}