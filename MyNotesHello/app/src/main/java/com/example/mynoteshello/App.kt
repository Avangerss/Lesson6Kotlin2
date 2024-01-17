package com.example.mynoteshello

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.mynoteshello.data.local.room.AppDatabase

private const val DATABASE_NAME = "note_database"

class App : Application() {

    companion object {
        var db: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}