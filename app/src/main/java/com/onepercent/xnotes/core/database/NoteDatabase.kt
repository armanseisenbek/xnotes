package com.onepercent.xnotes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onepercent.xnotes.core.database.dao.NoteDao
import com.onepercent.xnotes.core.database.model.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "xnotes_db"
    }
}