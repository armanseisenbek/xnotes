package com.onepercent.xnotes.feature_note.domain.model

import com.onepercent.xnotes.ui.theme.*

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
) {

    companion object {
        val noteColors = listOf(
            RedOrange, LightGreen, Violet, BabyBlue, RedPink
        )
    }
}

class InvalidNoteException(message: String): Exception(message)