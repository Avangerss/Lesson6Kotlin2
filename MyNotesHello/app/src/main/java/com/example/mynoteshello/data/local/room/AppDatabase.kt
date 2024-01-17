package com.example.mynoteshello.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mynoteshello.data.local.room.convertors.DateConverters
import com.example.mynoteshello.data.local.room.dao.NoteDao
import com.example.mynoteshello.data.local.room.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)

@TypeConverters(DateConverters::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}