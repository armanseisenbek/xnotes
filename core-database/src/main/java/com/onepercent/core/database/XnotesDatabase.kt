package com.onepercent.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onepercent.core.database.dao.NoteDao
import com.onepercent.core.database.model.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    exportSchema = true,
    version = 1
)
abstract class XnotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "xnotes_db"
    }
}