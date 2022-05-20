package com.onepercent.xnotes.feature_note.data.datasource

import com.onepercent.xnotes.feature_note.domain.model.Note

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