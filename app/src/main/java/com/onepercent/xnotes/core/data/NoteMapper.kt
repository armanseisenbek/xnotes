package com.onepercent.xnotes.core.data

import com.onepercent.core.model.Note
import com.onepercent.xnotes.core.database.model.NoteEntity

fun Note.mapToEntity() : NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        timestamp = this.timestamp,
        color = this.color
    )
}

fun NoteEntity.mapFromEntity() : Note {
    return Note(
        id = this.id,
        title = this.title,
        content = this.content,
        timestamp = this.timestamp,
        color = this.color
    )
}