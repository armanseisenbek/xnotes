package com.onepercent.xnotes

import com.onepercent.core.database.model.NoteEntity
import com.onepercent.core.model.Note

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