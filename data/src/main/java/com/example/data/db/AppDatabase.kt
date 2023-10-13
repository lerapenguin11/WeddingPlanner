package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.entities.CategoryEntity
import com.example.data.entities.FavoriteEntity
import com.example.data.entities.Note
import com.example.data.entities.ReadyEntity

@Database(entities = [Note::class, ReadyEntity::class, CategoryEntity::class, FavoriteEntity::class], version = 10)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun readyDao() : ReadyDao
    abstract fun favDao() : FavoriteDao

    abstract fun categoryDao() : CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "new_database_10"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}