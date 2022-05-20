package com.onepercent.xnotes.feature_note.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onepercent.xnotes.feature_note.domain.model.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "xnotes_db"
    }
}